package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Polygon extends TwoDimensionalShape {

	private Point[] arrayOfPoints;

	private int nPoints;
	private double[] xPoints;
	private double[] yPoints;

	protected static final int MIN_LENGTH = 4;

	public Polygon() {
	}

	public Polygon(Point theCenter, Color borderColor, Color fillColor) {
		super(theCenter, borderColor, fillColor);
	}

	public Polygon(Point theCenter, ArrayList<Point> points, Color borderColor, Color fillColor) {
		super(theCenter, borderColor, fillColor);
		setPoints(points);
	}


	public void setPoints(ArrayList<Point> points) {
		setnPoints(points.size());
		setxPoints(new double[getnPoints()]);
		setyPoints(new double[getnPoints()]);
		int i = 0;
		for (Point p : points) {
			getxPoints()[i] = p.x;
			getyPoints()[i++] = p.y;
		}
	}

//	public ArrayList<Point> getPoints() {
//		ArrayList<Point> points = new ArrayList<>(getnPoints());
//		for (int i = 0; i < getnPoints(); ++i)
//			points.add(new Point((int)getxPoints()[i], (int)getyPoints()[i]));
//		return points;
//	}

//	public int getPointsSize() {
//		return getnPoints();
//	}
//
//	public void addPoint(Point pt) {
//		if (getnPoints() >= getxPoints().length || getnPoints() >= getyPoints().length) {
//			int newLength = getnPoints() * 2;
//			if (newLength < MIN_LENGTH) {
//				newLength = MIN_LENGTH;
//			} else if ((newLength & (newLength - 1)) != 0) {
//				newLength = Integer.highestOneBit(newLength);
//			}
//			setxPoints(Arrays.copyOf(getxPoints(), newLength));
//			setyPoints(Arrays.copyOf(getyPoints(), newLength));
//		}
//		getxPoints()[getnPoints()] = pt.x;
//		getyPoints()[getnPoints()] = pt.y;
//		setnPoints(getnPoints() + 1);
//		setTheCenter(computeCenter());
//	}
//
//	public void setLastPoint(Point pt) {
//		getxPoints()[getnPoints() - 1] = pt.x;
//		getyPoints()[getnPoints() - 1] = pt.y;
//		setTheCenter(computeCenter());
//	}

	private Point computeCenter() {
		Point centroid = new Point(0, 0);
		double signedArea = 0.0;
		double x0; // Current vertex X
		double y0; // Current vertex Y
		double x1; // Next vertex X
		double y1; // Next vertex Y
		double a; // Partial signed area

		for (int i = 0; i < getnPoints() - 1; ++i) {
			x0 = getxPoints()[i];
			y0 = getyPoints()[i];
			x1 = getxPoints()[i + 1];
			y1 = getyPoints()[i + 1];
			a = x0 * y1 - x1 * y0;
			signedArea += a;
			centroid.x += (x0 + x1) * a;
			centroid.y += (y0 + y1) * a;
		}

		x0 = getxPoints()[getnPoints() - 1];
		y0 = getyPoints()[getnPoints() - 1];
		x1 = getxPoints()[0];
		y1 = getyPoints()[0];
		a = x0 * y1 - x1 * y0;
		signedArea += a;
		centroid.x += (x0 + x1) * a;
		centroid.y += (y0 + y1) * a;

		signedArea *= 0.5;
		centroid.x /= (6.0 * signedArea);
		centroid.y /= (6.0 * signedArea);

		return centroid;
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc);
		gc.strokePolygon(getxPoints(), getyPoints(), getnPoints());
		gc.fillPolygon(getxPoints(), getyPoints(), getnPoints());

	}


	@Override
	public void move(Point pt) {
		//Point theCenter = getCenter();
		Point theCenter = computeCenter();

		double deltaX = pt.x - theCenter.x;
		double deltaY = pt.y - theCenter.y;
		for (int i = 0; i < getnPoints(); i++) {
			getxPoints()[i] += deltaX;
			getyPoints()[i] += deltaY;
		}
		super.move(pt);
	}

	@Override
	public boolean contains(Point pt) {
		int hits = 0;

		double lastx = getxPoints()[getnPoints() - 1];
		double lasty = getyPoints()[getnPoints() - 1];
		double curx, cury;

		// Walk the edges of the polygon
		for (int i = 0; i < getnPoints(); lastx = curx, lasty = cury, i++) {
			curx = getxPoints()[i];
			cury = getyPoints()[i];

			if (cury == lasty) {
				continue;
			}

			double leftx;
			if (curx < lastx) {
				if (pt.x >= lastx) {
					continue;
				}
				leftx = curx;
			} else {
				if (pt.x >= curx) {
					continue;
				}
				leftx = lastx;
			}

			double test1, test2;
			if (cury < lasty) {
				if (pt.y < cury || pt.y >= lasty) {
					continue;
				}
				if (pt.x < leftx) {
					hits++;
					continue;
				}
				test1 = pt.x - curx;
				test2 = pt.y - cury;
			} else {
				if (pt.y < lasty || pt.y >= cury) {
					continue;
				}
				if (pt.x < leftx) {
					hits++;
					continue;
				}
				test1 = pt.x - lastx;
				test2 = pt.y - lasty;
			}

			if (test1 < (test2 / (lasty - cury) * (lastx - curx))) {
				hits++;
			}
		}
		return ((hits & 1) != 0);
	}


	public double[] getxPoints() {
		return xPoints;
	}

	public void setxPoints(double[] xPoints) {
		this.xPoints = xPoints;
	}

	public double[] getyPoints() {
		return yPoints;
	}

	public void setyPoints(double[] yPoints) {
		this.yPoints = yPoints;
	}

	public int getnPoints() {
		return nPoints;
	}

	public void setnPoints(int nPoints) {
		this.nPoints = nPoints;
	}
}