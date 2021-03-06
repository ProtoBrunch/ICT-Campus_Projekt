package WebCamChat.Server;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ServerWebcamImageWriter extends Thread{
    private Socket client;
    private DataOutputStream outToClient;
    private Webcam webcam;

    ServerWebcamImageWriter(Socket client){
        try{
            this.client = client;
            outToClient = new DataOutputStream(client.getOutputStream());
            webcam = Webcam.getDefault();
            webcam.setViewSize(new Dimension(640 , 480));
            webcam.open();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run(){
        byte[] webcamStream;
        while(true){
            webcamStream = webcamImageToByteArray(webcam);
            try {
                outToClient.writeInt(webcamStream.length); // added this tidbit
                outToClient.write(webcamStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] webcamImageToByteArray(Webcam webcam){
        ByteBuffer byteBuffer = webcam.getImageBytes();
        byte[] data = new byte[byteBuffer.capacity()];
        ((ByteBuffer) byteBuffer.duplicate().clear()).get(data);
        return data;
    }


}
