package shape;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;

public class DrawPanel extends Canvas {

    private int w = 600;
    private int h = 600;
    private ArrayList<Point> points = new ArrayList<Point>();
    private int pointsNumber =0;
    private GraphicsContext gc;
    private Color color = Color.BLACK;
    String shape = "";

    public DrawPanel() {

        super();
        gc = this.getGraphicsContext2D();

        setSize();
        setBackground(Color.WHITE);

        gc.setFill(color);
        gc.setStroke(color);
        this.setOnMouseClicked(mouseHandler);

    }

    private void setBackground(Color color) {
        gc.setFill(color);
        gc.fillRoundRect(0, 0, w, h, 0, 0);
    }

    private void setSize() {
        this.setHeight(h);
        this.setWidth(w);
    }

    void repaint() {
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        setBackground(Color.WHITE);
        points.clear();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setPointsNumber() {
        this.pointsNumber = points.size();
    }

    public void drawPoint(MouseEvent event) {
        //draw point by mouse click
        Point point = new Point((int) (event.getSceneX()), (int) event.getSceneY());
        points.add(point);
        setPointsNumber();
        gc.setFill(color);
        gc.fillOval(point.x - 2, point.y - 2, 5, 5);
    }


    private final EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

           drawPoint(event);

            //shapes are drawn by 2 points
            if (pointsNumber > 1 && pointsNumber % 2 == 0) {
                switch (shape) {
                    case "Line":
                        Line line = new Line(points.get(pointsNumber - 2), points.get(pointsNumber - 1), color);
                        line.draw(gc);

                        break;
                    case "Ray":
                        Ray ray = new Ray(points.get(pointsNumber - 2), points.get(pointsNumber - 1), color);
                        ray.draw(gc);
                        break;
                    case "Line Segment":
                        LineSegment lineSegment = new LineSegment(points.get(pointsNumber - 2), points.get(pointsNumber - 1), color);
                        lineSegment.draw(gc);
                        break;
                    case "Rectangle":
                        Rectangle rect= new Rectangle(points.get(pointsNumber - 2), points.get(pointsNumber - 1), color, color);
                        rect.draw(gc);
                        break;
                    case "Circle":
                        Circle circle = new Circle(points.get(pointsNumber - 2), points.get(pointsNumber - 1), color, Color.WHITE);
                        circle.draw(gc);
                        break;

                }

            }

            if (pointsNumber > 1 && pointsNumber % 3 == 0) {
                switch (shape) {
                    case "Ellipse":
                        Ellipse ellipse = new Ellipse(points.get(pointsNumber - 3), points.get(pointsNumber - 2),
                                points.get(pointsNumber - 1), color, Color.WHITE);
                        ellipse.draw(gc);
                        break;
                }

            }


        }
    };

}
