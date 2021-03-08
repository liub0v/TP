package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;


public abstract class Shape {

    private Color borderColor;
    private Point theCenter;

    public Shape() {

    }

    public Shape(Point theCenter, Color borderColor) {
        this.borderColor = borderColor;
        this.theCenter = theCenter;
    }

    public abstract void draw(GraphicsContext gc);

    public Point getCenter() {
        return theCenter;
    }

    public void setTheCenter(Point theCenter) {
        this.theCenter = theCenter;
    }

    public void move(Point pt) {
        this.theCenter=pt;
    }

    public abstract boolean contains(Point pt);

    public Color getBorderColor() {
        return borderColor;
    }
}