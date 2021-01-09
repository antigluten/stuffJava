public class Angle {
    static double findAngle (double xOne, double yOne, double xTwo, double yTwo) {
        return Math.acos((yOne*yTwo+xOne*xTwo)/Math.sqrt(Math.pow(yOne,2)+Math.pow(xOne,2))*Math.sqrt(Math.pow(yTwo,2)+Math.pow(xTwo,2)));
    }

}
class AngleTest {
    public static void main(String[] args) {
        System.out.println(Math.toDegrees(Angle.findAngle(1.0, 0.0, 0.0, 1.0)));
    }
}