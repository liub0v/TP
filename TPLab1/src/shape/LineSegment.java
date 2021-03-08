package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.awt.*;

/**
 * @version 1.0
 * @created 01-Mar-2021 23:41:40
 */
public class LineSegment extends Ray {

	public LineSegment(){

	}

	public LineSegment(Point theCenter, Point theSecondPoint, Color borderColor) {
		super(theCenter, theSecondPoint, borderColor);
	}

	@Override
	public void draw( GraphicsContext gc ) {
		gc.setStroke(getBorderColor());
		gc.strokeLine(getCenter().x, getCenter().y, getTheSecondPoint().x, getTheSecondPoint().y);
	}


	public void move(){

	}

}