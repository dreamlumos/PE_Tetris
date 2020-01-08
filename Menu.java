import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.AbstractAction;

public class Menu extends JPanel{
	
	public Menu(Window window){

		super();

		/* JPanel preferences */
		setPreferredSize(new Dimension (100,300));
		setFocusable(true);

		/* Layout */
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); //vertical axis

		JLabel title = new JLabel("TetriSU");

		JButton playButton = new JButton(new AbstractAction(" Play "){
			public void actionPerformed(ActionEvent e){
				window.showGame();
			}		
		});
		JButton instructionsButton = new JButton(new AbstractAction(" Instructions "){
			public void actionPerformed(ActionEvent e){
				window.showInstructions();
			}		
		});
		JButton aboutButton = new JButton(new AbstractAction(" About "){
			public void actionPerformed(ActionEvent e){
				window.showAbout();
			}		
		});

		add(title);
		add(playButton);
		add(instructionsButton);
		add(aboutButton);

	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);

	}
}