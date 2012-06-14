
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The MainWindow in which Pong is played
 */
public class MainWindow extends Frame implements ActionListener, KeyListener {
	/**
	 * Uniquely identifies this class
	 */
	private static final long serialVersionUID = 1994955233489697869L;

	/**
	 * The instance of Pong which is played
	 */
	private Pong pong;

	/**
	 * A MenuBar for user interaction
	 */
	private MenuBar mb;

	/**
	 * Menus to group similar actions
	 */
	private Menu gameMenu, settingsMenu;

	/**
	 * Displays parameters of Pong such as Ball position, ...
	 */
	private PongDisplay display;

	/**
	 * Display the scores of both players
	 */
	private Label score1, score2;

	/**
	 * Set to true when the user wants to start a new game
	 */
	private boolean gameStarting;

	/**
	 * Contructor for class MainWindow initializes all the gui elements
	 * 
	 * @param title
	 *            The title of the window
	 * @param p
	 *            The instance of Pong which is played
	 */
	public MainWindow(String title, Pong p) {
		super(title);

		this.pong = p;

		gameStarting = false;

		mb = new MenuBar();
		this.setMenuBar(mb);

		gameMenu = new Menu("Pong");
		gameMenu.add("Neu");
		gameMenu.add("Abbrechen");
		gameMenu.add("Onlinemodus");
		gameMenu.add("Highscores");
		gameMenu.add("Beenden");
		mb.add(gameMenu);
		gameMenu.addActionListener(this);

		settingsMenu = new Menu("Einstellungen");
		settingsMenu.add("Spieler");
		settingsMenu.add("Spiel");
		mb.add(settingsMenu);
		settingsMenu.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitGame();
			}
		});

		BorderLayout bl = new BorderLayout();
		setLayout(bl);

		display = new PongDisplay();
		add(display, BorderLayout.CENTER);
		this.addKeyListener(this);
		display.addKeyListener(this);

		Panel scorePanel = new Panel();
		scorePanel.setLayout(new GridLayout(1, 2));
		Font scoreFont = new Font("Arial", Font.BOLD, 24);
		score1 = new Label("");
		score1.setAlignment(Label.LEFT);
		score1.setFont(scoreFont);
		scorePanel.add(score1);
		score2 = new Label("");
		score2.setAlignment(Label.RIGHT);
		score2.setFont(scoreFont);
		scorePanel.add(score2);
		add(scorePanel, BorderLayout.NORTH);

		this.setSize(400, 400);

		this.setVisible(true);

		if (Configuration.instance().getPlayer1Name().isEmpty()
				|| Configuration.instance().getPlayer2Name().isEmpty()) {
			new WarnDialog(this, "Bitte Namen von Spielern eingeben!");
			new PlayerConfigurationDialog(this);
		}

	}

	/**
	 * Called when the users clicks on a button
	 * 
	 * @param e
	 *            An ActionEvent which contains information about what was
	 *            clicked
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(gameMenu)) {
			if (e.getActionCommand().equals("Beenden")) {
				exitGame();
			} else if (e.getActionCommand().equals("Neu")) {
				gameStarting = true;
			} else if (e.getActionCommand().equals("Abbrechen")) {
				abortGame();
			} else if (e.getActionCommand().equals("Onlinemodus")) {
				showLogin();
			} else if (e.getActionCommand().equals("Highscores")) {
				showHighscores();
			}
		} else if (e.getSource().equals(settingsMenu)) {
			if (e.getActionCommand().equals("Spieler")) {
				new PlayerConfigurationDialog(this);
			} else
				new GameConfigurationDialog(this);
		}
	}

	/**
	 * Called when the users presses a key
	 * 
	 * @param e
	 *            A KeyEvent which contains information about which key was
	 *            pressed
	 */
	public void keyPressed(KeyEvent e) {
	}

	/**
	 * Called when the users releases a key
	 * 
	 * @param e
	 *            A KeyEvent which contains information about which key was
	 *            released
	 */
	public void keyReleased(KeyEvent e) {
		if (!pong.getGameRunning())
			return;
		Configuration c = Configuration.instance();
		if (e.getKeyCode() == c.getPlayer1KeyDown()) {
			pong.getLinkPlayer(0).getLinkPaddle().move(10);
		} else if (e.getKeyCode() == c.getPlayer1KeyUp()) {
			pong.getLinkPlayer(0).getLinkPaddle().move(-10);
		} else if (e.getKeyCode() == c.getPlayer2KeyDown()) {
			pong.getLinkPlayer(1).getLinkPaddle().move(10);
		} else if (e.getKeyCode() == c.getPlayer2KeyUp()) {
			pong.getLinkPlayer(1).getLinkPaddle().move(-10);
		}
		pong.getLinkBall().step();
		update();
	}

	/**
	 * Called when the users presses and releases a key
	 * 
	 * @param e
	 *            A KeyEvent which contains information about which key was
	 *            typed
	 */
	public void keyTyped(KeyEvent e) {
		if (gameStarting) {
			startGame();
			gameStarting = false;
		}
	}

	/**
	 * Called when the user chooses to start a new Game in the Menu
	 */
	private void startGame() {
		pong.gameStart();
	}

	/**
	 * Called when the user chooses to abort the currently running Game
	 */
	private void abortGame() {
		pong.gameAbort();
	}

	/**
	 * Called when the user chooses to exit the game or closes the window
	 */
	private void exitGame() {
		pong.gameExit();
		this.dispose();
		System.exit(0);
	}

	/**
	 * Called when the user chooses to display the Highscores
	 */
	private void showHighscores() {
		new HighscoreDialog(this);
	}

	/**
	 * Called when the user chooses to log in
	 */
	private void showLogin() {
		new LoginDialog(this);
	}

	/**
	 * Called to update the gui elements with their new values
	 */
	public void update() {
		this.score1.setText(Configuration.instance().getPlayer1Name() + ": "
				+ Integer.toString(pong.getLinkPlayer(0).getScore()));
		this.score2.setText(Configuration.instance().getPlayer2Name() + ": "
				+ Integer.toString(pong.getLinkPlayer(1).getScore()));
		this.display.setBallPosition(pong.getLinkBall().getXPosition(), pong
				.getLinkBall().getYPosition());
		this.display.setPaddle1Position(pong.getLinkPlayer(0).getLinkPaddle()
				.getPosition());
		this.display.setPaddle2Position(pong.getLinkPlayer(1).getLinkPaddle()
				.getPosition());
	}
}
