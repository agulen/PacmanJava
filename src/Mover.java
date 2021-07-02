import java.awt.Graphics;
import java.awt.Image;

// The Mover class represents an object on screen that moves, such as Pacman or a Ghost.
// 'Mover' is abstract, which means it contains some common logic for both the Pacman and Ghost
// classes which inherit from it. Also, abstract indicates that 'Mover' declares an abstract function (setImage), 
// which means that Pacman/Ghost must supply a definition for that function.
public abstract class Mover {
	private static final int moverImageHeight = 20;
	private static final int moverImageWidth = 20;
	
	private int x; 
	private int y;
	private Direction direction;
	
	// The 'protected' keyword here means that classes that
	// inherit from Mover can access the 'image' variable
	protected Image image;

	public Mover(int x, int y, Direction direction) {
		this.x = x; 
		this.y = y;
		this.direction = direction;
	}
	
	// Sets the image of the Mover object based on the given direction.
	// This is an abstract function, which means the classes that inherit from Mover
	// must implement their own definitions. 
	public abstract void setImage(Direction direction);
	
	// Sets the direction of the Mover object and also updates the image shown to the screen
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	// Draws an image of the mover to the screen.
	// This method is getting called many times per second.
	public void draw(Graphics graphics) {
		setImage(direction);
		graphics.drawImage(this.image, this.x, this.y, null);		
		updateCoordinates();
	}
	
	// Updates the coordinates of the Mover object rendered to the screen.
	// This will respect the boundaries of the window as well, so the Mover won't go off-screen
	private void updateCoordinates() {
		int rightBoundary = Game.BOARD_WIDTH - moverImageWidth;
		int bottomBoundary = Game.BOARD_HEIGHT - moverImageHeight; //May need to account for OS window's task bar here
		
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
