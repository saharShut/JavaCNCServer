package iowifi;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPmessanger {
    private String serverName = "192.168.0.105";
    private int port = Integer.parseInt("5555");
    Socket client;
    BufferedWriter out;
    BufferedReader input;

    public TCPmessanger(String ip, int port) {
        this.serverName = ip;
        this.port = port;

        System.out.println("Подключение к " + serverName + " на порт " + port);
        try {
            client = new Socket(serverName, port);

            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        } catch (UnknownHostException ex){
            System.out.println("Unknown Host Exeption");
        } catch (IOException ex){
            System.out.println("IO exception");
        }
    }

    public void sendMessage(String msg){
        try{
            System.out.println("> " + msg);
            out.write(msg + "\r\n");
            out.flush();
        } catch (IOException ex){
            System.out.println("IO exception send message");
        }
    }

    public void receiveMessage(){
        try{
            System.out.println("< " + input.readLine());
            System.out.println("< " + input.readLine());

        } catch (IOException ex){
            System.out.println("IO exception send message");
        }
    }

    public void sendAndRecieve(String msg){
        sendMessage(msg);
        receiveMessage();
    }


    public void close(){
        try {
            out.close();
            input.close();
            client.close();
        } catch (IOException ex){
            System.out.println("Can't close");
        }
    }
}
