package transformer;

import java.awt.Graphics;
import java.awt.Graphics2D;

import shape.GShape;
import shape.GAnchors.EAnchors;

public class GResizer extends GTransformer {

	public GResizer(GShape shape) {
		super(shape);
	}

	@Override
	public void initTransforming(Graphics g, int x, int y) {

	}

	@Override
	public void keepTransforming(Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D)g;		
		g2d.setXORMode(g2d.getBackground());
		this.shape.draw(g2d);	
		EAnchors eAnchor = this.shape.getEAnchor();
		switch (eAnchor) {
		case NN:
			this.shape.setReSize(x, y); 
			break;
		case NW:
			this.shape.setReSize(x, y); 
			break;
		case NE:
			this.shape.setReSize(x, y); 
			break;
		case SW:
			this.shape.setReSize(x, y); 
			break;
		case SS:
			this.shape.setReSize(x, y); 
			break;
		case SE:
			this.shape.setReSize(x, y); 
			break;
		case EE:
			this.shape.setReSize(x, y); 
			break;
		case WW:
			this.shape.setReSize(x, y); 
			break;
		default:
			break;
		}
		this.shape.draw(g2d);
	}

	@Override
	public void finishTransforming(Graphics g, int x, int y) {

	}

}
