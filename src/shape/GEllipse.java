package shape;

import java.awt.geom.Ellipse2D;

public class GEllipse extends GShape {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GEllipse() {
		super();
		this.shape = new Ellipse2D.Double(0, 0, 0, 0);
		this.seteDrawingType(EDrawingType.eTP);
	}

	public void setLocation(int x, int y) {
		Ellipse2D myShape = (Ellipse2D) this.shape;
		myShape.setFrame(x, y, 0, 0);
	}

	public void setMove(int x, int y) {
		Ellipse2D myShape = (Ellipse2D) this.shape;
		int newX = (int) (myShape.getX() + x - px);
		int newY = (int) (myShape.getY() + y - py);
		myShape.setFrame(newX, newY, myShape.getWidth(), myShape.getHeight());

		px = x;
		py = y;
	}

	@Override
	public void setReSize(int x, int y) {
		Ellipse2D myShape = (Ellipse2D) this.shape;
		int w = (int) (x - myShape.getX());
		int h = (int) (y - myShape.getY());
		switch (eAnchor) {
		case NN:
			int h1 = (int) (myShape.getY() + myShape.getHeight() - y);
			myShape.setFrame(myShape.getX(), y, myShape.getWidth(), h1);
			break;
		case NW:
			int w2 = (int) (myShape.getX() + myShape.getWidth() - x);
			int h2 = (int) (myShape.getY() + myShape.getHeight() - y);
			myShape.setFrame(x, y, w2, h2);
			break;
		case NE:
			int h3 = (int) (myShape.getY() + myShape.getHeight() - y);
			myShape.setFrame(myShape.getX(), y, w, h3);
			break;
		case SW:
			int w4 = (int) (myShape.getX() + myShape.getWidth() - x);
			myShape.setFrame(x, myShape.getY(), w4, h);
			break;
		case SS:
			myShape.setFrame(myShape.getX(), myShape.getY(), myShape.getWidth(), h);
			break;
		case SE:
			myShape.setFrame(myShape.getX(), myShape.getY(), w, h);
			break;
		case EE:
			myShape.setFrame(myShape.getX(), myShape.getY(), w, myShape.getHeight());
			break;
		case WW:
			int w6 = (int) (myShape.getX() + myShape.getWidth() - x);
			myShape.setFrame(x, myShape.getY(), w6, myShape.getHeight());
			break;
		default:
			break;
		}

	}

}
