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
        double max = 100, distance;
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
        List<Double> DistancesList = new ArrayList<>();

        for (int i = 0; i < arrayPoints.length; i++) {
            DistancesList.add(Point.distance(theNearestToCenter, arrayPoints[i]));
        }
        DistancesList.remove(0.0);
        double[] findDistance = new double[arrayPoints.length - 1];
        double[] distances = new double[arrayPoints.length - 1];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = DistancesList.get(i);
        }
        findDistance = distances;
        Arrays.sort(distances);

        double[] top10Distances = new double[10];
        for (int i = 0; i < top10Distances.length; i++) {
            top10Distances[i] = distances[i];
        }
        double[] iterations = new double[10];
        for (int i = 0; i < top10Distances.length; i++) {
            for (int j = 0; j < arrayPoints.length; j++) {
                double distance = Point.distance(theNearestToCenter, arrayPoints[i]);
                if (top10Distances[i] == distance){
                    iterations[i] = j;
                }
            }
        }
        return iterations;
    }
    // найти итерации, чтобы определить точки этих дистанций и составить шаблон

    void showIteration() {
        System.out.println(iteration);
    }

    double[] finder(Point[] arrayPoints) {
        double[] topNearestDistances = new double[10];

        return topNearestDistances;
    }

}
