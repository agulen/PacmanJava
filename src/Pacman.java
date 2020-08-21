import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Pacman {
	private int x; 
	private int y; 
	private Image image;
	
	public Pacman(int x, int y, String imagePath) {
		this.x = x; 
		this.y = y;
		this.image = new ImageIcon(imagePath).getImage();
	}
	
	public int getXPosition() {
		return this.x; 
	}
	
	public int getYPosition() {
		return this.y; 
	}
	
	public Image getImage() {
		return this.image;
	}
	
	// Draws an image of Pacman to the screen
	public void draw(Graphics graphics) {
		graphics.drawImage(this.image, this.x, this.y, null); 
	}
}
