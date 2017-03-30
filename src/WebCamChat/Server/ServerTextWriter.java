package WebCamChat.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ServerTextWriter extends Thread {
    Socket client;
    Scanner scanner = new Scanner(System.in);
    PrintWriter outToClient;

    ServerTextWriter(Socket client){
        try{
            this.client = client;
            outToClient = new PrintWriter(client.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run(){
        String input;
        while (true){
            input = scanner.nextLine();
            outToClient.println(input);
        }
    }
}
