import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "192.168.1.3";
    private Socket clientSocket;
    private Scanner scanner;

    public ChatClient() {
        scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        clientSocket = new Socket(SERVER_ADDRESS, ChatServer.PORT);
        System.out.println("cliente conectando ao servidorem " + SERVER_ADDRESS + ":" + ChatServer.PORT);
        messegeLoop();
    }

    private void messegeLoop() {
        String msg;
        do {
            System.out.print("digite uma mensagem (ou sair para finalizar): ");
            msg = scanner.nextLine();
        } while (!msg.equalsIgnoreCase("sair"));

    }

    public static void main(String[] args) {

        try {
            ChatClient client = new ChatClient();
            client.start();
        } catch (IOException ex) {
            System.out.println("erro ao iniciar o cliente" + ex.getMessage());
        }
        System.out.println("Cliente finalizado");
    }
}