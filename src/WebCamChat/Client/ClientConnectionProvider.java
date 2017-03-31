package WebCamChat.Client;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ClientConnectionProvider {

    public static void main(String[] args) {
        String host = "172.16.2.137"; //changed IP back to localhost
        int port = 50000;
        Socket server = null;

        try{
            server = new Socket(host,port);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //new ClientTextWriter(server).start();
        //new ClientTextListener(server).start();
        new ClientWebcamImageListener(server).start();

    }
}
