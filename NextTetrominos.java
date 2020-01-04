import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.JPanel;

public class NextTetrominos extends JPanel{

	private Tetromino next1;
	private Tetromino next2;
	private Tetromino next3;

	public NextTetrominos(Gameboard gameboard){
		setPreferredSize(new Dimension(6*gameboard.getTileSize(), 12*gameboard.getTileSize()));
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g); 
		setBackground(new Color(0, 0, 0));

	}

}