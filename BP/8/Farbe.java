import java.util.*;
import java.awt.*;

public class Farbe extends Observable {
	private int r = 0;
	private int b = 0;
	private int g = 255;


	public void setR(int v){
		r = v;
		this.setChanged();
        this.notifyObservers();
	}
	public void setG(int v){
		g = v;	
		this.setChanged();
        this.notifyObservers();
	}
	public void setB(int v){
		b = v;	
		this.setChanged();
        this.notifyObservers();
	}
	public Color getC(){
		return new Color(r,g,b);
	}
	public Color getCk(){
		return new Color(255-r,255-g,255-b);
	}
}