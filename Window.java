import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{

	private JFrame frame;

	public Window(){

		this.setTitle("Tetris");

		this.setSize(800,800);

		this.setLocationRelativeTo(null);

		/*this.setLayout(new GridLayout(1, 2));*/


		JPanel mainPanel = new JPanel();

		JPanel panel1 = new JPanel();

		JPanel panel2 = new JPanel();

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		panel1.setPreferredSize(new Dimension(600,800));
		panel2.setPreferredSize(new Dimension(200,800));

		mainPanel.add(panel1);
		mainPanel.add(panel2);

		/*window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.setVisible(true);*/



		panel1.setBackground(Color.DARK_GRAY);
		panel2.setBackground(Color.RED);

		this.setContentPane(mainPanel);
		this.setVisible(true);

	}

}