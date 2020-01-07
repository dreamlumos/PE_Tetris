import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;

public class LeftSidebar extends JPanel{
	
	private HoldQueue holdQueue;
	private Scoreboard scoreboard;

	public LeftSidebar(Gameboard gameboard){

		super();

		holdQueue = new HoldQueue(gameboard.getTileSize());
		scoreboard = new Scoreboard();

		setPreferredSize(new Dimension(6*gameboard.getTileSize(), 12*gameboard.getTileSize()));

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); //vertical axis
/*		setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));*/

		add(holdQueue);
		add(Box.createRigidArea(new Dimension(0,10))); //rigid area: invisible component used to add space between components
		add(scoreboard);

	}

	public HoldQueue getHoldQueue(){
		return holdQueue;
	}

	public Scoreboard getScoreboard(){
		return scoreboard;
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g); 
		setBackground(new Color(0, 0, 0));

	}

}