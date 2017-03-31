package WebCamChat.Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by berberatr on 31.03.2017.
 */
public class ClientWebcamImageWriter extends Thread{
    Socket server;
    DataOutputStream webcamToServer;

    ClientWebcamImageWriter(Socket server){
        try{
            this.server = server;
            webcamToServer = new DataOutputStream(server.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try {
                byte[] webcamStream = ClientConnectionProvider.webcamImageByteArray;
                webcamToServer.writeInt(webcamStream.length);
                webcamToServer.write(webcamStream);
                } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e){

            }

        }
    }
}