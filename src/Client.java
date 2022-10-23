import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        int counter = 1;
        try(Socket socket = new Socket("localhost", 1020)){
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            int response;

            while (counter < 10) {
                outputStream.write(counter);
                outputStream.flush();
                System.out.println("Отправленно: " + counter);
                response = inputStream.read();
                System.out.println("Пришло: " + response);
                counter = response + 1;
            }
        }
    }
}
