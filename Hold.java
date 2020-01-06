import java.awt.*;
import javax.swing.*;

public class Hold extends JPanel{

	private Tetromino onHold;

	public Hold(Gameboard gameboard){
		setPreferredSize(new Dimension(6*gameboard.getTileSize(), 6*gameboard.getTileSize()));
	}

	public Tetromino getOnHold(){
		return onHold;
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);
		setBackground(new Color(0, 0, 0));

	}

}
