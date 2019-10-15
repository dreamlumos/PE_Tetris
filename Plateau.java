public class Plateau{

	private static final Plateau PLATEAU = new Plateau();

	private int nbRow;
	private int nbColumn;
	private int[][] tab;

	public Plateau(int nbLignes, int nbColonnes, int[][] tab){

		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		this.tab = tab;

	}

	public int getNbL(){

		return nbLignes;

	}

	public int getNbC(){

		return nbColonnes;
		
	}

	public int getTab(){

		return tab;
		
	}
	
}
