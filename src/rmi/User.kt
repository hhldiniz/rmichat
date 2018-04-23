package rmi

import java.rmi.Naming
import java.util.*

class User(private val name: String) {

}

fun main(args: Array<String>)
{
    val scanner = Scanner(System.`in`)
    System.out.println("Digite um nome de usuário")
    val username = scanner.nextLine()
    val user = User(username)
    val remoteObject: Server = Naming.lookup("chat") as Server
    while(true)
    {
        System.out.println("Escolha uma opção")
        System.out.println("1 - Entrar em uma sala")
        System.out.println("2 - Enviar mensagem")
        System.out.println("3 - Ver usuários da sala")
        System.out.println("4 - Criar uma sala")
        System.out.println("0 - Sair")
        val op = scanner.nextInt()
        when(op)
        {
            1->
            {

            }
            2->
            {

            }
            3->
            {

            }
            4->
            {

            }
            0->
            {

            }
        }
    }
}