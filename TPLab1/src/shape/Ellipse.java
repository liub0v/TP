package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * @version 1.0
 * @created 01-Mar-2021 23:41:39
 */
public class Ellipse extends TwoDimensionalShape {

	private Point cornerPoint;
	private int width;
	private int height;


	public Ellipse() {}


	public Ellipse(Point theCenter, Color borderColor, Color fillColor, Point cornerPoint) {
		super(theCenter, borderColor, fillColor);
		this.cornerPoint = cornerPoint;

	}

	@Override
	public boolean contains(Point pt) {
		int width = getWidth();
		int height = getHeight();
		Point theCenter = getCenter();
		double alpha = (double) (pt.x - theCenter.x) / width;
		double beta = (double) (pt.y - theCenter.y) / height;
		return 4 * (alpha * alpha + beta * beta) < 1;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setStroke(getBorderColor());
		gc.setFill(getFillColor());
		Point cornerPoint = getCornerPoint();
		gc.strokeOval(cornerPoint.x, cornerPoint.y, this.width, this.height);
		gc.fillOval(cornerPoint.x, cornerPoint.y, this.width, this.height);

	}

	public Point getCornerPoint() {
		return cornerPoint;
	}


	public void setCornerPointX(int x){
		this.cornerPoint.x = x;
	}
	public void setCornerPointY(int y){
		this.cornerPoint.y = y;
	}

	public void setCornerPoint(Point cornerPoint) {
		this.cornerPoint = cornerPoint;
		Point theCenter = getCenter();
		adaptCornerPoint(theCenter);
		this.width = 2 * (theCenter.x - cornerPoint.x);
		this.height = 2 * (theCenter.y - cornerPoint.y);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	protected void adaptCornerPoint(Point theCenter) {
		int deltaX = theCenter.x - cornerPoint.x;
		int deltaY = theCenter.y - cornerPoint.y;
		if (deltaX < 0)
			cornerPoint.translate(2 * deltaX, 0);
		if (deltaY < 0)
			cornerPoint.translate(0, 2 * deltaY);
	}

	public void move(Point pt) {
		Point theCenter = getCenter();
		cornerPoint.translate(pt.x - theCenter.x, pt.y - theCenter.y);
		super.move(pt);
	}

}