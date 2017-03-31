package WebCamChat.Server;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ServerWebcamImageWriter extends Thread{
    private Socket clientProvidingImage;
    private Socket clientReceivingImage;
    private DataInputStream inFromProvider;
    private DataOutputStream outToReceiver;
    private byte[] webcamStream;


    ServerWebcamImageWriter(Socket clientProvidingImage, Socket clientReceivingImage){
        try{
            this.clientProvidingImage = clientProvidingImage;
            inFromProvider = new DataInputStream(clientProvidingImage.getInputStream());
            this.clientReceivingImage = clientReceivingImage;
            outToReceiver = new DataOutputStream(clientReceivingImage.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run(){
        int length;

        while(true){
            try {
            length = inFromProvider.readInt();
            if(length > 0)
                webcamStream = new byte[length];
                inFromProvider.readFully(webcamStream ,0, length);
                outToReceiver.write(length);
                outToReceiver.write(webcamStream);
                outToReceiver.flush();
            } catch (SocketException e){
                this.interrupt();
            } catch(EOFException eof){

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
