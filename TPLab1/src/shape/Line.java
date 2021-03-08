package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Line extends OneDimensionalShape {

    public Line() {

    }

    public Line(Point theCenter, Point theSecondPoint, Color borderColor) {
        super(theCenter, theSecondPoint, borderColor);
    }

    public void finalize() throws Throwable {
        super.finalize();
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


    public void draw(GraphicsContext gc) {

        super.draw(gc);

        Pair<Double,Double> coeff = coefficients(getCenter(),getTheSecondPoint());
        double a = coeff.getKey();
        double b = coeff.getValue();


        gc.beginPath();

        if (Double.isInfinite(a) || Double.isInfinite(b)){
            double x = getCenter().x;
            gc.strokeLine(x, 600,x, 0);
        }else if (a < 0 ) {
            gc.strokeLine(0, b,-b / a, 0);

        } else if (a > 0 && b > 0) {
            gc.strokeLine(0, b,(600 - b) / a, 600);

        } else if (a > 0 && b < 0) {
            gc.strokeLine(600, 600 * a + b,(0 - b) / a, 0);

        } else if (a == 0) {
            gc.strokeLine(0, b,600, b);
        }

        gc.stroke();

    }



}