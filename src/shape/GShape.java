package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.Serializable;

import shape.GAnchors.EAnchors;

// interface class
public abstract class GShape implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// component
	protected Shape shape;
	protected GAnchors anchors;
	// attributes
	protected boolean selected;
	protected EAnchors eAnchor;
	protected AffineTransform affineTransform;
	protected Color lineColor, fillColor;
	// working variables
	protected int px, py;

	// setters & getters
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public EAnchors getEAnchor() {
		return this.eAnchor;
	}

	public enum EDrawingType {
		eTP, eNP
	}

	private EDrawingType eDrawingType;

	// working variables

	public EDrawingType geteDrawingType() {
		return eDrawingType;
	}

	public void seteDrawingType(EDrawingType eDrawingType) {
		this.eDrawingType = eDrawingType;
	}

	// constructor
	public GShape() {
		this.anchors = new GAnchors();
		this.selected = false;
		this.eAnchor = EAnchors.SE;
	}

	public GShape clone() {
		try {
			return this.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	// methods
	

	public void draw(Graphics2D g2D) {
		g2D.draw(this.shape);

	}

	public void drawAnchor(Graphics2D g2D) {
		if (this.selected) {
			this.anchors.draw(g2D, this.shape.getBounds());
		}
	}

	public boolean isOn(int x, int y) {
		if (this.selected) {
			this.eAnchor = this.anchors.isOn(x, y);
			if (this.eAnchor != null) {
				return true;
			}
		}
		if (this.shape.contains(x, y)) {
			this.eAnchor = EAnchors.MM;
			return true;
		}
		return false;
	}

	public void initLocation(int x, int y) {
		px = x;
		py = y;
	}

	public abstract void setLocation(int x, int y);

	public abstract void setMove(int x, int y);

	public abstract void setReSize(int x, int y);

	public void addPoint(int x, int y) {
	}

}
