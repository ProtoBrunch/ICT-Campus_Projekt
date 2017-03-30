package WebCamChat.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ClientTextWriter extends Thread{
    Socket server;
    PrintWriter outToServer;
    Scanner scanner;

    ClientTextWriter(Socket server){
        try{
            this.server = server;
            outToServer = new PrintWriter(server.getOutputStream(),true);
            scanner = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        String input;

        while(true){
            input = scanner.nextLine();
            outToServer.println(input);
        }
    }
}
