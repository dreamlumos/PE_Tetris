import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Gameboard extends JPanel{

	private int nbColumns;
	private int nbRows;
	private int tileSize;
	private Color[][] tab;
	private Tetromino tetromino;
	private boolean endofgame;

	public Gameboard(int nbRows, int nbColumns, int tileSize){ 

		super();

		/* JPanel preferences */
		setPreferredSize(new Dimension (nbColumns*tileSize, nbRows*tileSize));
		setFocusable(true);

		/* Initialisations */
		this.nbColumns = nbColumns;
		this.nbRows = nbRows;
		this.tileSize = tileSize;
		endofgame = false;
		tetromino = randomTetromino();

		tab = new Color[nbColumns][nbRows];
		for (int i=0; i < nbColumns; i++){
			for (int j=0; j < nbRows; j++){
				tab[i][j] = Tetromino.EMPTY; //On initialise toutes les cases du tableau à vide
			}
		}

		/* Key bindings */
		InputMap im = getInputMap();
		ActionMap am = getActionMap();

		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "moveLeft");
		am.put("moveLeft", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				tetromino.moveLeft();
			}
		});
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveRight");
		am.put("moveRight", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				tetromino.moveRight();
			}
		});
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "rotateRight");
		am.put("rotateRight", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				tetromino.rotateRight();
			}
		});
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "softDrop");
		am.put("softDrop", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				tetromino.softDrop();
			}
		});
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "hardDrop");
		am.put("hardDrop", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				tetromino.hardDrop();
			}
		});

	}

	public int getNbColumns(){
		return nbColumns;
	}

	public int getNbRows(){
		return nbRows;
	}

	public int getTileSize(){
		return tileSize;
	}

	public Color[][] getTab(){
		return tab;
	}

	public Tetromino getTetromino(){
		return tetromino;
	}

	public Tetromino randomTetromino(){
		return new Tetromino((int) (Math.random()*7)+1, this);
	}

	public void newTetromino(){

		for (int tile = 0; tile < tetromino.getTabTiles().length; tile++){
			
			int i = tetromino.getColumn0() + tetromino.getTabTiles()[tile][0];
			int j = tetromino.getRow0() + tetromino.getTabTiles()[tile][1];

			tab[i][j] = tetromino.getColour();

		}

		tetromino = randomTetromino();

		for (int tile = 0; tile < tetromino.getTabTiles().length; tile++){

			int i = tetromino.getColumn0() + tetromino.getTabTiles()[tile][0];
			int j = tetromino.getRow0() + tetromino.getTabTiles()[tile][1];

			if(!(tab[i][j].equals(Tetromino.EMPTY))){
				endOfGame();
			}

		}		

	}
		

	public boolean getEndofgame(){
		return endofgame;
	}

	public void endOfGame(){
		endofgame = true;
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g); 
		setBackground(new Color(0, 0, 0));

		for (int i = 0; i < nbColumns; i++){ //draws the board
			for (int j = 0; j < nbRows; j++){
				g.setColor(tab[i][j]);
				g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
				g.setColor(new Color(255, 255, 255));
				g.drawRect(i*tileSize, j*tileSize, tileSize, tileSize);
			}
		}

		for (int tile = 0; tile < tetromino.getTabTiles().length; tile++){ //draws the current tetromino
			
			int i = tetromino.getColumn0() + tetromino.getTabTiles()[tile][0];
			int j = tetromino.getRow0() + tetromino.getTabTiles()[tile][1];

			g.setColor(tetromino.getColour());

			g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
			g.setColor(new Color(255, 255, 255));
			g.drawRect(i*tileSize, j*tileSize, tileSize, tileSize);

		}
	}
	
}
