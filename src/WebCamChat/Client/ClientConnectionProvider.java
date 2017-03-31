package WebCamChat.Client;

import com.github.sarxos.webcam.Webcam;

import java.awt.*;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ClientConnectionProvider {
    static byte[] webcamImageByteArray;
    static Webcam webcam;

    public static void main(String[] args) {
        String host = "localhost"; //changed IP back to localhost
        int port = 50000;

        try(Socket server = new Socket(host,port)){

            webcam = Webcam.getDefault();
            webcam.setViewSize(new Dimension(640 , 480));
            webcam.open();

            new ClientWebcamImageWriter(server).start();
            new ClientWebcamImageListener(server).start();

            while(true){
                webcamImageByteArray = new ServerInputProcessor().webcamImageToByteArray(webcam);
            }


        }catch(IOException e){
            e.printStackTrace();
        }



    }
}
