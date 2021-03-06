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

public class Menu extends JPanel{
	
	public Menu(Window window){

		super();

		/* JPanel preferences */
		setPreferredSize(new Dimension (100,300));
		setFocusable(true);

		/* Layout */
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //vertical axis

		JLabel title = new JLabel("TetriSU");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton playButton = new JButton(new AbstractAction(" Play "){
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
		add(Box.createRigidArea(new Dimension(0,20))); //rigid area: invisible component used to add space between components
		add(playButton);
		add(Box.createRigidArea(new Dimension(0,20))); 
		add(instructionsButton);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(aboutButton);

	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);

	}
}