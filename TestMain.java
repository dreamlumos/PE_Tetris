/*import java.util.Scanner;

public class TestMain{

    public static final int TILE_SIZE = 30;
    public static final int NB_COLUMNS = 10;
    public static final int NB_ROWS = 10;

	public static void main(String[] args){

        Gameboard gameboard = new Gameboard(NB_COLUMNS, NB_ROWS, TILE_SIZE);
        LeftSidebar lsb = new LeftSidebar(gameboard);
        RightSidebar rsb = new RightSidebar(gameboard);
        gameboard.bindKeys(lsb, rsb);

    	Window window = new Window(gameboard, lsb, rsb);
		
    	while (!gameboard.getEndOfGame()){
            
            window.repaint();
            
            if (!gameboard.getPause()){

        		try{
        			Thread.sleep(1050-50*lsb.getScoreboard().getLevel());
        		} catch (Exception e){
        			System.out.println(e);
        		}
        		gameboard.getTetromino().softDrop(lsb, rsb);

            } else { //paused

                try{
                    Thread.sleep(5);
                } catch (Exception e){
                    System.out.println(e);
                } 

            }

        }

	}
}
*/