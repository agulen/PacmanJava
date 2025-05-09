import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Random;

// The class represents a Ghost character that moves around the game board
public class Ghost extends Mover { 
	private final static Image redLeft  	= new ImageIcon("img/ghost1red/left.jpg").getImage();
	private final static Image orangeLeft   = new ImageIcon("img/ghost2orange/left.jpg").getImage();
	private final static Image blueLeft  	= new ImageIcon("img/ghost3blue/left.jpg").getImage();
	private final static Image pinkLeft  	= new ImageIcon("img/ghost4pink/left.jpg").getImage();
	private final static Image redRight 	= new ImageIcon("img/ghost1red/right.jpg").getImage();
	private final static Image orangeRight  = new ImageIcon("img/ghost2orange/right.jpg").getImage();
	private final static Image blueRight    = new ImageIcon("img/ghost3blue/right.jpg").getImage();
	private final static Image pinkRight    = new ImageIcon("img/ghost4pink/right.jpg").getImage();
	
	private GhostType ghostType;
	private Random random = new Random();
	
	public Ghost(int x, int y, Direction direction, GhostType ghostType) {
		super(x, y, direction);
		this.ghostType = ghostType;
	}

	@Override
	public void setImage(Direction direction) {
		boolean directionIsUpOrLeft = (direction == Direction.Up || direction == Direction.Left);
		
		switch (ghostType) {
			case Red:
				this.image = directionIsUpOrLeft ? redLeft : redRight; 
				break;
			case Orange:
				this.image = directionIsUpOrLeft ? orangeLeft : orangeRight; 
				break;
			case Blue:
				this.image = directionIsUpOrLeft ? blueLeft : blueRight; 
				break;
			case Pink:
				this.image = directionIsUpOrLeft ? pinkLeft : pinkRight; 
				break;
		}
	}
	
	// Moves the ghost based on a random number generator.
	// This function get called many times per second. 
	public void move() {
		if (shouldChangeDirection()) {
			goInRandomDirection();
		}
	}
	
	// Returns whether or not a Ghost should change direction.
	// This function gets called 125 times per second, so the ghost
	// should go in the same direction the majority of the time. 
	private boolean shouldChangeDirection() {
		int threshold = 97; 
		int changeChance = this.random.nextInt(100);
        
		return changeChance >= threshold;
	}
	
	// Changes the current direction of the ghost randomly.
	// Each direction is weighted the same. 
	private void goInRandomDirection() {
		int newDirection = this.random.nextInt(4);
        switch (newDirection) {
            case 0:
	            this.setDirection(Direction.Up);
	            break;
            case 1:
	            this.setDirection(Direction.Right);
	            break;
            case 2:
	            this.setDirection(Direction.Down);
	            break;
            case 3:
	            this.setDirection(Direction.Left);
	            break;
        }
	}
}
