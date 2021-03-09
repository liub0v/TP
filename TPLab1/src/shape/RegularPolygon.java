package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;

/**
 * @version 1.0
 * @created 01-Mar-2021 23:41:40
 */
public class RegularPolygon extends Polygon {

	private int numberOfSides;

	public RegularPolygon(){}

    public RegularPolygon(Point theCenter, Point theSecondPoint, Color borderColor, Color fillColor, int numberOfSides) {
        super(theCenter, borderColor, fillColor);
        this.numberOfSides = numberOfSides;
        setPoints(getRegularPolygonPoints(theSecondPoint,numberOfSides));
    }

	public ArrayList<Point> getRegularPolygonPoints(Point theSecondPoint, int numberOfSides) {
		Point theCenter = getCenter();
		ArrayList<Point> points = new ArrayList<Point>(numberOfSides + 1);
		double radius = Math.sqrt(Math.pow((theSecondPoint.x) - theCenter.x, 2) + Math.pow(theSecondPoint.y - theCenter.y, 2));
		double z;
		double angle = 360.0 / numberOfSides;

		if (numberOfSides % 2 != 0)
			z = 90;
		else
			z = 90 - angle / 2;

		for (int i = 0; i < numberOfSides; i++) {
			points.add(new Point(theCenter.x + (int) (Math.cos(z / 180 * Math.PI) * radius),
					theCenter.y - (int) (Math.sin(z / 180 * Math.PI) * radius)));
			z = z + angle;
		}
		return points;
	}
	@Override
	public void draw(GraphicsContext gc){

		super.draw(gc);
	}


	public void finalize() throws Throwable {
		super.finalize();

	}

	public Point getCenter(){
		return super.getCenter();
	}

}