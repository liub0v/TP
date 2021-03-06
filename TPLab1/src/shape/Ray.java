package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
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


	@Override
	public void draw( GraphicsContext gc ) {

	}



	public void move(){

	}

}