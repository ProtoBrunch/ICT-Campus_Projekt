package WebCamChat.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ClientTextListener extends Thread {
    Socket server;
    BufferedReader inFromServer;

    ClientTextListener(Socket server){
        try{
            this.server = server;
            inFromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while (true) {
            try {
                System.out.println(inFromServer.readLine());
            } catch (SocketException se){
                System.out.println("Lost Connection to Server");
                this.interrupt();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
