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
import javax.swing.KeyStroke;
import javax.swing.InputMap;
import javax.swing.ActionMap;


public class PauseMenu extends JPanel{
	
public PauseMenu(int nbColumns, int nbRows, int tileSize, Window window, Game game){

		super();

		/* JPanel preferences */
		setPreferredSize(new Dimension (nbColumns*tileSize, nbRows*tileSize));
		setFocusable(true);

		/* Layout */
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //vertical axis

		JLabel title = new JLabel(" GAME PAUSED ");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton playButton = new JButton(new AbstractAction(" Resume Game "){
			public void actionPerformed(ActionEvent e){
				window.showGame();
			}		
		});
		playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton instructionsButton = new JButton(new AbstractAction(" Instructions "){
			public void actionPerformed(ActionEvent e){
				window.showInstructions();
			}		
		});
		instructionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton aboutButton = new JButton(new AbstractAction(" About "){
			public void actionPerformed(ActionEvent e){
				window.showAbout();
			}		
		});
		aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		add(title);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(playButton);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(instructionsButton);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(aboutButton);

		/* Key bindings */
		InputMap im = getInputMap();
		ActionMap am = getActionMap();

		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "pause");
		am.put("pause", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				window.showGame();
			}
		});

	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);

	}
}

