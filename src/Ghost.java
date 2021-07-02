import java.awt.Image;
import javax.swing.ImageIcon;

// The class represents a Ghost character that moves around the game board
public class Ghost extends Mover {
	
	//TODO: add member variables for each ghost's images
	
	//TODO: add a member variable to indicate the type of ghost
	
	public Ghost(int x, int y, Direction direction, GhostType ghostType) {
		super(x, y, direction);
	}

	@Override
	public void setImage(Direction direction) {
		//TODO: implement setImage for the ghost class.
		//Similar to Pacman, the correct image to use will depend on the direction 
	}
}
