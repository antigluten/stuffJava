import java.util.Locale;

public class Point {
    private double x;
    private double y;
    public int iteration;

    Point(){
        this.x = 0;
        this.y = 0;
    }
    Point(double x,double y){
        this.x = x;
        this.y = y;
    }
    Point(double x,double y,int iteration){
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
    double getX(){
        return x;
    }
    double getY(){
        return y;
    }
    void showCoordinates(){
        System.out.println("X " + x + " Y " + y);
    }

    static double distance(Point one, Point two){
        return Math.sqrt(Math.pow(one.x - two.x, 2) + Math.pow(one.y - two.y,2));
    }
    static double distanceOnePoint(Point one){
        return Math.sqrt(Math.pow(one.x, 2) + Math.pow(one.y,2));
    }

    void showDistance(double distance){
        System.out.println(distance);
    }
    static Point findTheClosestPointToCenter(Point[] arrayPoints){
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
    void showIteration(){
        System.out.println(iteration);
    }
    double[] finder(Point[] arrayPoints) {
        double[] topNearestDistances = new double[10];

        return topNearestDistances;
    }

}
class test{
    public static void main(String[] args) {
        double max = 100;
        Point one = new Point(-12.5, +34.4);
        Point two = new Point(30.2, -5.7);
        double distance = Point.distance(one, two);
        System.out.format(Locale.US,"%.1f", distance);

    }
}
