package WebCamChat.Client;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

/**
 * Created by meiersila on 30.03.2017.
 */
public class LocalCam {
    private WebcamPanel webcamPanel;
    private Webcam webcam;

    public LocalCam(WebcamPanel webcamPanel){
        this.webcam = Webcam.getDefault();
        this.webcamPanel = webcamPanel;
    }

    public WebcamPanel getWebcamPanel() {
        return webcamPanel;
    }

    public void setWebcamPanel(WebcamPanel webcamPanel) {
        this.webcamPanel = webcamPanel;
    }
}
