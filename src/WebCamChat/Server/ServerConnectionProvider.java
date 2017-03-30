package WebCamChat.Server;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ServerConnectionProvider extends Thread{

    public static void main(String[] args) {
        int port = 50000;

        try(ServerSocket server = new ServerSocket(port)){
            System.out.println("Server online.");
            String ipAdress = Inet4Address.getLocalHost().getHostAddress();
            System.out.println("Server Adress is: "+ipAdress+":"+port);

            while(true){
                Socket client = server.accept();
                new ServerTextListener(client).start();
                new ServerTextWriter(client).start();
                new ServerWebcamImageWriter(client).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
