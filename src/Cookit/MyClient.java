package Cookit;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class MyClient {

    private final static Logger logger = Logger.getLogger(MyClient.class.getName());

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            Socket socket = null;
            ObjectOutputStream os = null;
            ObjectInputStream is = null;

            try {
                socket = new Socket("192.168.1.109", 2000);

                os = new ObjectOutputStream(socket.getOutputStream());
                User user = new User("user_" + i, "password_" + i);
                os.writeObject(user);
                os.flush();

//                is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
//                Object obj = is.readObject();
//                if (obj != null) {
//                    user = (User)obj;
//                    System.out.println("user: " + user.getName() + "/" + user.getPassword());
//                }
            } catch(IOException ex) {
            } finally {
                try {
                    is.close();
                } catch(Exception ex) {}
                try {
                    os.close();
                } catch(Exception ex) {}
                try {
                    socket.close();
                } catch(Exception ex) {}
            }
        }
    }
}