package main;

import cncfile.CNCfile;
import iowifi.TCPmessanger;

import java.net.*;
import java.io.*;

public class CNCServer {

    public static void main(String[] args){

        //открываем файл с кодом и херачим его по TCP соединению
        CNCfile f = new CNCfile("res\\CVC.cnc");

        TCPmessanger tcp_client = new TCPmessanger("192.168.0.105", 5555);

        while (f.canRead())
            tcp_client.sendAndRecieve(f.getNextString());

        System.out.println("End programm");

    }
}
