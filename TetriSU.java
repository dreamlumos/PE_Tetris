import javax.swing.JFrame;

public class TetriSU{
	
    public static final int TILE_SIZE = 30;
    public static final int NB_COLUMNS = 10;
    public static final int NB_ROWS = 20;

	public static void main(String[] args){

		JFrame tetris = new JFrame();

		tetris.setTitle("TetriSU");
		tetris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Window window = new Window(NB_COLUMNS, NB_ROWS, TILE_SIZE, tetris);
		tetris.add(window);

		tetris.pack();
		tetris.setLocationRelativeTo(null);
		tetris.setVisible(true);

	}

}