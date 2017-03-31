package WebCamChat.Client;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by berberatr on 31.03.2017.
 */
public class ClientWebcamImageWriter extends Thread{
    private DataOutputStream webcamToServer;

    ClientWebcamImageWriter(Socket server){
        try{
            webcamToServer = new DataOutputStream(new BufferedOutputStream(server.getOutputStream()));
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
                webcamToServer.flush();
                } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e){

            }

        }
    }
}
