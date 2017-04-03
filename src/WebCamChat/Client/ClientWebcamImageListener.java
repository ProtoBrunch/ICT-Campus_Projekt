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
    private Socket server;
    private DataInputStream webcamFromServer;
    private WebcamChatGui webcamPanel;

    ClientWebcamImageListener(Socket server, WebcamChatGui wcg){
        try{
            this.server = server;
            webcamFromServer = new DataInputStream(server.getInputStream());
            webcamPanel = wcg;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try {
                int length = webcamFromServer.readInt();
                if(length > 0) {
                    byte[] webcamFromServer = new byte[length];
                    this.webcamFromServer.readFully(webcamFromServer, 0, length);
                    webcamPanel.changeWebcamImageIcon(new ServerInputProcessor().byteArrayToImageIcon(webcamFromServer, length), "server");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
