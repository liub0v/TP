package shape;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.Point;
import java.util.ArrayList;

public class BrokenLine extends LineSegment {

	private ArrayList<LineSegment> segments = new ArrayList<>();

	public BrokenLine() {
	}

	public BrokenLine(Point theCenter, Point theSecondPoint, javafx.scene.paint.Color borderColor, ArrayList<LineSegment> segments) {
		super(theCenter, theSecondPoint, borderColor);
		setSegments(segments);
	}


	@Override
	public void draw(GraphicsContext gc ) {
		for (int i = 0; i < segments.size(); i++) {
			segments.get(i).draw(gc);
		}


	}

	@Override
	public boolean contains(Point pt) {
		for (int i = 0; i < segments.size(); i++) {
			if (segments.get(i).contains(pt)) {
				return true;
			}
		}
		return false;
	}



	@Override
	public void move(Point pt) {
		LineSegment middleSegment = segments.get(segments.size() / 2);
		middleSegment.move(pt);
		for (int i = segments.size() / 2 + 1; i < segments.size(); i++) {
			segments.get(i).move(segments.get(i - 1).getTheSecondPoint());
		}
		for (int i = segments.size() / 2 - 1; i >= 0; i--) {
			Point newEndPt = segments.get(i + 1).getCenter();
			Point centPt = segments.get(i).getCenter();
			Point endPt = segments.get(i).getTheSecondPoint();
			int deltaX = newEndPt.x - endPt.x;
			int deltaY = newEndPt.y - endPt.y;
			Point movePoint = new Point(centPt.x + deltaX, centPt.y + deltaY);
			segments.get(i).move(movePoint);
		}
	}



	public void addPoint(Point pt1, Point pt2, Color c) {
		segments = getSegments();
		segments.add(new LineSegment(pt1, pt2, c));
	}

	public ArrayList<LineSegment> getSegments() {
		if (segments==null) segments = new ArrayList<>();
		return segments;
	}

	public void setSegments(ArrayList<LineSegment> s) {

		for (LineSegment p : s) {
			segments.add(p);

		}
	}


}
