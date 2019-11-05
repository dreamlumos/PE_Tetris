import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Tetromino{

	private int row0; //ligne de la case [0,0]
	private int column0;
	private Case[][] tabTiles;
	private int colour;

	public Tetromino(int colour, Plateau gameboard){

		row0 = 0;
		column0 = gameboard.getNbC() / 2;

		this.colour = colour;

		switch (colour) {

			case 0: //Tetromino O (yellow)
				tabTiles = [[0,0],[0,1],[1,0],[1,1]]; 
				break;

			case 1: //Tetromino I (light blue)
				tabTiles = [[0,0],[0,1],[0,2],[0,3]];
				break;

			case 2: //Tetromino L (orange)
				tabTiles = [[0,0],[0,1],[0,2],[1,2]]; 
				break;

			case 3: //Tetromino J (dark blue)
				tabTiles = [[0,0],[0,1],[0,2],[-1,2]]; 
				break;

			case 4: //Tetromino T (purple)
				tabTiles = [[0,0],[1,0],[2,0],[1,1]]; 
				break;	

			case 5: //Tetromino S (red)
				tabTiles = [[0,0],[1,0],[0,1],[-1,1]]; 
				break;

			case 6: //Tetromino Z (green)
				tabTiles = [[0,0],[1,0],[1,1],[2,1]]; 
				break;

		}

	}

	public int getRow(){

		return row;

	}

	public int getColumn(){

		return column;
		
	}

	public int getColour(){

		return colour;

	}

	public int getTab(){

		return colour;

	}
	
	public void moveLeft(){

		if (column0 > 0) {
			column0 -= 1;
		}

	}

	public void moveRight(int nbcolumns){

		if (column0 < nbcolumns) {
			column0 += 1;
		}

	}	

	public void hardDrop(KeyEvent event){
		if (event.getKeyChar() == VK_SPACE){
		
		}
			
	
	}

}
