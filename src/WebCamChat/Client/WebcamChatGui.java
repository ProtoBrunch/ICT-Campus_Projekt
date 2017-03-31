package WebCamChat.Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel webcamPanel_0_0_1;

    private JPanel panel_0_1_0;
    private JPanel panel_0_1_1;
    private JTextArea textArea_0_1_0_0;
    private JButton button_0_1_0_0;

    /**
     * Konstruktor. Alle benötigten Komponenten werden initialisiert. Für den webcamPanel wird der Parameter verwendet
     */
    public WebcamChatGui(){
        frame = new JFrame("Webcam Chat");
        panel_0 = new JPanel();

        panel_0_0 = new JPanel();
        panel_0_1 = new JPanel();

        panel_0_1_0 = new JPanel();
        panel_0_1_1 = new JPanel();

        textArea_0_1_0_0 = new JTextArea(2,10);
        button_0_1_0_0 = new JButton("Senden");
        button_0_1_0_0.addActionListener(this);
        webcamPanel_0_0_0 = new JLabel();
        webcamPanel_0_0_1 = new JLabel();
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

        panel_0_1_0.setLayout(new BoxLayout(panel_0_1_0, BoxLayout.PAGE_AXIS));
        panel_0_1_0.setBorder(new EmptyBorder(10, 10, 5, 10));
        panel_0_1_1.setLayout(new FlowLayout());
        panel_0_1_1.setBorder(new EmptyBorder(5, 10, 10, 10));

        panel_0_1_1.add(textArea_0_1_0_0);
        panel_0_1_1.add(button_0_1_0_0);

        panel_0_1.add(panel_0_1_0, "Center");
        panel_0_1.add(panel_0_1_1, "South");

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
            JLabel test = new JLabel(textArea_0_1_0_0.getText());
            textArea_0_1_0_0.setText("");
            panel_0_1_0.add(test);
            textArea_0_1_0_0.setColumns(frame.getWidth()/40);
            SwingUtilities.updateComponentTreeUI(textArea_0_1_0_0);
            SwingUtilities.updateComponentTreeUI(panel_0_1_0);
        }
    }

    /**
     * Ändert das Icon vom JLabel webcamPanel.
     * @param newImage ImageIcon welches vom Bytearray berechnet wurde.
     * @param location Wovon das Bild kommt "server" für externes Bild, "client" für das eigene
     */
    public void changeWebcamImageIcon(ImageIcon newImage, String location){
        switch(location){
            case "server":
                this.webcamPanel_0_0_0.setIcon(newImage); //Webcam Image from other client
                break;
            case "client":
                this.webcamPanel_0_0_1.setIcon(newImage); //Local Webcam Image
                break;
        }

    }
}
