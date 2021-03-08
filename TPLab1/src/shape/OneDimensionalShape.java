package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.awt.*;

/**
 * @version 1.0
 * @created 01-Mar-2021 23:41:40
 */
public abstract class OneDimensionalShape extends Shape {

	private Point theSecondPoint;

	public OneDimensionalShape(){

	}
	public OneDimensionalShape(Point theCenter, Point theSecondPoint, Color borderColor) {
		super(theCenter, borderColor);
		this.theSecondPoint = theSecondPoint;
	}

	@Override
	public void draw( GraphicsContext gc ) {
		gc.setStroke(getBorderColor());

	}

	public Point getTheSecondPoint()
	{
		return theSecondPoint;
	}

	@Override
	public boolean contains(Point pt) {
		Point theCenter = getCenter();
		int a = theSecondPoint.y - theCenter.y;
		int b = theSecondPoint.x - theCenter.x;
		double d = (a * pt.x - b * pt.y + b * theCenter.y - a * theCenter.x) / (Math.sqrt(a * a + b * b));
		return Math.abs(d) < 800 / 2;
	}

	@Override
	public void move(Point pt) {
		Point theCenter = getCenter();
		setTheSecondPoint(new Point(getTheSecondPoint().x + pt.x - theCenter.x, getTheSecondPoint().y + pt.y - theCenter.y));
		super.move(pt);
	}


	public void setTheSecondPoint(Point theSecondPoint) {
		this.theSecondPoint = theSecondPoint;
	}
}