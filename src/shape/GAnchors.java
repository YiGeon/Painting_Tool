package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.util.Vector;

public class GAnchors implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum EAnchors {
		NN, NW, NE, SS, SW, SE, EE, WW, RR, MM
	}

	public final int WIDTH = 14;
	public final int HEIGHT = 14;

	private Vector<Ellipse2D> anchors;

	public GAnchors() {
		this.anchors = new Vector<Ellipse2D>();
		for (int i = 0; i < EAnchors.values().length - 1; i++) {
			Ellipse2D anchor = new Ellipse2D.Double();
			anchor.setFrame(0, 0, WIDTH, HEIGHT);
			this.anchors.add(anchor);
		}
	}

	public EAnchors isOn(int x, int y) {
		for (int i = 0; i < this.anchors.size(); i++) {
			if (this.anchors.get(i).contains(x, y)) {
				return EAnchors.values()[i];
			}
		}
		return null;
	}

	public void draw(Graphics2D g2D, Rectangle r) {
		// ÁÂÇ¥ °è»ê
		for (int i = 0; i < this.anchors.size(); i++) {
			int x = 0;
			int y = 0;
			EAnchors eAnchor = EAnchors.values()[i];
			switch (eAnchor) {
			case NN:
				x = r.x + r.width / 2;
				y = r.y;
				break;
			case NW:
				x = r.x;
				y = r.y;
				break;
			case NE:
				x = r.x + r.width;
				y = r.y;
				break;
			case SS:
				x = r.x + r.width / 2;
				y = r.y + r.height;
				break;
			case SW:
				x = r.x;
				y = r.y + r.height;
				break;
			case SE:
				x = r.x + r.width;
				y = r.y + r.height;
				break;
			case EE:
				x = r.x + r.width;
				y = r.y + r.height / 2;
				break;
			case WW:
				x = r.x;
				y = r.y + r.height / 2;
				break;
			case RR:
				x = r.x + r.width / 2;
				y = r.y - 30;
				break;
			default:
				break;
			}
			x = x - WIDTH / 2;
			y = y - HEIGHT / 2;
			this.anchors.get(i).setFrame(x, y, WIDTH, HEIGHT);

		}
		Color lineColor = Color.black;
		Color fillColor = Color.WHITE;
		for (Ellipse2D anchor : this.anchors) {
			g2D.setPaintMode();
			g2D.setColor(fillColor);
			g2D.fill(anchor);
			g2D.setColor(lineColor);
			g2D.draw(anchor);
		}
	}

}
