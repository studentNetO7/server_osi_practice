package student07server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localHost", Server.PORT);
             PrintWriter printWriterClient = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            printWriterClient.println("Петя!");
            System.out.println("Ответ сервера:" + bufferedReader.readLine());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
