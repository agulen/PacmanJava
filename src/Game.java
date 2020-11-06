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
	private JFrame window = new JFrame("Pacman");
	private Pacman pacman = new Pacman(0, 0, "img/pacman.jpg");
	private Timer timer; 
	
	public Game() {
		window.add(this);						// Displays our Game class in the window
		window.setSize(500, 500); 				// Sets the size of the window that the Java system creates
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the program if user closes the window 
		window.setVisible(true);				// Sets the visibility of the window
		window.setBackground(Color.black);		// Sets the background color of the window
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
		// Set up a timer to execute repaint() every 17 milliseconds on repeat. 
		// This will emulate a game running at approximately 60 frames per second. 
		// As a result, the paint() method below will execute 60 times per second. 
		timer = new Timer(17, new ActionListener() {
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
		pacman.draw(graphics);	   
	}	
	
	// This function listens for key presses from the keyboard.
	// Since our Game class implements KeyListener and the Window added 
	// this class as a listener (line 25), this function will be automatically
	// called whenever a key is pressed. 
	public void keyPressed(KeyEvent e) {		
		// TODO. One case is given. Add the other 3. 		
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				break;
			// case 				
				
			// case 				
				
			// case 				
				
		}
	}
	
	// Unused methods from KeyListener
	// Don't need to use these. 
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
