import java.util.date;
class A15 {
    public static void main(String[] args) {
        HighscoreContainer cont = HighscoreContainer.instance();
        Date d1 = new Date();
        Highscore h1 = new Highscore("Peter", 15, d1);
        Date d1 = new Date();
        Highscore h2 = new Highscore("Hans", 20, d1);
        Date d1 = new Date();
        Highscore h3 = new Highscore("Max", 13, d1);
        cont.addHighscore(h1);
        cont.addHighscore(h2);
        cont.addHighscore(h3);
        
        System.out.println(cont.getHighscore(1).getScore());
    }
}
        
