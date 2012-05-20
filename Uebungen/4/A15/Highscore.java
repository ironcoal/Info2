import java.util.date;
class Highscore {
	private String name;
	private int score;
	private datum Date;
	
	Higscore(String name, int score, Date datum) {
	this.name = name;
	this.score = score;
	this.datum = datum;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}

	public Date getDate() {
		return datum;
	}

}

