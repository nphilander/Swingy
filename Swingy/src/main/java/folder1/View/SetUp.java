package folder1.View;

import javax.swing.*;
import java.awt.*;

public class SetUp {
    JFrame window;
    JPanel titlePanel;
    JPanel startButton;
    JLabel titleLabel;
    JButton startBtn;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 35);
    Font startFont = new Font("Times New Roman", Font.PLAIN, 25);
    Container container; //Used to place stuff like buttons and boxes

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public SetUp() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setTitle("SWINGY GUI");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.gray);
        window.setLayout(null); //customise layout
        window.setVisible(true);
        container = window.getContentPane();

        titlePanel = new JPanel();
        titlePanel.setBounds(200, 100, 400, 80);
        titlePanel.setBackground(Color.black);

        titleLabel = new JLabel("SWINGY");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(titleFont);

        startButton = new JPanel();
        startButton.setBounds(250, 250, 300, 60);
        startButton.setBackground(Color.black);

        startBtn = new JButton("START GAME");
        startBtn.setBackground(Color.BLACK);
        startBtn.setForeground(Color.WHITE);
        startBtn.setFont(startFont);
        startBtn.addActionListener(tsHandler);


        titlePanel.add(titleLabel);
        startButton.add(startBtn);
        container.add(startButton);
        container.add(titlePanel);
    }
}
