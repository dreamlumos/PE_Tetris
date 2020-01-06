import java.awt.*;
import javax.swing.*;

public class Scoreboard extends JLabel{
	
	int score;
	int level;
	int lines;
	int bonus;

	public Scoreboard(){

		super();
		/*setPreferredSize(new Dimension(50, 50));*/

		score = 0;
		level = 1;
		lines = 0;
		bonus =20;

	}
	public void Score(Gameboard gameboard){
		score++;
		lines=gameboard.rowDisappeared();
		if (gameboard.rowDisappeared() >=2){
			bonus*=2;
		}
		score=score+bonus*gameboard.rowDisappeared();
	}
	public int getScore(){
		return score;
	}

	public int getLevel(){
		return level;
	}

	public int getLines(){
		return lines;
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);


	}

}
