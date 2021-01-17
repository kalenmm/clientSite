package client.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageListener implements Runnable {
    private BufferedReader bufferedReader;
    private Storage storage;
    private String username;

    public MessageListener(Socket socket, Storage storage, String username) throws IOException {
        this.storage = storage;
        this.username = username;
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        String result = "";
        do{
            try {
                Message message = new Message();
                result = bufferedReader.readLine();
                message.setText(result);
                message.setAuthor(result.contains(username));
                storage.put(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while (!result.equals("bye"));
    }
}
