package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * @version 1.0
 * @created 01-Mar-2021 23:41:39
 */
public class Ellipse extends TwoDimensionalShape {

	private Point firstPoint;
	private Point secondPoint;

	public Ellipse(){

	}

	public Ellipse(Point theCenter, Point firstPoint, Point secondPoint, Color borderColor, Color fillColor) {
		super(theCenter,borderColor,fillColor);
		this.firstPoint=firstPoint;
		this.secondPoint=secondPoint;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public void draw( GraphicsContext gc ) {
		gc.setStroke(getBorderColor());
		gc.setFill(getFillColor());
		double x = getCenter().x;
		double y = getCenter().y;
		double height = Math.sqrt((x-firstPoint.x)*(x-firstPoint.x)+
				(y-firstPoint.y)*(y-firstPoint.y))*2;
		double width = Math.sqrt((x-secondPoint.x)*	(x-secondPoint.x)+
				(y-secondPoint.y)*(y-secondPoint.y))*2;
		gc.strokeOval(getCenter().x - width/2, getCenter().y-height/2, width,height);
		gc.fillOval(getCenter().x - width/2, getCenter().y-height/2, width,height);
	}


	public Point getCenter(){
		return super.getCenter();
	}

	public Point getFirstPoint(){
		return firstPoint;
	}

	public void move(){

	}

}