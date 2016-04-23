package Cookit;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2000);

        while (true) {
            Socket socket = server.accept();
            invoke(socket);
        }
    }

    private static void invoke(Socket socket) {
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            Object obj = is.readObject();
            List<User> mList = (List<User>)obj;

            for (User user:mList){
                System.out.println(user.getName());
                System.out.println(user.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
