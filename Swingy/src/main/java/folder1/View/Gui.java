package folder1.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Gui extends JFrame{
    public static InputHandler inputHandler;
    final JTextField textField = new JTextField(20);

    public void game() throws IOException {
        setSize(900, 700);
        setTitle("SWINGY GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea output = new JTextArea();
        output.setFont(new Font("Verdana", Font.PLAIN, 15));
        output.setBackground(Color.PINK);
        output.setEditable(false); //Setting the gui output to not be edited
        add( new JScrollPane(output)); //adding a scroll bar so I can see more content

        PrintStream outPut = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                output.append(""+(char)(b & 0xFF));
            }
        });
        System.setOut(outPut);

        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBackground(Color.gray);
        textField.setFont(new Font("Arial", Font.BOLD, 25));

        PipedOutputStream printOut = new PipedOutputStream();
        final PrintWriter writer = new PrintWriter(printOut);
        inputHandler = new InputHandler(printOut);
        final JButton button = new JButton("Press to load");

        button.setFont(new Font("Arial", Font.BOLD, 40));
        button.setBackground(Color.magenta);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Change to key listener
                String data = textField.getText();
                writer.println(data);
                writer.flush();
            }
        });
        getContentPane().setLayout(new GridLayout(3, 1));
        add(textField); //adds the textfield to type in
        add(button);
        setLookAndFeel();
    }
    public static void setLookAndFeel() {
                 try {
                         UIManager.setLookAndFeel(
                                    "javax.swing.plaf.nimbus.NimbusLookAndFeel"
                         );
                     } catch (Exception exc) {
                         // ignore error
                     }
             }

    public String getInput() {
        String inPut = inputHandler.scanner.nextLine();
        textField.setText("");
        return inPut;
       // return scanner.nextLine();
    }
}