package rmi.interfaces

import rmi.Room
import rmi.User
import java.rmi.Remote

interface RemoteInterface: Remote{
    fun postMessage(text: String, room: Room)
    fun entryRoom(room: Room, user: User)
    fun createRoom()
}