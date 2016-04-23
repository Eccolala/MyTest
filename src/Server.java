import java.net.ServerSocket;


public class Server {
    public static void main(String[] args) {
        ServerSocket socket;
        try {
            socket = new ServerSocket(2000);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
