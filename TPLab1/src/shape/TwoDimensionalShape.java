package shape;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * @version 1.0
 * @created 24-���-2021 13:54:08
 */
public abstract class TwoDimensionalShape extends Shape {

	private Color fillColor;

	public TwoDimensionalShape(){
	}

	public TwoDimensionalShape(Point theCenter, Color borderColor, Color fillColor){
		super(theCenter,borderColor);
		this.fillColor=fillColor;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(GraphicsContext gc){
		gc.setStroke(getBorderColor());
		gc.setFill(getFillColor());
	}

//	public void getCenter(){
//
//	}

	public Color getFillColor(){
		return fillColor;
	}

}