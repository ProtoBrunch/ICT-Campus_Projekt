package WebCamChat.Client;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by meiersila on 30.03.2017.
 */
public class WebcamChatGui {
    private JFrame frame;

    private JPanel panel_0;

    private JPanel panel_0_0;
    private JPanel panel_0_1;

    private JLabel webcamPanel_0_0_0;
    private WebcamPanel webcamPanel_0_0_1;

    private JLabel label_0_1_0;
    private JPanel panel_0_1_0;
    private JTextArea textArea_0_1_0_0;
    private JButton button_0_1_0_0;

    public WebcamChatGui(Webcam webcam){
        frame = new JFrame("Webcam Chat");
        panel_0 = new JPanel();

        panel_0_0 = new JPanel();
        panel_0_1 = new JPanel();

        panel_0_1_0 = new JPanel();
        label_0_1_0 = new JLabel();

        textArea_0_1_0_0 = new JTextArea();
        button_0_1_0_0 = new JButton("Senden");
        webcamPanel_0_0_0 = new JLabel();
        webcamPanel_0_0_1 = new WebcamPanel(webcam);
    }

    public void setComponents(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,450);

        panel_0.setLayout(new GridLayout(1,2));

        panel_0_0.setLayout(new GridLayout(2,1));
        panel_0_1.setLayout(new BorderLayout());

        panel_0_1_0.setLayout(new FlowLayout());

        panel_0_1_0.add(textArea_0_1_0_0);
        panel_0_1_0.add(button_0_1_0_0);

        panel_0_1.add(label_0_1_0, "Center");
        panel_0_1.add(panel_0_1_0, "South");

        panel_0_0.add(webcamPanel_0_0_0);
        panel_0_0.add(webcamPanel_0_0_1);

        panel_0.add(panel_0_0);
        panel_0.add(panel_0_1);

        frame.add(panel_0);

        frame.setVisible(true);
    }

    public void changeWebcamImageIcon(ImageIcon newImage){
        this.webcamPanel_0_0_0.setIcon(newImage);
    }
}
