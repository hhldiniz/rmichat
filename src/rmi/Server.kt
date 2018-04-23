package rmi

import rmi.interfaces.RemoteInterface
import java.rmi.Naming
import java.rmi.server.UnicastRemoteObject
import java.util.*
import kotlin.collections.ArrayList

class Server:UnicastRemoteObject(), RemoteInterface {
    private val roomList = ArrayList<Room>()
    private val usersInRoom = Hashtable<Room, ArrayList<User>>()

    override fun createRoom() {
        val room = Room()
        roomList.add(room)
    }

    override fun entryRoom(room: Room, user: User) {
        if(usersInRoom.contains(room))
        {
            usersInRoom[room]?.add(user)
        }
    }

    override fun postMessage(text: String, room: Room) {
        room.postMessage(text)
    }
}

fun main(args: Array<String>)
{
    val server = Server()
    Naming.rebind("chat", server)
}