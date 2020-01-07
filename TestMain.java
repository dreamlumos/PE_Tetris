import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class TestMain{

    public static final int TILE_SIZE = 30;

	public static void main(String[] args){

        Gameboard gameboard = new Gameboard(20, 10, TILE_SIZE);
        LeftSidebar lsb = new LeftSidebar(gameboard);
        RightSidebar rsb = new RightSidebar(gameboard);
        gameboard.bindKeys(lsb, rsb);

    	Window window = new Window(gameboard, lsb, rsb);
		
    	while(!gameboard.getEndOfGame()){

      		window.repaint();

    		try{
    			Thread.sleep(200);
    		} catch (Exception e){
    			System.out.println(e);
    		}
    		gameboard.getTetromino().softDrop(lsb, rsb);
                
        }

	}
}
