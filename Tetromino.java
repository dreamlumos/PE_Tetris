
public class Tetromino{

	private int row0; //ligne de la case [0,0]
	private int column0;
	private int[][] tabTiles;
	private int colour;

	public Tetromino(int colour, Plateau gameboard){

		row0 = 0;
		column0 = gameboard.getNbC() / 2;

		this.colour = colour;

		switch (colour) {

			case 1: //Tetromino O (yellow)

				int[][] tab1 = {{0,0},{0,1},{1,0},{1,1}};
				tabTiles = tab1; 
				break;

			case 2: //Tetromino I (light blue)
				int[][] tab2 = {{0,0},{0,1},{0,2},{0,3}};
				tabTiles = tab2; 
				break;

			case 3: //Tetromino L (orange)
				int[][] tab3 = {{0,0},{0,1},{0,2},{1,2}};
				tabTiles = tab3;  
				break;

			case 4: //Tetromino J (dark blue)
				int[][] tab4 = {{0,0},{0,1},{0,2},{-1,2}};
				tabTiles = tab4;  
				break;

			case 5: //Tetromino T (purple)
				int[][] tab5 = {{0,0},{1,0},{2,0},{1,1}}; 
				tabTiles = tab5; 
				break;	

			case 6: //Tetromino S (red)
				int[][] tab6 = {{0,0},{1,0},{0,1},{-1,1}}; 
				tabTiles = tab6; 
				break;

			case 7: //Tetromino Z (green)
				int[][] tab7 = {{0,0},{1,0},{1,1},{2,1}}; 
				tabTiles = tab7; 
				break;

		}

	}

	public int getRow0(){

		return row0;

	}

	public int getColumn0(){

		return column0;
		
	}

	public int getColour(){

		return colour;

	}
	
	public boolean moveLeft(Plateau gameboard){

		if (column0 > 0) {

			for (int i=0; i<4; i++){
				if (gameboard.getTab()[column0 - 1 + tabTiles[i][0]][row0 + tabTiles[i][1]] != 0){
					return false;
				}
			}

			column0 -= 1;
			return true;
		}

		return false;

	}

	public boolean moveRight(Plateau gameboard){

		if (column0 < gameboard.getNbC()) {

			for (int i=0; i<4; i++){
				if (gameboard.getTab()[column0 + 1 + tabTiles[i][0]][row0 + tabTiles[i][1]] != 0){
					return false;
				}
			}

			column0 += 1;
			return true;
		}

		return false;

	}	


	public boolean hardDrop(boolean space){
		if (space == true){
			// tetromino move
			return true ;
		}
		return false;
	}

	public void rotateRight(Plateau gameboard){


	}

	public void rotateLeft(Plateau gameboard){

		
	}

		
	
}


