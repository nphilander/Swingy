package folder1.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Gui extends JFrame{
    public static InputHandler inputHandler;
    final JTextField textField = new JTextField(30);

//    private JButton button1;
   // TitleScreenHandler tsHandler = new TitleScreenHandler();
  //  private MyActionListener myActionListener;


    public void game() throws IOException {
        setSize(900, 700);
        setTitle("SWINGY GUI");
        setBackground(Color.MAGENTA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea output = new JTextArea();
        output.setEditable(false); //Setting the gui output to not be edited
        add( new JScrollPane(output)); //adding a scroll bar so I can see more content

        PrintStream outPut = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                output.append(""+(char)(b & 0xFF));
            }
        });
        System.setOut(outPut);

/////////////

        PipedOutputStream printOut = new PipedOutputStream();
        final PrintWriter writer = new PrintWriter(printOut);
        inputHandler = new InputHandler(printOut);

//        final JTextField textField = new JTextField(30);
        final JButton button = new JButton("OK");
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
        ///////ends here
        setLookAndFeel();
        //setVisible(true); // always last
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