import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Pacman {
	private int x; 
	private int y; 
	private Image image = new ImageIcon("img/pacman.jpg").getImage();
	
	public Pacman(int x, int y) {
		this.x = x; 
		this.y = y;
	}
	
	// Draws an image of Pacman to the screen
	public void draw(Graphics graphics) {
		graphics.drawImage(this.image, this.x, this.y, null); 
	}
}
