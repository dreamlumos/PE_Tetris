import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.AbstractAction;

public class About extends JPanel{
	
	public About(Window window){

		super();

		/* JPanel preferences */
		setPreferredSize(new Dimension (100,300));
		setFocusable(true);

		/* Layout */

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); //vertical axis

		JLabel text = new JLabel("About goes here");

		JButton menuButton = new JButton(new AbstractAction(" Menu "){
			public void actionPerformed(ActionEvent e){
				window.showMenu();
			}		
		});

		add(text);
		add(menuButton);

	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);
		
	}


}