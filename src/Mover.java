import java.awt.Graphics;
import java.awt.Image;

// The Mover class represents an object on screen that moves, such as Pacman or a Ghost.
// 'Mover' is abstract, which means it contains some common logic for both the Pacman and Ghost
// classes which inherit from it. Also, abstract indicates that 'Mover' declares an abstract function (setImage),
// which means that Pacman/Ghost must supply a definition for that function.
public abstract class Mover {
	public Mover(int x, int y, Direction direction, String imagePath) {
		this.x = x;
		this.y = y;
		this.setDirection(direction);
		this.setImage(direction);
	}
	
	// Sets the image of the Mover object based on the given direction.
	// This is an abstract function, which means the classes that inherit from Mover
	// must implement their own definitions.
	public abstract void setImage(Direction direction);
	
	//TODO: move the following things to this class: 
	//  Variables: x, y, direction, image, imageWidth, imageHeight
	//	Functions: setDirection, getXPosition, getYPosition, draw, updateCoordinates
}
