package client.servlet;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage instance;
    private List<Message> storage = new ArrayList<>();
    private Boolean isBlocked=false;

    private Storage() {
    }

    public static Storage Build(){
        if (instance == null){
            instance = new Storage();
        }
        return instance;
    }

    public synchronized void put(Message message){
        storage.add(message);
    }

    public Boolean isBlocked() {
        return this.isBlocked;
    }

    public void setBlocked(Boolean s){
        this.isBlocked = s;
    }

    public List<Message> getStorage() {
        return storage;
    }

    public void setStorage(List<Message> storage) {
        this.storage = storage;
    }
}
