package shape;

import java.awt.Rectangle;
import java.io.Serializable;

public class GRectangle extends GShape implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GRectangle() {
		this.shape = new Rectangle(0, 0, 0, 0);
		this.seteDrawingType(EDrawingType.eTP);
	}

	public void setLocation(int x, int y) {
		Rectangle myShape = (Rectangle) this.shape;
		myShape.setLocation(x, y);
	}

	public void setMove(int x, int y) {
		Rectangle myShape = (Rectangle) this.shape;
		myShape.x = myShape.x + x - px;
		myShape.y = myShape.y + y - py;
		px = x;
		py = y;
	}

	@Override
	public void setReSize(int x, int y) {
		Rectangle myShape = (Rectangle) this.shape;
		switch (eAnchor) {
		case NN:
			int h1 = myShape.y + myShape.height - y;
			myShape.setLocation(myShape.x, y);
			myShape.setSize(myShape.width, h1);
			break;
		case NW:
			int w2 = myShape.x + myShape.width - x;
			int h2 = myShape.y + myShape.height - y;
			myShape.setLocation(x, y);
			myShape.setSize(w2, h2);
			break;
		case NE:
			int h3 = myShape.y + myShape.height - y;
			myShape.setLocation(myShape.x, y);
			myShape.setSize(x - myShape.x, h3);
			break;
		case SW:
			int w4 = myShape.x + myShape.width - x;
			myShape.setLocation(x, myShape.y);
			myShape.setSize(w4, y - myShape.y);
			break;
		case SS:
			myShape.setSize(myShape.width, y - myShape.y);
			break;
		case SE:
			myShape.setSize(x - myShape.x, y - myShape.y);
			break;
		case EE:
			myShape.setSize(x - myShape.x, myShape.height);
			break;
		case WW:
			int w6 = myShape.x + myShape.width - x;
			myShape.setLocation(x, myShape.y);
			myShape.setSize(w6, myShape.height);
			break;
		default:
			break;
		}
	}
}
