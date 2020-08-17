import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame; 

public class Game extends JPanel {
	private JFrame window = new JFrame("Pacman");
	
	public Game() {
		window.add(this);
		window.setSize(500, 500); 							   // Sets the size of the window that the Java system creates
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the program if user closes the window 
		window.setVisible(true);							   // Sets the visibility of the window
	}
	
	
	public void paint(Graphics g) {
	    g.drawImage(new ImageIcon("img/pacman.jpg").getImage(), 100, 100, null); 
	} 
	
	public static void main(String[] args) {
		Game game = new Game(); 
	}
}
