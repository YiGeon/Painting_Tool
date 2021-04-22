package shape;

import java.awt.geom.Line2D;

public class GLine extends GShape {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x3, y3, x4, y4;

	public GLine() {
		this.shape = new Line2D.Double(0, 0, 0, 0);
		this.seteDrawingType(EDrawingType.eTP);
	}

	@Override
	public void setLocation(int x, int y) {
		x3 = x;
		y3 = y;
	}

	@Override
	public void setMove(int x, int y) {
		Line2D myShape = (Line2D) this.shape;
		int newX = (int) (myShape.getX1() + x - px);
		int newY = (int) (myShape.getY1() + y - py);
		myShape.setLine(newX, newY, myShape.getX2(), myShape.getX2());

		px = x;
		py = y;
	}

	@Override
	public void setReSize(int x, int y) {
		Line2D myShape = (Line2D) this.shape;
		myShape.setLine(x3, y3, x, y);

	}

}
