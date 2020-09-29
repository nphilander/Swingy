package folder1.View;

import folder1.App;
import folder1.View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TitleScreenHandler implements ActionListener {
    public void actionPerformed(ActionEvent event){
            App.gui.setVisible(true);
    }

}
