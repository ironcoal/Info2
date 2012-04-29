/* Beschreiben Sie eine Datenstruktur mit zugehörigen 
Verwaltungsoperationen zur Speicherung und
Manipulation aller für den Spielball benötigter Daten.
Hinweis: Die für die Endfassung des Spiels vorliegende Datenstruktur 
besteht aus neun Komponenten und acht Verwaltungsoperationen, 
die keine get- und set-Methoden sind. */

class Pong {
	
	int pos_x; // Position des Balls horizontal
	int pos_y; // Position des Balls vertikal
	int updateTime; // so oft wird die Position des Balls neu berechnet.
	int speed; /* Geschwindigkeit: solange braucht der Ball, 
	um die Strecke "distance" zurückzulegen. */
	int distance; // Distanz, die der Ball in einer "Geschwindigkeitseinheit" zurücklegt.
	int direction_x; // Bewegungsrichtung horizontal. Bildet mit direction_y einen Einheitsvektor der Länge distance.
	int direction_y; // Bewegungsrichtung vertikal.
	/* Die Bewegung pro "update" wird errechnet durch Multiplikation 
	der Geschwindigkeit mit den Richtungskoordinaten:
	pos_x (new) = speed * direction_x
	pos_y (new) = speed * direction_y
	1 speed bedeutet, dass der Ball in 1 update 1 distance zurücklegt in Richtung (x|y) */
	int radius; // Radius des Balls.
	int colour; // Farbe
	int acc; // optional, wenn Beschleunigung des Balls erwünscht.

	void paint(Gameboard board); // Zeichnet Ball auf übergebenes Spielfeld
	void update_Position(Gameboard board); /* Berechnet Position des Balls neu. 
	Wenn sich die neuberechnete Position außerhalb des Spielfeldes oben oder unten oder 
	hinter dem Bereich eines Spielersteins befindet, 
	wird die Bewegungsrichtung geändert und anschließend neu berechnet. Distance sollte
	also möglichst klein gehalten werden. um den Eindruck zu vermitteln, dass der Ball
	von der Wand abprallt. 
	Wenn die neuberechnete Position links oder rechts im "Aus" liegt, wird je nach Seite
	der Punktestand erhöht und alle Attribute des Balls zurückgesetzt.*/
	void acceleration(); // Ändert je nach "acc" die Einheit "speed"
	void change_Direction_x(); // direction_x * -1, wenn Ball auf vertikale Wand trifft.
	void change_Direction_y(); // direction_y * -1, wenn Ball auf horizontale Wand trifft.
	void calculate_Direction_y(int change_x); // Berechnet und ändert direction_y, wenn sich x um change_x ändert.
	void calculate_Direction_x(int change_y); // Berechnet und ändert direction_y, wenn sich x um change_x ändert.
	/* Im Normalfall sollte sich beim Auftreffen auf Boden und 
	Decke die Richtung des Balls nur umkehren, während beim Auftreffen auf einen Spielerstein
	die Richtung und Geschwindigkeit des Steins auf den Ball addiert werden. Deshalb ist
	im Normalfall nur der Aufruf von calculate_Direction_x notwendig, weil
	sich die Länge des Vektors in y Richtung ändert. */
	void new_Game(int player); /* Setzt die Attribute des Balls zurück und setzt die 
	Ausgangsposition des Balls auf die Seite des Spielers, der den letzten Punkt
	verloren hat ("player") */
}












