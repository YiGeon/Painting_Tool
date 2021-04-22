package transformer;

import java.awt.Graphics;
import java.awt.Graphics2D;

import shape.GShape;

public class GMover extends GTransformer {
	// constructor
	public GMover(GShape shape) {
		super(shape);
	}

	public void initTransforming(Graphics g, int x, int y) {
		this.shape.initLocation(x, y);
	}

	public void keepTransforming(Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setXORMode(g2d.getBackground());
		this.shape.draw(g2d);

		this.shape.setMove(x, y);
		this.shape.draw(g2d);
	}

	public void finishTransforming(Graphics g, int x, int y) {
	}

}
