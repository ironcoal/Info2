import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;


class HighscoreDialog extends Dialog implements ActionListener {

    private Button b_akt;
    private List l_scores;
    private HighscoreContainer hc;

    public HighscoreDialog(Frame f, HighscoreContainer hc) {
        super(f, "Highscores");
        this.hc = hc;
        Panel pan = new Panel(new BorderLayout());
        b_akt = new Button("Aktualisieren");
        l_scores = new List(15, false);

        b_akt.addActionListener(this);

        pan.add(b_akt, BorderLayout.NORTH);
        pan.add(l_scores, BorderLayout.CENTER);
        add(pan);

        setSize(500,400);
        setLocation(300,300);
    }

    public void actionPerformed(ActionEvent e) {
        l_scores.removeAll();
        Iterator<Highscore> it = hc.iterator();
        while (it.hasNext()) {
            Highscore hs = it.next();
            l_scores.add(hs.getScore() + ": " + hs.getName() + " - " + hs.getDate());
        }
    }
}