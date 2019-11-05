public class Plateau{

	public static final Plateau PLATEAU = new Plateau(int nbRows, int nbColumns);

	private int nbRows;
	private int nbColumns;
	private int[][] tab;

	public Plateau(int nbRows, int nbColumns){

		this.nbRows = nbRows;
		this.nbColumns = nbColumns;
		tab = new int[nbRows][nbColumns];

		for (int i=0; i < nbRows; i++){

			for (int j=0; i < nbRows; i++){

				tab[i][j] = 0; //On initialise toutes les cases du tableau à vide

			}
		}

	}

	public int getNbL(){

		return nbRows;

	}

	public int getNbC(){

		return nbColumns;
		
	}

	public int getTab(){

		return tab;
		
	}
	
}
