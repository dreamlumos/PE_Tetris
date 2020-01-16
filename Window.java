import java.awt.*;
import javax.swing.*;

public class Window extends JPanel{
	
	private Menu menu;
	private About about;
	private Instructions instructions;
	private Game game;
	private JFrame frame;
	private PauseMenu pauseMenu;
	private GameOverMenu gameOverMenu;

	public Window(int nbColumns, int nbRows, int tileSize, JFrame frame){

		super();

		/* Layout */
		setLayout(new CardLayout());

		menu = new Menu(this);
		about = new About(this);
		instructions = new Instructions(this);
		game = new Game(nbColumns, nbRows, tileSize, this);
		pauseMenu = new PauseMenu(nbColumns, nbRows, tileSize, this, game);
		gameOverMenu = new GameOverMenu(nbColumns, nbRows, tileSize, this, game);
		this.frame = frame;
		add(menu, "Menu");
		add(about, "About");
		add(instructions, "Instructions");
		add(game, "Game");
		add(pauseMenu, "Paused");
		add(gameOverMenu, "Game Over");

		showMenu();

	}

	public void showMenu(){
		CardLayout cl = (CardLayout) getLayout();
		cl.show(this, "Menu");
		menu.requestFocusInWindow();
		repaint();
	}

	public void showAbout(){
		CardLayout cl = (CardLayout) getLayout();
		cl.show(this, "About");
	}

	public void showInstructions(){
		CardLayout cl = (CardLayout) getLayout();
		cl.show(this, "Instructions");
	}

	public void showPauseMenu(){
		pauseMenu.requestFocusInWindow();
		CardLayout cl = (CardLayout) getLayout();
		cl.show(this, "Paused");
	}

	public void showGameOverMenu(int nbColumns, int nbRows, int tileSize, Window window){
		CardLayout cl = (CardLayout) getLayout();
		cl.show(this, "Game Over");
		newGame(nbColumns, nbRows, tileSize, window);
	}

	public void showGame(){
		CardLayout cl = (CardLayout) getLayout();
		cl.show(this, "Game");
		frame.validate();
		frame.repaint();
		frame.pack();
		game.play();
	}

	public void newGame(int nbColumns, int nbRows, int tileSize, Window window){
		game = new Game(nbColumns, nbRows, tileSize, window);
		add(game, "Game");
	}

	public Game getGame(){
		return game;
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g); 
		setBackground(new Color(0, 0, 0));

	}
}