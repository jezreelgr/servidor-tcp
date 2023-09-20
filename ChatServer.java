import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//prueba de git

public class ChatServer {
    public static int PORT = 8000;
    private ServerSocket serverSocket;

    public void start() throws IOException {
        System.out.println("servidor iniciado na porta " + PORT);
        serverSocket = new ServerSocket(PORT);
        ClientConnectionLoop();
    }

    private void ClientConnectionLoop() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente" + clientSocket.getRemoteSocketAddress() + "conectou");

        }

    }

    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer();
            server.start();
        } catch (IOException ex) {
            System.out.println("erro ao iniciar o servidor " + ex.getMessage());
        }

        System.out.println("servidor finalizado");
    }
}