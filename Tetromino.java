import java.awt.Color;

public class Tetromino{

	private int column0; //colonne de la case [0,0]
	private int row0; //ligne de la case [0,0]
	private int[][] tabTiles;
	private Color colour;
	private Gameboard gameboard;

	public static final Color EMPTY = new Color(0, 0, 0);

	public Tetromino(int type, Gameboard gameboard){

		this.gameboard = gameboard;

		column0 = (gameboard.getNbColumns() / 2) - 1;
		row0 = 0;

		switch (type) {

			case 1: //Tetromino O (yellow)
				tabTiles = new int[][]{{0,0},{0,1},{1,0},{1,1}};
				colour = new Color(255, 230, 0);
				break;

			case 2: //Tetromino I (light blue)
				tabTiles = new int[][]{{0,0},{0,1},{0,2},{0,3}};
				colour = new Color(0, 247, 255);
				break;

			case 3: //Tetromino L (orange)
				tabTiles = new int[][]{{0,0},{0,1},{0,2},{1,2}};
				colour = new Color(255, 157, 0); 
				break;

			case 4: //Tetromino J (dark blue)
				tabTiles = new int[][]{{0,0},{0,1},{0,2},{-1,2}};
				colour = new Color(0, 106, 255);
				break;

			case 5: //Tetromino T (purple)
				tabTiles = new int[][]{{0,0},{1,0},{2,0},{1,1}};
				colour = new Color(109, 50, 168); 
				break;	

			case 6: //Tetromino S (red)
				tabTiles = new int[][]{{0,0},{1,0},{0,1},{-1,1}};
				colour = new Color(255, 0, 0);
				break;

			case 7: //Tetromino Z (green) 
				tabTiles = new int[][]{{0,0},{1,0},{1,1},{2,1}};
				colour = new Color(141, 230, 53);
				break;

		}

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

	public boolean moveLeft(){

		for (int tile=0; tile < tabTiles.length; tile++){

			int i = column0 - 1 + tabTiles[tile][0];
			int j = row0 + tabTiles[tile][1];

			if (i < 0 || !(gameboard.getTab()[i][j].equals(EMPTY))){
				return false;
			}
		}

		column0 -= 1;
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
		return true;

	}	

	public boolean softDrop(){

		for (int tile=0; tile < tabTiles.length; tile++){  

			int i = column0 + tabTiles[tile][0];
			int j = row0 + 1 + tabTiles[tile][1];

			if (j > gameboard.getNbRows()-1 || !(gameboard.getTab()[i][j].equals(EMPTY))){
				gameboard.newTetromino();
				return false;
			}
		}

		row0 += 1;
		return true;
		
	}

	public void hardDrop(){
		
		while(softDrop());

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
		}
		
	}
	
}


