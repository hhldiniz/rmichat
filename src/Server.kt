import rmi.Room
import rmi.User
import rmi.interfaces.RemoteInterface
import java.util.*
import kotlin.collections.ArrayList

class Server: RemoteInterface {
    private val roomList = ArrayList<Room>()
    private val usersInRoom = Hashtable<Room, ArrayList<User>>()

    override fun createRoom() {
        val room = Room()
        roomList.add(room)
    }

    override fun entryRoom(room: Room) {

    }

    override fun postMessage(text: String) {

    }
}

fun main(args: Array<String>)
{

}