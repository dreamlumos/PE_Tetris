import java.awt.*;
import javax.swing.*;

public class HoldQueue extends JPanel{

	private Tetromino onHold;
	private int tileSize;

	public HoldQueue(int tileSize){

		this.tileSize = tileSize;
		onHold = null;

		setPreferredSize(new Dimension(10*tileSize, 12*tileSize));

	}

	public Tetromino getOnHold(){
		return onHold;
	}

	public Tetromino setOnHold(Gameboard gameboard){
		
		gameboard.getTetromino().putOnHold();
		Tetromino temp = onHold;
		onHold = gameboard.getTetromino();
		repaint();

		if(temp == null){
			return gameboard.randomTetromino();
		} else {
			return temp;
		}
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);
		setBackground(new Color(0, 0, 0));
		g.setFont(UIManager.getFont("Label.font"));
		g.setColor(UIManager.getColor("Label.foreground"));
		g.drawString("HOLD", 15, 15);

		if (onHold != null){

			for (int tile = 0; tile < onHold.getTabTiles().length; tile++){
				
				int i = 3+onHold.getTabTiles()[tile][0];
				int j = 1+onHold.getTabTiles()[tile][1];

				g.setColor(onHold.getColour());

				g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
				g.setColor(new Color(255, 255, 255));
				g.drawRect(i*tileSize, j*tileSize, tileSize, tileSize);

			}
		}

	}

}