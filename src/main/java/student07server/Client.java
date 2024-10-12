package student07server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("netology.homework", Server.PORT);
             PrintWriter printWriterClient = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader bufferedReaderClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

//            Шаг 1: Чтение запроса имени
            System.out.println(bufferedReaderClient.readLine()); // выводим запрос имени в консоль
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String name = userInput.readLine();
            printWriterClient.println(name);// Отправка имени

//            Шаг 2: Чтение запроса категории возраста
            System.out.println(bufferedReaderClient.readLine());// выводим запрос категории возраста в консоль
            String myResponse = userInput.readLine();
            printWriterClient.println(myResponse);// Отправка "yes/no"

//            Шаг 3: Получение ответа сервера
            System.out.println(bufferedReaderClient.readLine());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
