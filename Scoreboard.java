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
		bonus = 20;

		super.setText("<html> SCORE <br>"+score+"<br><br> LEVEL <br>"+level+"<br><br> LINES CLEARED<br>"+lines+"</html>");

	}

	public void calculateScore(Gameboard gameboard){
		score++;
		int newLines = gameboard.lineClear();

		lines += newLines;

		if (newLines >=2){
			bonus*=2;
		}

		score = score+bonus*newLines;
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
		super.setText("<html> SCORE <br>"+score+"<br><br> LEVEL <br>"+level+"<br><br> LINES CLEARED<br>"+lines+"</html>");

	}

}
