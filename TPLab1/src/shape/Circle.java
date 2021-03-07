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

	public Circle(Point theCenter, Point theSecondPoint, Color borderColor, Color fillColor) {
		super(theCenter,theSecondPoint,theSecondPoint,borderColor,fillColor);
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

	public void move(){

	}

}