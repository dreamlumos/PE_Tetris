import java.awt.Color;

public class Tetromino implements Cloneable{

	private int column0; //colonne de la case [0,0]
	private int row0; //ligne de la case [0,0]
	private int[][] tabTiles;
	private Color colour;
	private Gameboard gameboard;
	private int type;

	public static final Color EMPTY = new Color(0, 0, 0);

	public Tetromino(int type, Gameboard gameboard){

		this.gameboard = gameboard;
		this.type=type;

		column0 = (gameboard.getNbColumns() / 2) - 1;
		row0 = 1;

		switch (type) {

			case 1: //Tetromino O (yellow)
				tabTiles = new int[][]{{0,-1},{1,-1},{0,0},{1,0}};
				colour = new Color(255, 230, 0);
				break;

			case 2: //Tetromino I (light blue)
				tabTiles = new int[][]{{-1,0},{0,0},{1,0},{2,0}};
				colour = new Color(0, 247, 255);
				break;

			case 3: //Tetromino L (orange)
				tabTiles = new int[][]{{-1,0},{0,0},{1,0},{1,-1}};
				colour = new Color(255, 157, 0); 
				break;

			case 4: //Tetromino J (dark blue)
				tabTiles = new int[][]{{-1,-1},{-1,0},{0,0},{1,0}};
				colour = new Color(0, 106, 255);
				break;

			case 5: //Tetromino T (purple)
				tabTiles = new int[][]{{-1,0},{0,0},{0,-1},{1,0}};
				colour = new Color(109, 50, 168); 
				break;	

			case 6: //Tetromino S (green)
				tabTiles = new int[][]{{-1,0},{0,0},{0,-1},{1,-1}};
				colour = new Color(141, 230, 53);
				break;

			case 7: //Tetromino Z (red) 
				tabTiles = new int[][]{{-1,-1},{0,-1},{0,0},{1,0}};
				colour = new Color(255, 0, 0);
				break;

		}

/*		int nbRotations = (int) (Math.random()*4);
		for (int i = 0; i < nbRotations; i++){
			rotateRight();
		}
*/

	}

	public int getType(){
		return type;
	}

	public int getColumn0(){
		return column0;
	}

	public int getRow0(){
		return row0;
	}

	public int[][] getTabTiles(){
		return tabTiles;
	}

	public Color getColour(){
		return colour;
	}

	public Tetromino getGhostPiece(){

		try {

			Tetromino ghostPiece = (Tetromino) clone();

			boolean finalPos = false;
			int newRow0 = row0+1;

			while (!finalPos){
				
				//Check if next row is free
				for (int tile = 0; tile < getTabTiles().length; tile++){

					int i = getColumn0() + getTabTiles()[tile][0];
					int j = newRow0 + 1 + getTabTiles()[tile][1];

					if (j > gameboard.getNbRows()-1 || !gameboard.getTab()[i][j].equals(EMPTY)){
						finalPos = true;
						break;
					} else if (tile == getTabTiles().length-1){
						newRow0++;
					}

				}

			}

			ghostPiece.row0 = newRow0;

			return ghostPiece;

		} catch (CloneNotSupportedException e){

			System.out.println(e);
			return null;
		
		}

	}

	public void putOnHold(){
		column0 = (gameboard.getNbColumns() / 2) - 1;
		row0 = 1;
		gameboard.repaint();
	}

	public boolean moveLeft(){

		for (int tile=0; tile < tabTiles.length; tile++){

			int i = column0 - 1 + tabTiles[tile][0];
			int j = row0 + tabTiles[tile][1];

			if (i < 0 || !(gameboard.getTab()[i][j].equals(EMPTY))){
				return false;
			}
		}

		column0 -= 1;
		gameboard.repaint();
		return true;

	}

	public boolean moveRight(){

		for (int tile=0; tile < tabTiles.length; tile++){

			int i = column0 + 1 + tabTiles[tile][0];
			int j = row0 + tabTiles[tile][1];

			if (i > gameboard.getNbColumns()-1 || !(gameboard.getTab()[i][j].equals(EMPTY))){
				return false;
			}
		}

		column0 += 1;
		gameboard.repaint();
		return true;

	}	

	public boolean softDrop(LeftSidebar lsb, RightSidebar rsb){

		for (int tile=0; tile < tabTiles.length; tile++){  

			int i = column0 + tabTiles[tile][0];
			int j = row0 + 1 + tabTiles[tile][1];

			if (j > gameboard.getNbRows()-1 || !(gameboard.getTab()[i][j].equals(EMPTY))){
				gameboard.newTetromino(rsb.getNextTetrominos());
				lsb.getScoreboard().calculateScore(gameboard);
				return false;
			}
		}

		row0 += 1;
		gameboard.repaint();
		return true;
		
	}

	public void hardDrop(LeftSidebar lsb, RightSidebar rsb){
		while(softDrop(lsb, rsb));
	}

	public void rotateRight(){
		int bloque=0;
		int tmp;
		int i = 0,ligne_deb,colonne_deb;
		while (bloque==0 && i < 4) {
			ligne_deb=row0+tabTiles[i][0];
			colonne_deb=column0-tabTiles[i][1];
			/* la rotation fait sortir la piece du plateau par le haut ou le bas */
			if (ligne_deb < 0 || ligne_deb >= gameboard.getNbRows()) {
				bloque=1;
			} else {
			/* la rotation fait sortir la piece du plateau par un des cotes */
				if (colonne_deb >= gameboard.getNbColumns() || colonne_deb < 0) {
					bloque=1;
				} else {
				/* la rotation met la piece sur une case occupee */
					if (gameboard.getTab()[colonne_deb][ligne_deb] != EMPTY) {
						bloque=1;
					}
				}
			}
			i=i+1;
		}
		if (bloque==0) {
			for (i=0; i < 4; i++) {
				tmp=tabTiles[i][0];
				tabTiles[i][0] = -tabTiles[i][1];
				tabTiles[i][1] = tmp;
			
			}
			gameboard.repaint();
		}

	}

	public void rotateLeft(){
		int bloque=0;
		int tmp;
		int i = 0,ligne_deb,colonne_deb;
		while (bloque==0 && i < 4) {
			ligne_deb=row0-tabTiles[i][0];
			colonne_deb=column0+tabTiles[i][1];
			/* la rotation fait sortir la piece du plateau par le haut ou le bas */
			if (ligne_deb < 0 || ligne_deb >= gameboard.getNbRows()) {
				bloque=1;
			} else {
			/* la rotation fait sortir la piece du plateau par un des cotes */
				if (colonne_deb >= gameboard.getNbColumns() || colonne_deb < 0) {
					bloque=1;
				} else {
				/* la rotation met la piece sur une case occupee */
					if (gameboard.getTab()[colonne_deb][ligne_deb] != EMPTY) {
						bloque=1;
					}
				}
			}
			i=i+1;
		}
		if (bloque==0) {
			for (i=0; i < 4; i++) {
				tmp=tabTiles[i][0];
				tabTiles[i][0] = tabTiles[i][1];
				tabTiles[i][1] = -tmp;
			}
			gameboard.repaint();
		}
		
	}
	
}


