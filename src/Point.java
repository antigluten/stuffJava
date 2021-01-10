import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Point {
    private double x;
    private double y;
    public int iteration;

    Point() {
        this.x = 0;
        this.y = 0;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point(double x, double y, int iteration) {
        this.x = x;
        this.y = y;
        this.iteration = iteration;
    }

    void setCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    void showCoordinates() {
        System.out.println("X " + x + " Y " + y);
    }

    static double distance(Point one, Point two) {
        return Math.sqrt(Math.pow(one.x - two.x, 2) + Math.pow(one.y - two.y, 2));
    }

    static double distanceOnePoint(Point one) {
        return Math.sqrt(Math.pow(one.x, 2) + Math.pow(one.y, 2));
    }

    void showDistance(double distance) {
        System.out.println(distance);
    }

    static Point findTheClosestPointToCenter(Point[] arrayPoints) {
        double max = 100, distance = 0;
        int iteration = 0;
        for (int i = 0; i < arrayPoints.length; i++) {
            distance = distanceOnePoint(arrayPoints[i]);
            if (distance < max) {
                max = distance;
                iteration = i;
            }
        }
        return new Point(arrayPoints[iteration].x, arrayPoints[iteration].y, iteration);
    }

    static double[] findThe10NearestToThePoint(Point[] arrayPoints, Point theNearestToCenter) {
        List<Double> top10DistancesList = new ArrayList<>();

        for (int i = 0; i < arrayPoints.length; i++) {
            top10DistancesList.add(Point.distance(theNearestToCenter, arrayPoints[i]));
        }
        top10DistancesList.remove(0.0);

        double[] distances = new double[arrayPoints.length - 1];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = top10DistancesList.get(i);
        }
        Arrays.sort(distances);

        double[] top10Distances = new double[10];
        for (int i = 0; i < top10Distances.length; i++) {
            top10Distances[i] = distances[i];
        }
        return top10Distances;
    }
    // найти итерации, чтобы определить точки этих дистанций и составить шаблон

    void showIteration() {
        System.out.println(iteration);
    }

    double[] finder(Point[] arrayPoints) {
        double[] topNearestDistances = new double[10];

        return topNearestDistances;
    }

    // сдвиг по углу
    Point movePointByAngle(double xOne, double yOne, double angle) {
        double xAfter = xOne * Math.cos(angle) + yOne * Math.sin(angle);
        double yAfter = yOne * Math.cos(angle) - xOne * Math.sin(angle);
        return new Point(xAfter, yAfter);
    }

}
