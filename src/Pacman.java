import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Pacman {
	private int x; 
	private int y;
	private Direction direction; 
	private Image image;
	
	private static Image pacmanLeft  = new ImageIcon("img/pacmanleft.jpg").getImage();
	private static Image pacmanRight = new ImageIcon("img/pacmanright.jpg").getImage();
	private static Image pacmanUp    = new ImageIcon("img/pacmanup.jpg").getImage();
	private static Image pacmanDown  = new ImageIcon("img/pacmandown.jpg").getImage();
	
	private static int pacmanImageHeight = 20;
	private static int pacmanImageWidth = 20;
	
	public Pacman(int x, int y, Direction direction, String imagePath) {
		this.x = x; 
		this.y = y;
		this.setDirection(direction);
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
	
	public void setDirection(Direction direction) {
		this.direction = direction;
		switch (direction) {
			case Left:
				this.image = pacmanLeft;
				break;
			case Right:
				this.image = pacmanRight;
				break;
			case Up:
				this.image = pacmanUp;
				break;
			case Down:
				this.image = pacmanDown;
				break;
		}
	}
	
	// Draws an image of Pacman to the screen.
	// This method is getting called many times per second.
	public void draw(Graphics graphics) {
		graphics.drawImage(this.image, this.x, this.y, null);		
		updateCoordinates(); 
	}
	
	private void updateCoordinates() {
		int rightBoundary = Game.BOARD_WIDTH - pacmanImageWidth;
		int bottomBoundary = Game.BOARD_HEIGHT - pacmanImageHeight; //May need to account for OS window's task bar here
		
		if (this.direction == Direction.Left && x > 0) {
			this.x = this.x - 1; 
		}
		if (this.direction == Direction.Right && x < rightBoundary) {
			this.x = this.x + 1; 
		}
		if (this.direction == Direction.Up && y > 0) {
			this.y = this.y - 1; 
		}
		if (this.direction == Direction.Down && y < bottomBoundary) {
			this.y = this.y + 1; 
		}
	}
}
