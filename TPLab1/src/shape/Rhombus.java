package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;

/**
 * @version 1.0
 * @created 01-Mar-2021 23:41:41
 */
public class Rhombus extends Polygon {

	public Rhombus(){

	}

	public Rhombus(Point theCenter, Point theFirstPoint, Point theSecondPoint, Color borderColor, Color fillColor) {
		super(theCenter, borderColor, fillColor);
		setPoints(getRhombusPoints(theFirstPoint, theSecondPoint));
	}

	public ArrayList<Point> getRhombusPoints(Point theFirstPoint, Point theSecondPoint) {
		Point theCenter = getCenter();
		ArrayList<Point> points = new ArrayList<>(4);
		double height = Math.sqrt((theCenter.x-theFirstPoint.x)*(theCenter.x-theFirstPoint.x)+
				(theCenter.y-theFirstPoint.y)*(theCenter.y-theFirstPoint.y));
		double width = Math.sqrt((theCenter.x-theSecondPoint.x)* (theCenter.x-theSecondPoint.x)+
				(theCenter.y-theSecondPoint.y)*(theCenter.y-theSecondPoint.y));
		Point left = new Point(theCenter.x - (int) width, theCenter.y);
		Point right = new Point(theCenter.x + (int) width, theCenter.y);
		Point up = new Point(theCenter.x, theCenter.y - (int) height);
		Point bottom = new Point(theCenter.x, theCenter.y + (int) height);

		points.add(left);
		points.add(up);
		points.add(right);
		points.add(bottom);
		return points;
	}


	@Override
	public void draw( GraphicsContext g ) {
		super.draw(g);
	}


	public Point getCenter(){
		return super.getCenter();
	}

	public void move(){

	}

}