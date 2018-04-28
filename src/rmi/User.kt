package rmi

import rmi.interfaces.RemoteInterface
import java.io.Serializable
import java.rmi.Naming
import java.rmi.RemoteException
import java.util.*
import kotlin.system.exitProcess

class User(private val name: String): Serializable{
    fun getName(): String
    {
        return name
    }
}

fun main(args: Array<String>)
{
    val scanner = Scanner(System.`in`)
    System.out.println("Digite um nome de usuário")
    val username = scanner.nextLine()
    val user = User(username)
    val server: RemoteInterface = Naming.lookup("rmi://localhost:8080/Server") as RemoteInterface
    while(true)
    {
        println("Escolha uma opção")
        println("1 - Entrar em uma sala")
        println("2 - Enviar mensagem")
        println("3 - Ver usuários da sala")
        println("4 - Criar uma sala")
        println("0 - Sair")
        val op = scanner.nextInt()
        try {
            when(op)
            {
                1->
                {
                    println("Salas disponíveis: ")
                    val allRooms = server.getAllRooms()
                    allRooms.forEachIndexed { index, room ->
                        println("$index - ${room.getName()}")
                    }
                    try {
                        val room = allRooms[scanner.nextInt()]
                        server.entryRoom(room, user)
                    }catch (e: ArrayIndexOutOfBoundsException)
                    {
                        println("Essa sala não existe!")
                    }
                }
                2->
                {
                    val myRoom = server.getMyRoom(user)
                    if(myRoom == null)
                        println("Você ainda não está em uma sala")
                    else
                    {
                        println("Digite uma mensagem para enviar")
                        val msgScanner = Scanner(System.`in`)
                        server.postMessage(msgScanner.nextLine(), myRoom)
                        println("Mensagem enviada!")
                        myRoom.getMessages().forEach {
                            println(it)
                        }
                    }
                }
                3->
                {
                    val myRoom = server.getMyRoom(user)
                    myRoom?.getAllUsers()?.forEachIndexed { index, userInRoom ->
                        println("$index - ${userInRoom.getName()}")
                    }
                }
                4->
                {
                    println("Digite o nome da nova sala")
                    val newRoomScanner = Scanner(System.`in`)
                    val roomName = newRoomScanner.nextLine()
                    server.createRoom(roomName)
                }
                0->
                {
                    server.exitRoom(user)
                    exitProcess(0)
                }
            }

        }catch (e: RemoteException)
        {
            e.printStackTrace()
            println("Um erro ocorreu. Verifique sua conexão")
        }
    }
}