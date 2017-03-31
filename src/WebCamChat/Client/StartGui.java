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
    private JPanel panel_0_1;
    private JPanel panel_0_2;
    private JPanel panel_0_3;
    private JPanel panel_0_4;
    private JPanel panel_0_5;
    private JPanel panel_0_6;
    private JPanel panel_0_7;
    private JPanel panel_0_8;
    private JPanel fillPanel;
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

        fillPanel = new JPanel();
        panel_0_0 = new JPanel();
        panel_0_1 = new JPanel();
        panel_0_2 = new JPanel();
        panel_0_3 = new JPanel();
        panel_0_4 = new JPanel();
        panel_0_5 = new JPanel();
        panel_0_6 = new JPanel();
        panel_0_7 = new JPanel();
        panel_0_8 = new JPanel();

        ipLabel = new JLabel("IP angeben");
        ipTextArea = new JTextArea(1,10);
        portLabel = new JLabel("Port angeben");
        portTextArea = new JTextArea(1,10);
        userNameLabel = new JLabel("Username angeben");
        userNameTextArea = new JTextArea(1,10);
        chatButton = new JButton("Chatraum");
        webcamChatButton = new JButton("Webcam Chatraum");
    }

    public void setComponents(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,450);

        panel_0.setLayout(new GridLayout(1,3));

        panel_0_0.setLayout(new GridLayout(4,2));

        panel_0_1.add(ipLabel);
        panel_0_2.add(ipTextArea);
        panel_0_3.add(portLabel);
        panel_0_4.add(portTextArea);
        panel_0_5.add(userNameLabel);
        panel_0_6.add(userNameTextArea);
        panel_0_7.add(chatButton);
        panel_0_8.add(webcamChatButton);

        panel_0_0.add(panel_0_1);
        panel_0_0.add(panel_0_2);
        panel_0_0.add(panel_0_3);
        panel_0_0.add(panel_0_4);
        panel_0_0.add(panel_0_5);
        panel_0_0.add(panel_0_6);
        panel_0_0.add(panel_0_7);
        panel_0_0.add(panel_0_8);

        panel_0.add(panel_0_0);
        panel_0.add(fillPanel);
        panel_0.add(fillPanel);

        frame.add(panel_0);

        frame.setVisible(true);
    }
}
