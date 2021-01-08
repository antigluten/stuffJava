import java.util.Arrays;
import java.util.Locale;

public class Finder {


}

class Start{
    public static void main(String[] args) {
        Point point = new Point();
        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};

        Point[] points = new Point[10];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(i, -i);
            points[i].showCoordinates();
        }
        double[] distances = new double[10];
        for (int i = 0; i < points.length; i++) {
            distances[i] = Point.distanceOnePoint(points[i]);
            if (i != points.length -1) {

            }
        }
        for (int i = 0; i < distances.length; i++) {
            System.out.format(Locale.UK, "%.1f",distances[i]);
            System.out.print(" ");
        }
//        System.out.format(Locale.US,"%.1f", Arrays.toString(distances));
    }
}
