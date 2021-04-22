package global;

import shape.GEllipse;
import shape.GLine;
import shape.GPolygon;
import shape.GRectangle;
import shape.GShape;

public class GConstant {
	// configurations
	public static String PATH = "resource";
	public static enum EShapes {
		eRectangle("rectangle.gif","rectangleSLT.gif", new GRectangle()),
		eEllipse("ellipse.gif","ellipseSLT.gif", new GEllipse()),
		eLine("line.gif","lineSLT.gif", new GLine()),
		ePolygon("polygon.gif","polygonSLT.gif", new GPolygon());
	//	eText("text.png","textSLT.png", new GText());
		
		private String iconName;
		private String iconSLTName;
		private GShape shape;
		private EShapes(String iconName, String iconSLTName, GShape shape) {
			this.iconName = iconName;
			this.iconSLTName = iconSLTName;
			this.shape = shape;
		}
		public String getIconName() { 
			return PATH + '/' + this.iconName; 
		}
		public String getIconSLTName() {
			return PATH + '/' + this.iconSLTName; 
		}
		public GShape getShape() {
			return this.shape;
		}
	};	
}
