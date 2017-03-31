package WebCamChat.Client;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import javax.swing.*;
import java.awt.*;

/**
 * Created by meiersila on 30.03.2017.
 */
public class StartGui {
    private JFrame frame;
    private JPanel panel_0;
    private JPanel panel_0_0;
    private JLabel ipLabel;
    private JTextArea ipTextArea;
    private JLabel portLabel;
    private JTextArea portTextArea;
    private JLabel userNameLabel;
    private JTextArea userNameTextArea;
    private JButton chatButton;
    private JButton webcamChatButton;

    public StartGui(){
        frame = new JFrame("Skipe");
        panel_0 = new JPanel();

        panel_0_0 = new JPanel();

        ipLabel = new JLabel("IP angeben");
        ipTextArea = new JTextArea(2,6);
        portLabel = new JLabel("Port angeben");
        portTextArea = new JTextArea(2,3);
        userNameLabel = new JLabel("Username angeben");
        userNameTextArea = new JTextArea(2,6);
        chatButton = new JButton("Chatraum");
        webcamChatButton = new JButton("Webcam Chatraum");
    }

    public void setComponents(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,450);

        panel_0.setLayout(new GridLayout(1,3));

        panel_0_0.setLayout(new GridLayout(4,2));

        panel_0_0.add(ipLabel);
        panel_0_0.add(ipTextArea);
        panel_0_0.add(portLabel);
        panel_0_0.add(portTextArea);
        panel_0_0.add(userNameLabel);
        panel_0_0.add(userNameTextArea);
        panel_0_0.add(chatButton);
        panel_0_0.add(webcamChatButton);

        panel_0.add(panel_0_0);

        frame.add(panel_0);

        frame.setVisible(true);
    }
}
