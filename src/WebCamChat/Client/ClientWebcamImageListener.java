package WebCamChat.Client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ClientWebcamImageListener extends Thread {
    Socket server;
    DataInputStream webcamFromServer;

    ClientWebcamImageListener(Socket server){
        try{
            this.server = server;
            webcamFromServer = new DataInputStream(server.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try {
                int length = webcamFromServer.readInt();
                byte[] webcamIn = new byte[length];
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
