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
	}


	public Pair<Double,Double> coefficients (Point start, Point end){
		double x1 = start.x;
		double x2 = end.x;

		double y1 = start.y;
		double y2 = end.y;

		double a = (y2 - y1) / (x2 - x1);
		double b = -(a * x1) + y1;

		return new Pair<>(a,b);

	}

	@Override
	public void draw( GraphicsContext gc ) {
		gc.setStroke(getBorderColor());

		double x1 = getCenter().x;
		double y1 = getCenter().y;
		double x2 = getTheSecondPoint().x;
		double y2 = getTheSecondPoint().y;

		//if(getTheSecondPoint().x>0&&getTheSecondPoint().x<600&&
		//		getTheSecondPoint().y>0&&getTheSecondPoint().y<600){

			Pair<Double,Double> coeff = coefficients(getCenter(),getTheSecondPoint());
			double a = coeff.getKey();
			double b = coeff.getValue();

			if (Double.isInfinite(a)|| Double.isInfinite(b)){

				if(y1<y2)
					gc.strokeLine(x1, y1, x1, 600);
				else
					gc.strokeLine(x1, y1, x1, 0);
			} else if (a == 0) {
				if(x1<x2)
					gc.strokeLine(x1, y1,600, y1);
				else
					gc.strokeLine(x1, y1,0, y1);
			} else {
				gc.strokeLine(0, b,-b / a, 0);

			}
		//}
		//else gc.strokeLine(x1, y1, x2, y2);

	}



	public void move(){

	}

}