import WebCamChat.Client.StartGui;
import WebCamChat.Client.WebcamChatGui;
import com.github.sarxos.webcam.Webcam;

/**
 * Created by berberatr on 29.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Telö World.");
       /* WebcamChatGui wcg = new WebcamChatGui();
        wcg.setComponents();*/
        StartGui sg = new StartGui();
        sg.setComponents();
    }
}
