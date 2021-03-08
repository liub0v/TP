package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * @version 1.0
 * @created 01-Mar-2021 23:41:39
 */
public class Circle extends Ellipse {

	public Circle(){

	}

	public Circle(Point theCenter, Color borderColor, Color fillColor, Point cornerPoint) {
		super(theCenter, borderColor, fillColor, cornerPoint);
	}


	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public void draw( GraphicsContext g ) {
		super.draw(g);
		/*g.setStroke(getBorderColor());
		g.setFill(getFillColor());
		double x = getCenter().x;
		double y = getCenter().y;
		double radius = Math.sqrt((x-getFirstPoint().x)*	(x-getFirstPoint().x)+
				(y-getFirstPoint().y)*(y-getFirstPoint().y))*2;
		g.strokeOval(getCenter().x - radius/2, getCenter().y-radius/2, radius,radius);
		g.fillOval(getCenter().x - radius/2, getCenter().y-radius/2, radius,radius);*/
	}


	public Point getCenter(){
		return super.getCenter();
	}

	@Override
	protected void adaptCornerPoint(Point theCenter) {
		Point cornerPoint = getCornerPoint();
		int deltaX = theCenter.x - cornerPoint.x;
		int deltaY = theCenter.y - cornerPoint.y;
		if (deltaX < 0)
			cornerPoint.translate(2 * deltaX, 0);
		if (deltaY < 0)
			cornerPoint.translate(0, 2 * deltaY);
		cornerPoint.setLocation(cornerPoint.x, theCenter.y - theCenter.x + cornerPoint.x);
	}


}