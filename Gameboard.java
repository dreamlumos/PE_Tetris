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
	private boolean endOfGame;

	public Gameboard(int nbRows, int nbColumns, int tileSize){ 

		super();

		/* JPanel preferences */
		setPreferredSize(new Dimension (nbColumns*tileSize, nbRows*tileSize));
		setFocusable(true);

		/* Initialisations */
		this.nbColumns = nbColumns;
		this.nbRows = nbRows;
		this.tileSize = tileSize;
		endOfGame = false;
		tetromino = randomTetromino();

		tab = new Color[nbColumns][nbRows];
		for (int i=0; i < nbColumns; i++){
			for (int j=0; j < nbRows; j++){
				tab[i][j] = Tetromino.EMPTY; //On initialise toutes les cases du tableau à vide
			}
		}

	}

	public void bindKeys(LeftSidebar lsb, RightSidebar rsb){
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
				if(tetromino.getType()!=1)
					tetromino.rotateRight();
			}
		});
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "softDrop");
		am.put("softDrop", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				tetromino.softDrop(lsb, rsb);
			}
		});
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "hardDrop");
		am.put("hardDrop", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				tetromino.hardDrop(lsb, rsb);
			}
		});
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "putOnHold");
		am.put("putOnHold", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				tetromino = lsb.getHoldQueue().setOnHold(Gameboard.this);
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

	public void newTetromino(NextTetrominos nextTetrominos){

		for (int tile = 0; tile < tetromino.getTabTiles().length; tile++){
			
			int i = tetromino.getColumn0() + tetromino.getTabTiles()[tile][0];
			int j = tetromino.getRow0() + tetromino.getTabTiles()[tile][1];

			tab[i][j] = tetromino.getColour();

		}

		tetromino = nextTetrominos.getNextTetromino(this);

		for (int tile = 0; tile < tetromino.getTabTiles().length; tile++){

			int i = tetromino.getColumn0() + tetromino.getTabTiles()[tile][0];
			int j = tetromino.getRow0() + tetromino.getTabTiles()[tile][1];

			if(!(tab[i][j].equals(Tetromino.EMPTY))){
				endOfGame();
			}

		}		

	}

	public boolean getEndOfGame(){
		return endOfGame;
	}

	public void endOfGame(){
		endOfGame = true;
	}

	public int lineClear(){
		int row=nbRows-1;
		int col;
		boolean complete;
		int cpt=0;

		while (row >= 0) {
			/* On verifie si la ligne est pleine */
			complete=true;
			col=0;

			while (complete && col < nbColumns) {
				if (tab[col][row] == Tetromino.EMPTY) {
					complete=false;
				}
				col=col+1;
			}

			/* on decale vers le bas */
			if (complete) {
				cpt++;
				
				if (row > 0) {
					for (int row2=row; row2 > 0; row2--) {
						for (int col2=0; col2 < nbColumns; col2++) {
							tab[col2][row2]=tab[col2][row2-1];
						}
					}
				}
				/* on vide la ligne tout en haut */
				for (int col2=0; col2 < nbColumns; col2++) {
					tab[col2][0]=Tetromino.EMPTY;
				}
				
			} else {
				row = row-1;

			}

		}

		return cpt;

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
