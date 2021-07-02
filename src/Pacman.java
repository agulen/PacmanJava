import java.awt.Image;
import javax.swing.ImageIcon;

public class Pacman extends Mover {
	private static Image pacmanLeft  = new ImageIcon("img/pacmanleft.jpg").getImage();
	private static Image pacmanRight = new ImageIcon("img/pacmanright.jpg").getImage();
	private static Image pacmanUp    = new ImageIcon("img/pacmanup.jpg").getImage();
	private static Image pacmanDown  = new ImageIcon("img/pacmandown.jpg").getImage();
	
	public Pacman(int x, int y, Direction direction) {
		super(x, y, direction);	
	}

	@Override
	public void setImage(Direction direction) {		
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
}
