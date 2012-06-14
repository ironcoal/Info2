

import java.awt.*;

import java.util.Observer;
import java.util.Observable;

import java.util.Map;
import java.util.HashMap;

class StringWindow extends Dialog
                   implements Observer
{
    private static final long serialVersionUID = 2;

    private Boolean komplement;
    private Map<Character, Label> labels;

    public StringWindow(Frame owner, Farbe farbe, Boolean komplement)
    {
        super(owner, "Farbe");

        this.komplement = komplement;

        labels = new HashMap<Character, Label>();
        labels.put('r', new Label("0"));
        labels.put('g', new Label("0"));
        labels.put('b', new Label("0"));

        farbe.addObserver(this);
        this.setzeStrings(farbe);

        this.setLayout(new GridLayout(1, 3));

        for (Map.Entry<Character, Label> entry: labels.entrySet()) {
            this.add(entry.getValue());
        }

        this.setPreferredSize(new Dimension(250, 50));
        this.pack();
        this.setVisible(true);
    }

    public void update(Observable farbe, Object obj)
    {
        this.setzeStrings((Farbe) farbe);
    }

    private void setzeStrings(Farbe farbe)
    {
        if (this.komplement) {
            Color c = farbe.getCk();

            labels.get('r').setText(" " + c.getRed());
            labels.get('g').setText(" " + c.getGreen());
            labels.get('b').setText(" " + c.getBlue());
        }
        else {
            Color c = farbe.getC();

            labels.get('r').setText(" " + c.getRed());
            labels.get('g').setText(" " + c.getGreen());
            labels.get('b').setText(" " + c.getBlue());
        }
    }
}
