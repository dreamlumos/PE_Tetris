import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.AbstractAction;


public class GameOverMenu extends JPanel{
	
public GameOverMenu(int nbColumns, int nbRows, int tileSize, Window window, Game game){

		super();

		/* JPanel preferences */
		setPreferredSize(new Dimension (nbColumns*tileSize, nbRows*tileSize));
		setFocusable(true);

		/* Layout */
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //vertical axis

		//JLabel title = new JLabel(" SCORE "+game.getLeftSidebar().getScoreboard().getScore());
		
		JLabel title = new JLabel("GAME OVER");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton playButton = new JButton(new AbstractAction(" New Game "){
			public void actionPerformed(ActionEvent e){
				window.newGame(nbColumns, nbRows, tileSize, window);
				window.showGame();
			}		
		});
		playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton menuButton = new JButton(new AbstractAction(" Main menu "){
			public void actionPerformed(ActionEvent e){
				window.showMenu();
			}		
		});
		menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton aboutButton = new JButton(new AbstractAction(" About "){
			public void actionPerformed(ActionEvent e){
				window.showAbout();
			}		
		});
		aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		add(Box.createRigidArea(new Dimension(0,20)));
		add(title);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(playButton);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(menuButton);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(aboutButton);

	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);

	}
}

