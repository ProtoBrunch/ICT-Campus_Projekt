package WebCamChat.Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ClientWebcamImageListener extends Thread {
    Socket server;
    DataInputStream webcamFromServer;
    byte[] empty = null;

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
        while(true) {
            try {
                int length = webcamFromServer.readInt();
                if (length > 0) {
                    byte[] webcamIn = empty;
                    webcamIn = new byte[length];
                    webcamFromServer.readFully(webcamIn, 0, length);
                    webcamPanel.changeWebcamImageIcon(new ServerInputProcessor().byteArrayToImageIcon(webcamIn, length));
                    webcamIn = empty;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {

            } catch (OutOfMemoryError e) {

            }
        }
    }
}
