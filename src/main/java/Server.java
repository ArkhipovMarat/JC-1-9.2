import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8080;
    private static Socket clientSocket;
    private static ServerSocket serverSocket;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Сервер запущен!");

        clientSocket = serverSocket.accept();

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        out.write("Введите ваше имя: " + "\n");
        out.flush();
        String name = in.readLine();

        out.write("Введите ваш возраст: " + "\n");
        out.flush();
        int age = Integer.parseInt(in.readLine());

        String message;

        if (age>18) {
            message = ", вы уже взрослый";
        } else {
            message = ", вы еще ребенок";
        }

        out.write(name + message + "\n");
        out.flush();

        clientSocket.close();
        in.close();
        out.close();
        serverSocket.close();
    }
}
