package rmi.interfaces

import rmi.Room
import java.rmi.Remote

interface RemoteInterface: Remote{
    fun postMessage(text: String)
    fun entryRoom(room: Room)
    fun createRoom()
}