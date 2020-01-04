import java.awt.*;
import javax.swing.*;

public class Scoreboard extends JLabel{
	
	int score;
	int level;
	int lines;

	public Scoreboard(){

		super();
		/*setPreferredSize(new Dimension(50, 50));*/

		score = 0;
		level = 1;
		lines = 0;

		super.setText("SCORE\n"+score+"\n\nLEVEL\n"+level+"\n\nLINES CLEARED\n"+lines);

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