package client.servlet;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Connection {
    private static Connection instance;
    private Socket socket = new Socket("localhost", 5005);
    private PrintWriter dout;
    private String username;
    private Connection() throws IOException {
        dout = new PrintWriter(socket.getOutputStream(), true);
    }
    public static Connection Build() throws IOException {
        if (instance == null){
            instance = new Connection();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void login() {
        dout.println(username);
    }

    public void sendMessage(String message){
        dout.println(message);
    }

    public void exit() {
        dout.println("bye");
        dout.close();
    }

//    public List<Message> getMessages(){
//        Storage storage = new Storage();

//    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }


}
