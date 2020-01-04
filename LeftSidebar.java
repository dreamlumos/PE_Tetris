import java.awt.*;
import java.awt.Color;
import javax.swing.*;

public class LeftSidebar extends JPanel{
	
	private Hold hold;
	private Scoreboard scoreboard;

	public LeftSidebar(Gameboard gameboard){

		super();

		hold = new Hold(gameboard);
		scoreboard = new Scoreboard();

		setPreferredSize(new Dimension(6*gameboard.getTileSize(), 12*gameboard.getTileSize()));

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); //vertical axis
		setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));

		add(hold);
		add(Box.createRigidArea(new Dimension(0,10))); //rigid area: invisible component used to add space between components
		add(scoreboard);

	}

	public void paintComponent(Graphics g){

		super.paintComponent(g); 
		setBackground(new Color(0, 0, 0));

	}

}