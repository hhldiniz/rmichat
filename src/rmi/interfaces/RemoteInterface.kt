package rmi.interfaces

import rmi.Room
import rmi.User
import java.rmi.Remote
import java.rmi.RemoteException

interface RemoteInterface: Remote{
    @Throws(RemoteException::class)
    fun postMessage(text: String, room: Room)
    @Throws(RemoteException::class)
    fun entryRoom(room: Room, user: User)
    @Throws(RemoteException::class)
    fun createRoom(name: String)
    @Throws(RemoteException::class)
    fun getAllRooms(): ArrayList<Room>
    @Throws(RemoteException::class)
    fun getMyRoom(user: User): Room?
    @Throws(RemoteException::class)
    fun exitRoom(user: User)
}