public class Angle {
    public static double calcRotationAngleInDegrees(double x1, double y1, double x2, double y2) {
        double theta = Math.atan2(y1, x1) + Math.atan2(y2,x2);
        theta += Math.PI/2.0;
        double angle = Math.toDegrees(theta);
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }
}
class AngleTest{
    public static void main(String[] args) {
        System.out.println(360 - Angle.calcRotationAngleInDegrees(-1,1,1,1));
    }
}