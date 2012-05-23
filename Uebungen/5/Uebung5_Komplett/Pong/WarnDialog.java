
import java.awt.*;
import java.awt.event.*;

class WarnDialog extends Dialog implements ActionListener{

    Button b;

    public WarnDialog(Window w, String s) {
        super((Frame) w, "", true);
        Panel pan = new Panel(new GridLayout(0,1));
        pan.add(new Label(s));
        b = new Button("Schliessen");
        b.addActionListener(this);
        pan.add(b);
        add(pan);
        setLocation(300,300);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

}