import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	public void keyTyped(KeyEvent event) {
			if (event.getKeyChar() == VK_SPACE){
				System.out.println("bravo");
			}
	}
	
}			
