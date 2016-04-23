package Cookit;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Client {
    public static void main(String[] args){
        List<User> mList = new ArrayList<User>();
        for (int i = 0;i<50;i++){
            String name = "user" + i;
            String pwd = "password" + i;
            mList.add(new User(name,pwd));
        }

        try {
            Socket socket = new Socket("192.168.1.109",2000);
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(mList);
            os.flush();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
