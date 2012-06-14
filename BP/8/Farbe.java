

public class Farbe extends Observable {
	private int r = 0;
	private int b = 0;
	private int g = 0;

	public setR(int v){
		r = v;	
	}
	public setG(int v){
		g = v;	
	}
	public setB(int v){
		b = v;	
	}
	public Color getC(int v){
		return Color(r,g,b);
	}
	public Color getCk(){
		return Color(256-r,256-g,256-b);
	}
}