package rmi

import java.io.Serializable

class Room: Serializable {
    private val messages = ArrayList<String>()
    private val users = ArrayList<User>()
    private var name = ""

    fun addUser(user: User)
    {
        users.add(user)
    }

    fun getAllUsers(): ArrayList<User>
    {
        return users
    }

    fun setName(name: String)
    {
        this.name = name
    }

    fun getName(): String
    {
        return name
    }

    fun postMessage(message: String)
    {
        messages.add(message)
    }

    fun getMessages(): ArrayList<String>
    {
        return messages
    }

    fun userExit(user: User)
    {
        users.remove(user)
    }
}