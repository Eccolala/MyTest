import java.io.PrintWriter;
import java.net.Socket;


public class Client {

    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket( "192.168.1.109", 2000);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.print("Hello 郭宇轩");
            writer.flush();
            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}