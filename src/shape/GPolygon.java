package shape;

import java.awt.Polygon;
import java.io.Serializable;

public class GPolygon extends GShape implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GPolygon() {
		this.shape = new Polygon();
		this.seteDrawingType(EDrawingType.eNP);

	}

	@Override
	public void setLocation(int x, int y) {
		Polygon polygon = (Polygon) this.shape;
		polygon.addPoint(x, y);
		polygon.addPoint(x, y);

	}

	@Override
	public void setMove(int x, int y) {
		Polygon polygon = (Polygon) this.shape;
		polygon.xpoints[polygon.npoints - 1] = x;
		polygon.ypoints[polygon.npoints - 1] = y;
	}

	public void addPoint(int x, int y) {
		Polygon polygon = (Polygon) this.shape;
		polygon.addPoint(x, y);
	}

	@Override
	public void setReSize(int x, int y) {
		Polygon polygon = (Polygon) this.shape;
		polygon.addPoint(x, y);

	}

}
