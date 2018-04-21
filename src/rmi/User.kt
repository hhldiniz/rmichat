package rmi

import java.util.*

class User(private val name: String) {

}

fun main(args: Array<String>)
{
    val scanner = Scanner(System.`in`)
    System.out.println("Digite um nome de usuário")
    val username = scanner.nextLine()
    val user = User(username)
}