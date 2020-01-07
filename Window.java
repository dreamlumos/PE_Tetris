import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JFrame;

public class Window extends JFrame{

	private Gameboard gameboard;
	private LeftSidebar lsb;
	private RightSidebar rsb;

	public Window(Gameboard gameboard, LeftSidebar lsb, RightSidebar rsb){

		this.gameboard = gameboard;
		this.lsb = lsb;
		this.rsb = rsb;
		setTitle("Tetris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}


}
