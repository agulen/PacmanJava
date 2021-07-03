import java.awt.Image;
import javax.swing.ImageIcon;

// The class represents a Ghost character that moves around the game board
public class Ghost extends Mover {
	private static Image redLeft  	  = new ImageIcon("img/ghost1red/left.jpg").getImage();
	private static Image redRight 	  = new ImageIcon("img/ghost1red/right.jpg").getImage();
	
	private GhostType ghostType; 
	
	public Ghost(int x, int y, Direction direction, GhostType ghostType) {
		super(x, y, direction);
		this.ghostType = ghostType;
	}

	@Override
	public void setImage(Direction direction) {
		boolean directionIsUpOrLeft = (direction == Direction.Up || direction == Direction.Left);
		if (directionIsUpOrLeft) {
			this.image = redLeft;
		}
		else {
			this.image = redRight;
		}
	}
}
