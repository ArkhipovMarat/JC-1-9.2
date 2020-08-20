import java.io.*;
import java.net.Socket;

public class Client {
    public static final int PORT = 8080;
    private static Socket clientSocket;
    private static BufferedReader keyboard;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        clientSocket = new Socket("netology.homework", PORT);
        keyboard = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        String line;
        System.out.println("Соединение с сервером...");
        System.out.println("------------------------");

        while (true) {
            line = in.readLine();
            System.out.println(line);
            if (line.contains("ребенок") || line.contains("взрослый")) break;

            line = keyboard.readLine();
            out.write(line + "\n");
            out.flush();
        }


        clientSocket.close();
        keyboard.close();
        in.close();
        out.close();
        System.out.println("------------------------");
        System.out.println("Завершение...");
    }
}
