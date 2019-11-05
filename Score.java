public class Score{
	private int score;
	public Score(){
		score=0;
	}
	public void augmentation(int nblignesdisparues,boolean lignedisparue){
		int n=0;
		int bonus=0;
		if( lignedisparue) {
			n=50;
			/*if ( tetromino.hardDrop()){
				n=100;
				pour le harddrop on rajoute un autre boolean en arguments qui fait genre si la dernière touche c'est un space donc le hardrop est vrai et du coup n vaudrait 100
			}*/
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
