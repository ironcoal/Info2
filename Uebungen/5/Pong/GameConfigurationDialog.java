import java.awt.*;
import java.awt.event.*;

class GameConfigurationDialog extends Dialog implements ActionListener {
    
    TextField tf_score;
    TextField tf_speed;
    TextField tf_acc;
    Button ok;
    Button abbrechen;
    Configuration config;

    public GameConfigurationDialog(Frame f, Configuration config) {
        super(f, "Konfigurationen");
        this.config = config;
        Panel pan = new Panel(new GridLayout(0,2));
        pan.add(new Label("Siegpunkte:"));
        pan.add(tf_score = new TextField());
        pan.add(new Label("Ballgeschwindigkeit: "));
        pan.add(tf_speed = new TextField());
        pan.add(new Label("Beschleunigung: "));
        pan.add(tf_acc = new TextField());
        pan.add(ok = new Button("OK"));
        pan.add(abbrechen = new Button("Abbrechen"));

        ok.addActionListener(this);
        abbrechen.addActionListener(this);
        load();
        add(pan);

        pack();
        setLocation(300,300);
        setVisible(true);
    }

    private void save() {
        try {
            config.setWinScore(Integer.parseInt(tf_score.getText()));
            config.setInitialBallSpeed(Double.parseDouble(tf_speed.getText()));
            config.setBallSpeedup(Double.parseDouble(tf_acc.getText()));
        } catch (Exception ex) {
            WarnDialog warn = new WarnDialog(this, "Ungültige Eingabe!");
        }
        
    }

    private void load() {
        tf_score.setText(Integer.toString(config.getWinScore()));
        tf_speed.setText(Double.toString(config.getInitialBallSpeed()));
        tf_acc.setText(Double.toString(config.getBallSpeedup()));
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            save();
            dispose();
        } else {
            dispose();
        }
    }
}