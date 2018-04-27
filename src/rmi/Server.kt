package rmi

import rmi.interfaces.RemoteInterface
import java.io.IOException
import java.rmi.Naming
import java.rmi.registry.LocateRegistry
import java.rmi.server.UnicastRemoteObject

class Server:UnicastRemoteObject(), RemoteInterface {
    private val roomList = ArrayList<Room>()

    override fun createRoom(name: String) {
        val room = Room()
        room.setName(name)
        roomList.add(room)
    }

    override fun getMyRoom(user: User): Room? {
        roomList.forEach{
            if (it.getAllUsers().contains(user))
            {
                return it
            }
        }
        return null
    }

    override fun exitRoom(user: User) {
        roomList.forEach{
            val userList = it.getAllUsers()
            if(userList.contains(user))
            {
                it.userExit(user)
            }
        }
    }

    override fun entryRoom(room: Room, user: User) {
        room.addUser(user)
    }

    override fun getAllRooms(): ArrayList<Room> {
        return roomList
    }

    override fun postMessage(text: String, room: Room) {
        room.postMessage(text)
    }
}

fun main(args: Array<String>)
{
    try {
        val server = Server()
        LocateRegistry.createRegistry(8080)
        Naming.rebind("rmi://localhost:8080/Server", server)
        println("Chat server online!")
    }catch (e: IOException)
    {
        e.printStackTrace()
    }
}
