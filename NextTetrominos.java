import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.JPanel;

public class NextTetrominos extends JPanel{

	private Tetromino[] nextTab;
	private int tileSize;

	public NextTetrominos(Gameboard gameboard){

		this.tileSize = gameboard.getTileSize();
		nextTab = new Tetromino[3];

		for (int i=0; i<nextTab.length; i++){
			nextTab[i] = gameboard.randomTetromino();
		}

		setPreferredSize(new Dimension(6*tileSize, 8*tileSize));

	}

	public Tetromino[] getTab(){
		return nextTab;
	}

	public Tetromino getNextTetromino(Gameboard gameboard){

		Tetromino nextTetromino = nextTab[0];

		for (int i=0; i < nextTab.length-1; i++){
			nextTab[i] = nextTab[i+1];
		}

		nextTab[nextTab.length-1] = gameboard.randomTetromino();

		return nextTetromino;

	}

	public void paintComponent(Graphics g){

		super.paintComponent(g); 
		setBackground(new Color(0, 0, 0));

		int row = 1;

		for (int k=0; k<nextTab.length; k++){ //for each tetromino in the queue

			Tetromino tetromino = nextTab[k];

			for (int tile = 0; tile < tetromino.getTabTiles().length; tile++){
				
				int i = 2+tetromino.getTabTiles()[tile][0];
				int j = row+tetromino.getTabTiles()[tile][1];

				g.setColor(tetromino.getColour());

				g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
				g.setColor(new Color(255, 255, 255));
				g.drawRect(i*tileSize, j*tileSize, tileSize, tileSize);

			}

			row+=3;
		}

	}

}