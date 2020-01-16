import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel{

	private Gameboard gameboard;
	private LeftSidebar lsb;
	private RightSidebar rsb;

	private Timer softDropTimer = new Timer(1050, new ActionListener() {
		public void actionPerformed(ActionEvent e){
			if (gameboard.getGameOver() || gameboard.getPause()){
				stop();
			} else {
				updateSpeed();
				gameboard.getTetromino().softDrop(lsb, rsb);
			}
		}
	});

	public Game(int nbColumns, int nbRows, int tileSize, Window window){

		setFocusable(true);

		gameboard = new Gameboard(nbColumns, nbRows, tileSize, window);
        lsb = new LeftSidebar(gameboard);
        rsb = new RightSidebar(gameboard);
        gameboard.bindKeys(lsb, rsb, this);

		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(lsb, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(gameboard, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(rsb, gbc);

	}

	public Gameboard getGameboard(){
		return gameboard;
	}

	public LeftSidebar getLeftSidebar(){
		return lsb;
	}

	public RightSidebar getRightSidebar(){
		return rsb;
	}

	public Timer getSoftDropTimer(){
		return softDropTimer;
	}

	public void play(){
		gameboard.requestFocusInWindow();
		if (gameboard.getPause()){
			unpause();
		} else {
			softDropTimer.start();
		}
	}

	public void stop(){
		softDropTimer.stop();
	}

	public void unpause(){
		gameboard.setPause(this);
		softDropTimer.restart();
	}

	public void updateSpeed(){
		softDropTimer.setDelay(1050-50*lsb.getScoreboard().getLevel());
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g); 
/*		setBackground(new Color(0, 0, 0));*/

	}

}
