

import java.awt.*;
import java.awt.event.*;

import java.util.Map;
import java.util.HashMap;

class ControllerWindow extends Frame
                       implements AdjustmentListener
{
    private static final long serialVersionUID = 0;

    private Farbe farbe;
    private Map<Character, Scrollbar> scrollbars;

    public ControllerWindow()
    {
        scrollbars = new HashMap<Character, Scrollbar>();
        scrollbars.put('r', new Scrollbar(Scrollbar.HORIZONTAL, 0, 25, 0, 280));
        scrollbars.put('g', new Scrollbar(Scrollbar.HORIZONTAL, 0, 25, 0, 280));
        scrollbars.put('b', new Scrollbar(Scrollbar.HORIZONTAL, 0, 25, 0, 280));

        for (Map.Entry<Character, Scrollbar> entry: scrollbars.entrySet()) {
            Scrollbar bar = entry.getValue();
            bar.addAdjustmentListener(this);
            this.add(bar);
        }

        farbe = new Farbe();
        new ColorWindow(this, farbe, false).setLocation(400, 100);
        new ColorWindow(this, farbe, true).setLocation(700, 100);
        new StringWindow(this, farbe, false).setLocation(400, 375);
        new StringWindow(this, farbe, true).setLocation(700, 375);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                dispose();
                System.exit(0);
            }
        });

        this.setLayout(new GridLayout(3, 1));
        this.setPreferredSize(new Dimension(550, 100));
        this.setLocation(400, 450);
        this.pack();
        this.setVisible(true);
    }

    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        Scrollbar r = scrollbars.get('r'),
                  g = scrollbars.get('g'),
                  b = scrollbars.get('b');

        if (e.getSource().equals(r))
            farbe.setR(r.getValue());

        else if (e.getSource().equals(g))
            farbe.setG(g.getValue());

        else if (e.getSource().equals(b))
            farbe.setB(b.getValue());
    }

    public static void main(String[] args)
    {
        new ControllerWindow();
    }
}
