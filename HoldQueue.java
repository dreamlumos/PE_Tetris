import java.awt.*;
import javax.swing.*;

public class HoldQueue extends JPanel{

	private Tetromino onHold;
	private int tileSize;

	public HoldQueue(int tileSize){

		this.tileSize = tileSize;

		setPreferredSize(new Dimension(12*tileSize, 12*tileSize));
		onHold = null;
	}

	public Tetromino getOnHold(){
		return onHold;
	}

	public Tetromino setOnHold(Tetromino tetromino, Gameboard gameboard){
		
		tetromino.putOnHold();
		Tetromino temp = onHold;
		onHold = tetromino;

		if(temp == null){
			return gameboard.randomTetromino();
		} else {
			return temp;
		}
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);
		setBackground(new Color(0, 0, 0));

		if (onHold != null){

			for (int tile = 0; tile < onHold.getTabTiles().length; tile++){
				
				int i = 1+onHold.getTabTiles()[tile][0];
				int j = 1+onHold.getTabTiles()[tile][1];

				g.setColor(onHold.getColour());

				g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
				g.setColor(new Color(255, 255, 255));
				g.drawRect(i*tileSize, j*tileSize, tileSize, tileSize);

			}
		}

	}

}