package shape;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

public class DrawPanel extends Canvas {

    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    private ArrayList<Point> points = new ArrayList<Point>();
    private int pointsNumber =0;
    private GraphicsContext gc;
    private Color borderColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    private Shape myShape;
    String shape = "";
    private boolean letsmove = false;
    private boolean isDragged = true;
    private int numberOfSides = 4;

    public DrawPanel() {

        super();
        gc = this.getGraphicsContext2D();
        setSize();
        setBackground(Color.WHITE);
        letsmove = getLetsMoveValue();
        gc.setFill(fillColor);
        gc.setStroke(borderColor);
        this.setOnMouseClicked(mouseHandler);
        this.setOnMouseDragged(mouseHandler2);
        this.setOnMouseReleased(mouseHandler3);
    }

    private void setBackground(Color color) {
        gc.setFill(color);
        gc.fillRoundRect(0, 0, WIDTH, HEIGHT, 0, 0);
    }

    private void setSize() {
        this.setHeight(HEIGHT);
        this.setWidth(WIDTH);
    }

    void repaint() {
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        setBackground(Color.WHITE);
        points.clear();
    }

    public void moving(boolean value){
     this.letsmove = value;
    }

    boolean getLetsMoveValue(){
        return this.letsmove;
    }
    void resetPoints() {
        points.clear();
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
    }
    public void setFillColor(Color color) {
        this.fillColor = color;
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
        gc.setFill(borderColor);
        gc.fillOval(point.x - 2, point.y - 2, 5, 5);
    }


    private final EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

            if (getLetsMoveValue()) {
                Point point = new Point((int) (event.getSceneX()),
                        (int) event.getSceneY());
                if (myShape.contains(point)) {
                    isDragged = true;
                }
            } else {
                drawPoint(event);
                //shapes are drawn by 2 points
                if (pointsNumber % 2 == 0) {
                    switch (shape) {
                        case "Line":
                            myShape = new Line(points.get(pointsNumber - 2), points.get(pointsNumber - 1), borderColor);
                            myShape.draw(gc);

                            break;
                        case "Ray":
                            myShape = new Ray(points.get(pointsNumber - 2), points.get(pointsNumber - 1), borderColor);
                            myShape.draw(gc);
                            break;
                        case "Line Segment":
                            myShape = new LineSegment(points.get(pointsNumber - 2), points.get(pointsNumber - 1), borderColor);
                            myShape.draw(gc);
                            break;
                        case "Broken line":
                            myShape = new BrokenLine(points.get(pointsNumber - 2), points.get(pointsNumber - 1), borderColor);
                            myShape.draw(gc);
                            ((BrokenLine) myShape).addPoint(new Point((int) (event.getSceneX()), (int) event.getSceneY()));
                            break;
                        case "Rectangle":
                            myShape = new Rectangle(points.get(pointsNumber - 2), points.get(pointsNumber - 1), borderColor, fillColor);
                            myShape.draw(gc);
                            break;
                        case "Parallelogram":
                            myShape = new Parallelogram(points.get(pointsNumber - 2), points.get(pointsNumber - 1), borderColor, fillColor);
                            myShape.draw(gc);
                            break;
                        case "Regular Polygon":
                            TextInputDialog td = new TextInputDialog("4");
                            td.setHeaderText("Number of sides");
                            Optional<String> result = td.showAndWait();
                            if (result.isPresent()){
                                numberOfSides = Integer.parseInt(result.get());
                            }
                            myShape = new RegularPolygon( points.get(pointsNumber - 2), points.get(pointsNumber - 1),
                                    borderColor, Color.WHITE, numberOfSides);
                            myShape.draw(gc);
                            break;
                        case "Ellipse":
                            myShape = new Ellipse(points.get(pointsNumber - 2),
                                    borderColor, fillColor, points.get(pointsNumber - 1));
                            Ellipse e = (Ellipse) myShape;
                            e.setCornerPoint(points.get(pointsNumber - 1));
                            myShape.draw(gc);
                            break;
                        case "Circle":
                            myShape = new Circle(points.get(pointsNumber - 2),
                                    borderColor, fillColor, points.get(pointsNumber - 1));
                            Circle c = (Circle) myShape;
                            c.setCornerPoint(points.get(pointsNumber - 1));
                            myShape.draw(gc);
                            break;
                    }

                }
                //shapes are drawn by 3 points
                if (pointsNumber > 1 && pointsNumber % 3 == 0) {
                    switch (shape) {
                        case "Rhombus":
                            myShape = new Rhombus(points.get(pointsNumber - 3), points.get(pointsNumber - 2),
                                    points.get(pointsNumber - 1), borderColor, fillColor);
                            myShape.draw(gc);
                            break;
                    }

                }
                //shapes are drawn by more points
                //shapes are drawn by fixed amount points

            }
        }

    };


    private final EventHandler<MouseEvent> mouseHandler2 = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            Point point = new Point((int) (event.getSceneX()), (int) event.getSceneY());
            if (isDragged) {
                myShape.move(point);
                repaint();
                myShape.draw(gc);
            }
        }
    };
    private final EventHandler<MouseEvent> mouseHandler3 = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            Point point = new Point((int) (event.getSceneX()), (int) event.getSceneY());
            if (letsmove) {
                isDragged = false;
            }
        }
    };


}
