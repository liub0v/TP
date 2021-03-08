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
	@Override
	public boolean contains(Point pt) {
		double x = getCenter().x;
		double y = getCenter().y;
		double height = Math.sqrt((x-firstPoint.x)*(x-firstPoint.x)+
				(y-firstPoint.y)*(y-firstPoint.y))*2;
		double width = Math.sqrt((x-secondPoint.x)*	(x-secondPoint.x)+
				(y-secondPoint.y)*(y-secondPoint.y))*2;
		Point theCenter = getCenter();
		double alpha = (double) (pt.x - theCenter.x) / width;
		double beta = (double) (pt.y - theCenter.y) / height;
		return 4 * (alpha * alpha + beta * beta) < 1;
	}

	public Point getCenter(){
		return super.getCenter();
	}

	public Point getFirstPoint(){
		return firstPoint;
	}

	public void move(Point pt) {
		Point theCenter = getCenter();
		double x = getCenter().x;
		double y = getCenter().y;
		double height = Math.sqrt((x-firstPoint.x)*(x-firstPoint.x)+
				(y-firstPoint.y)*(y-firstPoint.y))*2;
		double width = Math.sqrt((x-secondPoint.x)*	(x-secondPoint.x)+
				(y-secondPoint.y)*(y-secondPoint.y))*2;
		this.firstPoint = new Point((int)(pt.x+ height), (int)(pt.x+height));
		this.secondPoint= new Point((int)(pt.x+ width), (int)(pt.x+width));
		super.move(pt);
	}

}