import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

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
        double min = 100, distance;
        int iteration = 0;
        for (int i = 0; i < arrayPoints.length; i++) {
            distance = distanceOnePoint(arrayPoints[i]);
            if (distance < min) {
                min = distance;
                iteration = i;
            }
        }
        return new Point(arrayPoints[iteration].x, arrayPoints[iteration].y, iteration);
    }

    static int[] findThe10NearestToThePoint(Point[] arrayPoints, Point theNearestToCenter) {
        List<Double> DistancesList = new ArrayList<>();

        for (int i = 0; i < arrayPoints.length; i++) {
            DistancesList.add(Point.distance(theNearestToCenter, arrayPoints[i]));
        }
        DistancesList.remove(0.0);
        double[] findDistance;
        double[] distances = new double[arrayPoints.length - 1];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = DistancesList.get(i);
        }
        findDistance = distances;
        Arrays.sort(distances);

        int[] iterations = new int[10];
        for (int i = 0; i < iterations.length; i++) {
            for (int j = 0; j < arrayPoints.length - 1; j++) {
                double distance = Point.distance(theNearestToCenter, arrayPoints[j]);
                if (findDistance[i] == distance){
                    iterations[i] = j;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.format(Locale.UK, "%.1f", distances[i]);
            System.out.println();
        }
        return iterations;
    }
    static void showPoints(int[] iterations, Point[] arrayPoints) {
        for (int i = 0; i < iterations.length; i++) {
            arrayPoints[iterations[i]].showCoordinates();
        }
    }
    // найти итерации, чтобы определить точки этих дистанций и составить шаблон

    void showIteration() {
        System.out.println(iteration);
    }
    static Point[] pattern(Point[] arrayPoints, int[] indexes, Point theNearestOne){
        Point[] pattern = new Point[11];
        for (int i = 0; i < pattern.length; i++) {
            if (i == 0){
                pattern[i] = theNearestOne;
            } else {
                pattern[i] = arrayPoints[indexes[i - 1]];
            }
        }
        return pattern;
    }

}
