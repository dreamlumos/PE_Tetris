import java.awt.*;
import javax.swing.*;

public class RightSidebar extends JPanel{
	
	private NextTetrominos nextTetrominos;

	public RightSidebar(Gameboard gameboard){

		super();

		nextTetrominos = new NextTetrominos(gameboard);

		setPreferredSize(new Dimension(6*gameboard.getTileSize(), gameboard.getNbColumns()*gameboard.getTileSize()));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); //vertical axis
		setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));

		add(nextTetrominos);

	}

	public NextTetrominos getNextTetrominos(){
		return nextTetrominos;
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g); 
		setBackground(new Color(0, 0, 0));

	}

}