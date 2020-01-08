import java.awt.*;
import javax.swing.*;

public class Window extends JPanel{
	
	private Menu menu;
	private About about;
	private Instructions instructions;
	private Game game;
	private JFrame frame;
/*	private PauseMenu pauseMenu; //should be in Game
	private GameOverMenu gameOverMenu; //should be in Game*/

	public Window(int nbColumns, int nbRows, int tileSize, JFrame frame){

		super();

		/* JPanel preferences */
/*		setPreferredSize(new Dimension (100,300));
		setFocusable(true);*/

		setLayout(new CardLayout());

		menu = new Menu(this);
		about = new About(this);
		instructions = new Instructions(this);
		game = new Game(nbColumns, nbRows, tileSize);
		this.frame = frame;
		add(menu, "Menu");
		add(about, "About");
		add(instructions, "Instructions");
		add(game, "Game");

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

	public void showGame(){
		CardLayout cl = (CardLayout) getLayout();
		cl.show(this, "Game");
		frame.validate();
		frame.repaint();
		frame.pack();
		game.play();
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g); 
		setBackground(new Color(0, 0, 0));

	}
}