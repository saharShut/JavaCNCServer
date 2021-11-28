package cncfile;

import java.io.*;

public class CNCfile {
    String pathFile;
    File cnc_file;
    BufferedReader cnc_reader;

    public CNCfile(String pathname) {
        pathFile = pathname;

        cnc_file = new File(pathFile);

        try {
            cnc_reader = new BufferedReader(new FileReader(cnc_file));
        } catch (IOException ex){
            System.out.println("Can't open file!");
        }
    }

    public String getNextString() {
        try {
            return cnc_reader.readLine();
        } catch (IOException ex){
            System.out.println("Can't read line");
            return "";
        }
    }

    public boolean canRead(){
        boolean ready = false;
        try {
            ready = cnc_reader.ready();
        } catch (IOException ex){
            System.out.println("IO ex");
        }
        return ready;
    }
}
