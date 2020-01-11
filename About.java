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

public class About extends JPanel{
	
	public About(Window window){

		super();

		/* JPanel preferences */
		setPreferredSize(new Dimension (100,300));
		setFocusable(true);

		/* Layout */

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //vertical axis

		JLabel text = new JLabel("About goes here");
		text.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton menuButton = new JButton(new AbstractAction(" Back to menu "){
			public void actionPerformed(ActionEvent e){
				window.showMenu();
			}		
		});
		menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		add(text);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(menuButton);

	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);
		
	}


}