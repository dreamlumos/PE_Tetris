import java.awt.Graphics;
import javax.swing.JLabel;

public class Scoreboard extends JLabel{
	
	int score;
	int level; //1-20
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

		score++; //1pt for each softDrop
		
		int newLines = gameboard.lineClear();

		lines += newLines;

		if (level<20){
			level = lines/5;
		}

		if (newLines >=2){
			bonus*=2;
		}

		score = score+bonus*newLines;
		repaint();
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
