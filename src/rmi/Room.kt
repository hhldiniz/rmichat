package rmi

class Room {
    private val messages = ArrayList<String>()
    private val users = ArrayList<User>()

    fun addUser(user: User)
    {
        users.add(user)
    }
}