package WebCamChat.Client;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by berberatr on 30.03.2017.
 */
public class ClientConnectionProvider {
    private String host;
    private int port;
    private String username;
    private Socket server;
    private WebcamChatGui wcg;

    public ClientConnectionProvider(String host, int port, String username, WebcamChatGui wcg){
        this.host = host;
        this.port = port;
        this.username = username;
        this.wcg = wcg;
        this.server = null;
    }

    public void startNewServer(){
        try{
            server = new Socket(host, port);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //new ClientTextWriter(server).start();
        //new ClientTextListener(server).start();
        new ClientWebcamImageListener(server, wcg).start();
    }
}

