package folder1.View;

import folder1.App;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        App.gui.setVisible(true);
    }

}
