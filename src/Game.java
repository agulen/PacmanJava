import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame; 

// If a class extends JPanel, it is given the ability to render custom graphics to the screen.
// We will leverage this functionality to create our Pacman game's graphics
public class Game extends JPanel {
	public static final int BOARD_HEIGHT = 500;
	public static final int BOARD_WIDTH = 500; 
	
	private JFrame window = new JFrame("Pacman");
	private Pacman pacman = new Pacman(0, 0, "img/pacman.jpg");
	
	public Game() {
		window.add(this);									   // Displays our Game class in the window
		window.setSize(BOARD_WIDTH, BOARD_HEIGHT); 			   // Sets the size of the window that the Java system creates
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the program if user closes the window 
		window.setVisible(true);							   // Sets the visibility of the window
		window.setBackground(Color.black);					   // Sets the background color of the window
	}
	
	// This method is supplied by the JPanel extension and automatically called
	// by the Java system. This is where we can put our custom code to render graphics. 
	// The Graphics parameter is also given to us by the Java system. It supplies us
	// with many different methods for rendering elements to the screen. 
	public void paint(Graphics graphics) {
	   pacman.draw(graphics);
	} 
	
	public static void main(String[] args) {
		Game game = new Game();  
	}
}
