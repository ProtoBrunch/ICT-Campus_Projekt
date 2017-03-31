package WebCamChat.Client;

import com.github.sarxos.webcam.Webcam;

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
        WebcamChatGui webcamPanel = new WebcamChatGui();
        webcamPanel.setComponents();
        while(true){
            try {
                int length = webcamFromServer.readInt();
                System.out.println(length);
                if(length >0) {
                    byte[] webcamIn = new byte[length];
                    webcamFromServer.readFully(webcamIn, 0, length);
                    System.out.println(webcamIn.toString());
                    webcamPanel.changeWebcamImageIcon(new ServerInputProcessor().byteArrayToImageIcon(webcamIn, length));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e){

            }

        }
    }
}
