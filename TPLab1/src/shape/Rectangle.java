package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;


public class Rectangle extends Polygon {

	public Rectangle() {
	}

	public Rectangle(Point theCenter, Point cornerPoint, Color borderColor, Color fillColor) {
		super(theCenter, borderColor, fillColor);
		setPoints(getParallelogramPoints(cornerPoint));
	}

	@Override
	public void move(Point pt) {
		super.move(pt);
	}

	public ArrayList<Point> getParallelogramPoints(Point cornerPoint) {
		Point theCenter = getCenter();
		ArrayList<Point> points = new ArrayList<>(4);
		//Point upperLeft = new Point(2 * theCenter.x - cornerPoint.x, 2 * theCenter.y - cornerPoint.y);
		//Point upperRight = new Point(cornerPoint.x + cornerPoint.y - upperLeft.y, upperLeft.y);
		//Point bottomLeft = new Point(2 * theCenter.x - upperRight.x, 2 * theCenter.y - upperRight.y);
		Point upperLeft = new Point(2 * theCenter.x - cornerPoint.x, 2 * theCenter.y - cornerPoint.y);
		Point upperRight = new Point(cornerPoint.x, upperLeft.y);
		Point bottomLeft = new Point(2 * theCenter.x - upperRight.x, 2 * theCenter.y - upperRight.y);

		points.add(cornerPoint);
		points.add(upperRight);
		points.add(upperLeft);
		points.add(bottomLeft);
		return points;
	}

	@Override
	public void draw(GraphicsContext gc){
		super.draw(gc);
	}

	public void setCornerPoint(Point pt) {
		setPoints(getParallelogramPoints(pt));
	}


}