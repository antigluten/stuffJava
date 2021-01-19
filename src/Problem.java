import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sectionOne = scanner.nextInt();
        scanner.nextLine();

        String[] arrayOne = new String[sectionOne];
        for (int i = 0; i < sectionOne; i++) {
            arrayOne[i] = scanner.nextLine();
        }

        int sectionTwo = scanner.nextInt();
        scanner.nextLine();

        String[] arrayTwo = new String[sectionTwo];
        for (int i = 0; i < sectionTwo; i++) {
            arrayTwo[i] = scanner.nextLine();
        }

        double[] xSectionOne = parsingDoubleX(arrayOne, sectionOne);
        double[] ySectionOne = parsingDoubleY(arrayOne, sectionOne);

        double[] xSectionTwo = parsingDoubleX(arrayTwo, sectionTwo);
        double[] ySectionTwo = parsingDoubleY(arrayTwo, sectionTwo);

//        showDouble(xSectionOne, ySectionOne);
//        showDouble(xSectionTwo, ySectionTwo);

        //turning x1[] and y1[] into array of points
        Point[] arrayPointsSectionOne = new Point[sectionOne];
        for (int i = 0; i < sectionOne; i++) {
            arrayPointsSectionOne[i] = new Point(xSectionOne[i], ySectionOne[i]);
            arrayPointsSectionOne[i].showCoordinates();
        }

        System.out.println();

        //turning x2[] and y2[] into array of points
//        Point[] arrayPointsSectionTwo = new Point[sectionTwo];
//        for (int i = 0; i < sectionTwo; i++) {
//            arrayPointsSectionTwo[i] = new Point(xSectionTwo[i], ySectionTwo[i]);
//            arrayPointsSectionTwo[i].showCoordinates();
//        }

        // find the nearest point
        System.out.println("The Nearest one is: ");
        Point theNearestOne = Point.findTheClosestPointToCenter(arrayPointsSectionOne);
        theNearestOne.showCoordinates();
        System.out.println();
        theNearestOne.showIteration();

        double[] top10distances = Point.findThe10NearestToThePoint(arrayPointsSectionOne,theNearestOne);
        System.out.println(Arrays.toString(top10distances));

        System.out.println("Testing");
        Point result = Point.compareToSection2(arrayPointsSectionOne, top10distances);
        result.showCoordinates();

        double theAngle = Point.findAngle(result.getX(),result.getY(),theNearestOne.getX(),theNearestOne.getY());
        System.out.println(theAngle);
        Point rotatedResult = Point.movePointByAngle(result.getX(), result.getY(), theAngle);
        rotatedResult.showCoordinates();
    }


    // parsing x
    public static double[] parsingDoubleX(String[] line, int n) {
        double[] coordinates = new double[n];
        for (int i = 0; i < coordinates.length; i++) {
            int index = line[i].indexOf(" ") + 1;
            String strPartOne = line[i].substring(0, index);
            coordinates[i] = Double.parseDouble(strPartOne);
        }
        return coordinates;
    }

    // parsing y
    public static double[] parsingDoubleY(String[] line, int n) {
        double[] coordinates = new double[n];
        for (int i = 0; i < coordinates.length; i++) {
            int index = line[i].indexOf(" ") + 1;
            String strPartTwo = line[i].substring(index);
            coordinates[i] = Double.parseDouble(strPartTwo);
        }
        return coordinates;
    }

    // output on console
    public static void showCoordinatesOfXAndY(double[] xOne, double[] yOne) {
        for (int i = 0; i < xOne.length; i++) {
            System.out.println(xOne[i] + " " + yOne[i]);
        }
    }
}

class Point {
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

    static Point compareToSection2(Point[] arrayPoints, double[] top10distances) {
        Point point = new Point();
        int iteration = 0;
        for (int i = 0; i < arrayPoints.length; i++) {
            double x = arrayPoints[i].getX();
            double y = arrayPoints[i].getY();
            Point thisPoint = new Point(x, y);
            double[] theNearestDistancesToIt = Point.findThe10NearestToThePoint(arrayPoints, thisPoint);

            int counter = 0, max = 0;
            for (int j = 0; j < theNearestDistancesToIt.length; j++) {
                if (top10distances[j] == theNearestDistancesToIt[j]) counter++;
            }
            if (counter > max) {
                max = counter;
                iteration = i;
            }
        }
        point = arrayPoints[iteration];
        return point;
    }
    static double findAngle (double xOne, double yOne, double xTwo, double yTwo){
        double theta = Math.atan2(yOne, xOne) + Math.atan2(yTwo, xTwo);
        theta += Math.PI/2.0;
        double angle = Math.toDegrees(theta);
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    // сдвиг по углу
    static Point movePointByAngle(double xOne, double yOne, double angle) {
        double xAfter = xOne * Math.cos(angle) + yOne * Math.sin(angle);
        double yAfter = yOne * Math.cos(angle) - xOne * Math.sin(angle);
        return new Point(xAfter, yAfter);
    }
}