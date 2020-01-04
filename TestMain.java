import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class TestMain{

	public static void main(String[] args){

        Gameboard gameboard = new Gameboard(20,8,30);
        LeftSidebar lsb = new LeftSidebar(gameboard);
        RightSidebar rsb = new RightSidebar(gameboard);

    	Window window = new Window(gameboard, lsb, rsb);

        while(!gameboard.getEndofgame()){
            window.repaint();

            try{
                Thread.sleep(100);
            } catch (Exception e){
                System.out.println(e);
            }

            gameboard.getTetromino().softDrop();
            
        }
	}
}