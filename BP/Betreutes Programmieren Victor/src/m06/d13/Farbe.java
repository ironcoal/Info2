

import java.awt.Color;

import java.util.Observable;
import java.util.HashMap;

class Farbe extends Observable
{
    private HashMap<Character, Integer> channels;

    public Farbe()
    {
        channels = new HashMap<Character, Integer>();
        channels.put('r', 0);
        channels.put('g', 0);
        channels.put('b', 0);

        this.setChanged();
        this.notifyObservers();
    }

    public void setR(Integer value)
    {
        this.channels.put('r', value);

        this.setChanged();
        this.notifyObservers();
    }

    public void setG(Integer value)
    {
        this.channels.put('g', value);

        this.setChanged();
        this.notifyObservers();
    }

    public void setB(Integer value)
    {
        this.channels.put('b', value);

        this.setChanged();
        this.notifyObservers();
    }

    public Color getC()
    {
        return new Color(channels.get('r'),
                         channels.get('g'),
                         channels.get('b'));
    }

    public Color getCk()
    {
        return new Color(255 - channels.get('r'),
                         255 - channels.get('g'),
                         255 - channels.get('b'));
    }
}
