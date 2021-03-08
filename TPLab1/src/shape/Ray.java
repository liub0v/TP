package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.awt.*;

/**
 * @version 1.0
 * @created 01-Mar-2021 23:41:40
 */
public class Ray extends Line {

	public Ray(){

	}

	public Ray(Point theCenter, Point theSecondPoint, Color borderColor) {
		super(theCenter, theSecondPoint, borderColor);
		theSecondPoint = getOutScreenPoint(theSecondPoint);
	}


	public Point getOutScreenPoint(Point theSecondPoint) {
		Point theCenter = getCenter();
		Point result = new Point();
		double deltaX = theSecondPoint.x - theCenter.x;
		double deltaY = theSecondPoint.y - theCenter.y;
		if (deltaX==0 && deltaY==0)
			return theSecondPoint;
		if (Math.abs(deltaX) < Math.abs(deltaY)) {
			double height;
			if (deltaY < 0)
				height = -1;
			else
				height = 600 + 1;
			result.setLocation(deltaX / deltaY * (height - theCenter.y) + theCenter.x, height);
		} else {
			double width;
			if (deltaX < 0)
				width = -1;
			else
				width = 600 + 1;
			result.setLocation(width, deltaY / deltaX * (width - theCenter.x) + theCenter.y);
		}
		return result;
	}


	@Override
	public void draw( GraphicsContext gc ) {
		gc.setStroke(getBorderColor());

		double x1 = getCenter().x;
		double y1 = getCenter().y;
		Point endPoint = getOutScreenPoint(getTheSecondPoint());
		double x2 = endPoint.x;
		double y2 = endPoint.y;

		gc.setStroke(getBorderColor());
		gc.strokeLine(x1, y1, x2, y2);

	}



	public void move(){

	}

}