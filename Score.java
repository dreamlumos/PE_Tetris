public class Score{
	private int score;
	public Score(){
		score=0;
	}
	public void multiplierScore(boolean lignedisparue){

		if (lignedisparue)
			score+=100;//cette methode fait en sorte d'augmenter de 100 a chaque fois qu'une ligne disparais donc elle prend en argument un boolean ligne disparue 
			
	}
	public static int getScore(){
		return score;
	}
}
	
