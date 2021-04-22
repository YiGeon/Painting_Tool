package transformer;

import java.awt.Graphics;

import shape.GShape;

public abstract class GTransformer {
	protected GShape shape;

	public GTransformer(GShape shape) {
		this.shape = shape;
	}

	public abstract void initTransforming(Graphics g, int x, int y);

	public abstract void keepTransforming(Graphics g, int x, int y);

	public abstract void finishTransforming(Graphics g, int x, int y);

}
