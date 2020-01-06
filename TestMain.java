import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class TestMain{

    public static final int TILE_SIZE = 30;

	public static void main(String[] args){

	Gameboard gameboard = new Gameboard(20,8,30);
	LeftSidebar lsb = new LeftSidebar(gameboard);
	RightSidebar rsb = new RightSidebar(gameboard);

        HoldQueue holdQueue = new HoldQueue(TILE_SIZE);
        Gameboard gameboard = new Gameboard(20, 8, TILE_SIZE, holdQueue);
        LeftSidebar lsb = new LeftSidebar(gameboard, holdQueue);
        RightSidebar rsb = new RightSidebar(gameboard);

	Window window = new Window(gameboard, lsb, rsb);
	while(!gameboard.getEndofgame()){
  		window.repaint();
		try{
			Thread.sleep(200);
		} catch (Exception e){
			System.out.println(e);
		}

		gameboard.getTetromino().softDrop();
            
        }
	}
}
