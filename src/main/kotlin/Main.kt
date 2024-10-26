import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

/*
Run codecrafters-redis-kotlin.
 */
fun main(args: Array<String>) {
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.err.println("Logs from your program will appear here!")

    var serverSocket = ServerSocket(6379)
     // Since the tester restarts your program quite often, setting SO_REUSEADDR
     // ensures that we don't run into 'Address already in use' errors
     serverSocket.reuseAddress = true

    while (true) {
        val socket = serverSocket.accept() // Wait for connection from client.
        handleConnection(socket)
    }
}

fun handleConnection(socket: Socket) {
    println("accepted new connection")
    PrintWriter(socket.getOutputStream(), false).use {
        it.println("+PONG\r")
    }
}
