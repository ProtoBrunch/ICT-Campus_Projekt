package WebCamChat.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ServerTextListener extends Thread{
    private Socket client;
    private BufferedReader inFromClient;

    ServerTextListener(Socket client){
        try{
            this.client = client;
            inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                System.out.println(inFromClient.readLine());
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
