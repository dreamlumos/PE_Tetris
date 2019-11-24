/* cette classe je crois qu'elle doit pas exister je pense 
 * je vais juste mettre une variable static score et je vais recopier 
 * le code dans le constructueur ou dans le move des tetromino a revoir apres */
public class Score{
	private int score;
	public Score(){
		score=0;
	}
	/* dans la methode augmentation on prends en paramètre le nombre de ligne disparue et si la ligne a disparu 
	 si la ligne a disparue donc le score vaudrait 50 mais si ya plusieurs lignes disparue ou alors ya eu un hard drop donc le score augmentra 
	 en fonction de l'option choisie pour le hardrop : si une ligne a disparue grace a un hard drop on rajoute 100 points de plus 
	 si ya plusieurs lignes qui ont disparu y'aura un bonus pour chaque ligne 100 points 
	*/ 
	
	public void augmentation(int nblignesdisparues,boolean lignedisparue){
		int n=0;
		int bonus=0;
		if( lignedisparue) {
			n=50;
			if ( tetromino.hardDrop()){
				n+=100;
			}
			if (nblignesdisparues >1){
				bonus+=100*nblignesdisparues;
			}
					
						
		}
		score+=nblignesdisparues*n+bonus;
	}
	
	public int getScore(){
		return score;
	}
	
	
}			
