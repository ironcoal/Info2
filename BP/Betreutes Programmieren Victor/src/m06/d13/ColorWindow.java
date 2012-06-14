

import java.awt.*;

import java.util.Observer;
import java.util.Observable;

class ColorWindow extends Dialog
                  implements Observer
{
    private static final long serialVersionUID = 1;

    private Boolean komplement;

    public ColorWindow(Frame owner, Farbe farbe, Boolean komplement)
    {
        super(owner, "Farbe");

        this.komplement = komplement;

        farbe.addObserver(this);
        this.setzeFarbe(farbe);

        this.setPreferredSize(new Dimension(250, 250));
        this.pack();
        this.setVisible(true);
    }

    public void update(Observable farbe, Object obj)
    {
        this.setzeFarbe((Farbe) farbe);
    }

    private void setzeFarbe(Farbe farbe)
    {
        if (this.komplement)
            this.setBackground(farbe.getCk());
        else
            this.setBackground(farbe.getC());
    }
}
