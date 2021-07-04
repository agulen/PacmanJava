import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer; 

// If a class extends JPanel, it is given the ability to render custom graphics to the screen.
// We will leverage this functionality to create our Pacman game's graphics
public class Game extends JPanel implements KeyListener {
	public static final int BOARD_HEIGHT = 500;
	public static final int BOARD_WIDTH = 500; 
	
	private JFrame window = new JFrame("Pacman");
	private Pacman pacman = new Pacman(0, 0, Direction.Right);
	private Ghost redGhost = new Ghost(10, 10, Direction.Down, GhostType.Red);
	private Timer timer;
	
	public Game() {
		window.add(this);									   // Displays our Game class in the window
		window.setSize(BOARD_WIDTH, BOARD_HEIGHT); 			   // Sets the size of the window that the Java system creates
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the program if user closes the window
		window.setVisible(true);							   // Sets the visibility of the window
		window.setBackground(Color.black);					   // Sets the background color of the window
		window.addKeyListener(this);
		initializeAutoPaint();
	}
	
	// Entry point of program
	public static void main(String[] args) {
		Game game = new Game();  
	}
	
	// Boilerplate code given at beginning of part 2. 
	// This method sets up a timer to call the repaint() method, which paints all images again to the screen. 
	public void initializeAutoPaint() {
		// Set up a timer to execute repaint() every 8 milliseconds on repeat.  
		// As a result, the paint() method below will execute 125 times per second. 
		timer = new Timer(8, new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        repaint();
	      }
	    });    
	    
	    timer.setRepeats(true);
	    timer.start();
	}
	
	// This method is supplied by the JPanel extension and automatically called
	// by the Java system. This is where we can put our custom code to render graphics. 
	// The Graphics parameter is also given to us by the Java system. It supplies us
	// with many different methods for rendering elements to the screen. 
	public void paint(Graphics graphics) {
		drawGameBackground(graphics);
		pacman.draw(graphics);
		redGhost.draw(graphics);
		redGhost.move(); 
		detectCollision(pacman, redGhost);
	}	
	
	public void drawGameBackground(Graphics graphics) {
		graphics.drawRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
		graphics.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
	}
	
	// This function listens for key presses from the keyboard.
	// Since our Game class implements KeyListener and the Window added 
	// this class as a listener, this function will be automatically
	// called whenever a key is pressed. 
	public void keyPressed(KeyEvent e) {		
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				pacman.setDirection(Direction.Left);
				break;
			case KeyEvent.VK_RIGHT:
				pacman.setDirection(Direction.Right);
				break;
			case KeyEvent.VK_UP:
				pacman.setDirection(Direction.Up);
				break;
			case KeyEvent.VK_DOWN:
				pacman.setDirection(Direction.Down);
				break;
				
		}
	}
	
	private void detectCollision(Pacman pacman, Ghost ghost) {
		int collisionThreshold = 10; 
		int xDiff = Math.abs(pacman.getXPosition() - ghost.getXPosition());
		int yDiff = Math.abs(pacman.getYPosition() - ghost.getYPosition()); 
		
		if (xDiff < collisionThreshold && 
			yDiff < collisionThreshold) {
			System.out.println("Collision happened");
		}
	}
	
	// Unused methods from KeyListener
	// Don't need to use these. 
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
