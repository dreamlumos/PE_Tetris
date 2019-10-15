public class Tetromino{

	private int ligne0; //ligne de la case [0,0]
	private int colonne0;
	private Case[][] tabTiles;
	private int couleur;

	public Tetromino(Case[][] tabTiles, int couleur, Plateau gameboard){

		ligne0 = get
		this.colonne = colonne;
		this.couleur = couleur;

	}

	public Case(int couleur, Case[] tabTetromino){
		
		this.couleur = (int) Math.random()*7+1;
		this.tab = tabTetromino[]
	}

	public int getLigne(){

		return ligne;

	}

	public int getColonne(){

		return colonne;
		
	}

	public int getCouleur(){

		return couleur;

	}

	public int getTab(){

		return couleur;

	}
	
	public void moveLeft(){

		if (colonne0 > 0) {
			colonne0 -= 1;
		}

	}

	public void moveRight(int nbColonnes){

		if (colonne0 < nbColonnes) {
			colonne0 += 1;
		}

	}	

	public void hardDrop(Plateau )

}