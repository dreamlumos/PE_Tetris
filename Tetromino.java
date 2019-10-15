public class Tetromino{

	private int row0; //ligne de la case [0,0]
	private int column0;
	private Case[][] tabTiles;
	private int colour;

	public Tetromino(Case[][] tabTiles, int colour, Plateau gameboard){

		row0 = get
		this.column = column;
		this.colour = colour;

	}

	public Case(int colour, Case[] tabTetromino){
		
		this.colour = (int) Math.random()*7+1;
		this.tab = tabTetromino[]
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

	public void hardDrop(Plateau ){

		
	}

}