import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        double[] x1 = new double[n];
        double[] y1 = new double[n];
        double minDistance = 100;

        for (int i = 0; i < n; i++) {
            x1[i] = in.nextDouble();
            y1[i] = in.nextDouble();
        }
        int iteration = 0;
        for (int i = 0; i < n - 1; i++) {
            double dist = 100;

            if (i != n - 2){
                dist = distance(x1[i], y1[i], x1[i + 1], y1[i + 1]);
            }
            if (dist < minDistance){
                minDistance = dist;
                iteration = i;
        }
    }
        System.out.println(iteration);
}
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}

