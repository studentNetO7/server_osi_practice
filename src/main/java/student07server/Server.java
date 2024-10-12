package student07server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer PORT = 8085;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("New connection accepted");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

//                  Шаг 1: запрос имени
                    out.println("Write your name:");
                    final String name = in.readLine(); //сохраняет имя

//                  Шаг 2: запрос категории возраста
                    out.println("Are you a child? (yes/no)");
                    String response = in.readLine(); // сохраняет ответ

//                  Шаг 3: Ответ на основе возраста
                    if ("yes".equalsIgnoreCase(response)) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                    } else {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
                    }
//                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
//                    String infoFromClient = in.readLine();
//                    System.out.printf("Новое подключение принято. Клиентская информация: %s, порт %d%n", name, clientSocket.getPort());
//                    out.println(String.format("Порт клиента:", clientSocket.getPort()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}