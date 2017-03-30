package WebCamChat.Client;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by meiersila on 30.03.2017.
 * WebcamChatGui welches sich beim Verbinden mit einem anderen Client öffnet.
 */
public class WebcamChatGui implements ActionListener {
    private JFrame frame;

    private JPanel panel_0;

    private JPanel panel_0_0;
    private JPanel panel_0_1;

    private JLabel webcamPanel_0_0_0;
    private JLabel webcamPanel_0_0_1; // Changed Object-Type from Webcam to JLabel for testing purposes

    private JLabel label_0_1_0;
    private JPanel panel_0_1_0;
    private JTextArea textArea_0_1_0_0;
    private JButton button_0_1_0_0;

    /**
     * Konstruktor. Alle benötigten Komponenten werden initialisiert. Für den webcamPanel wird der Parameter verwendet
     * @param webcam Verwendete Webcam
     */
    public WebcamChatGui(Webcam webcam){
        frame = new JFrame("Webcam Chat");
        panel_0 = new JPanel();

        panel_0_0 = new JPanel();
        panel_0_1 = new JPanel();

        panel_0_1_0 = new JPanel();
        label_0_1_0 = new JLabel("testasdfasdfasdfasdfasdfasdfdsfsdfasdf");

        textArea_0_1_0_0 = new JTextArea("test");
        button_0_1_0_0 = new JButton("Senden");
        button_0_1_0_0.addActionListener(this);
        webcamPanel_0_0_0 = new JLabel();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcamPanel_0_0_1 = new JLabel(); //changed Webcam object for testing purposes to Jlabel-object
    }

    /**
     * Wird aufgerufen, um das Gui anzuzeigen und die Komponenten im Frame zusetzen.
     */
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

    /**
     * Reaktion auf Buttongedrückt.
     * @param e Event, in diesem Fall vom Button
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_0_1_0_0) {
            System.out.println("Button got pressed!");
        }
    }

    /**
     * Ändert das Icon vom JLabel webcamPanel.
     * @param newImage ImageIcon welches vom Bytearray berechnet wurde.
     */
    public void changeWebcamImageIcon(ImageIcon newImage){
        this.webcamPanel_0_0_0.setIcon(newImage);
    }
}
