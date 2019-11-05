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

			case 0: //Tetromino O (yellow)

				int[][] tab0 = {{0,0},{0,1},{1,0},{1,1}};
				tabTiles = tab0; 
				break;

			case 1: //Tetromino I (light blue)
				int[][] tab1 = {{0,0},{0,1},{0,2},{0,3}};
				tabTiles = tab1; 
				break;

			case 2: //Tetromino L (orange)
				int[][] tab2 = {{0,0},{0,1},{0,2},{1,2}};
				tabTiles = tab2;  
				break;

			case 3: //Tetromino J (dark blue)
				int[][] tab3 = {{0,0},{0,1},{0,2},{-1,2}};
				tabTiles = tab3;  
				break;

			case 4: //Tetromino T (purple)
				int[][] tab4 = {{0,0},{1,0},{2,0},{1,1}}; 
				tabTiles = tab4; 
				break;	

			case 5: //Tetromino S (red)
				int[][] tab5 = {{0,0},{1,0},{0,1},{-1,1}}; 
				tabTiles = tab5; 
				break;

			case 6: //Tetromino Z (green)
				int[][] tab6 = {{0,0},{1,0},{1,1},{2,1}}; 
				tabTiles = tab6; 
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
	
	public void moveLeft(){

		if (column0 > 0) {
			column0 -= 1;
		}

	}

	public void moveRight(Plateau gameboard){

		if (column0 < gameboard.getNbC()) {
			column0 += 1;
		}

	}	

	public void hardDrop(Plateau gameboard){

		
	}

}