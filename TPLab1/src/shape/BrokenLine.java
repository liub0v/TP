package shape;


import javafx.scene.canvas.GraphicsContext;
import java.awt.Point;
import java.util.ArrayList;

public class BrokenLine extends LineSegment {

	private ArrayList<Point> segments;

	public BrokenLine() {
	}

	public BrokenLine(Point theCenter, Point theSecondPoint, javafx.scene.paint.Color borderColor) {
		super(theCenter, theSecondPoint, borderColor);
		segments = new ArrayList<>();
	}


	@Override
	public void draw(GraphicsContext gc ) {
//		if(segments.size()==0) {
//			gc.moveTo(getCenter().x, getCenter().y);
//			gc.lineTo(getTheSecondPoint().x, getTheSecondPoint().y);
//			gc.stroke();
//			addPoint(getTheSecondPoint());
//		}
//		else {
//			for (int i = 0; i < segments.size(); i++) {
//				Point segment = segments.get(i);
//				gc.setStroke(getBorderColor());
//				gc.moveTo(segments.get(i - 1).x, segments.get(i - 1).y);
//				gc.lineTo(segment.x,segment.y);
//				gc.stroke();
//			}
//		}
		LineSegment lineSegment = new LineSegment(getCenter(),getTheSecondPoint(),getBorderColor());
		lineSegment.draw(gc);
	}




	public void addPoint(Point pt) {
		//Point endPoint = segments.isEmpty() ? getCenter() : segments.get(segments.size() - 1).getTheSecondPoint();
		segments.add(pt);
	}



}
