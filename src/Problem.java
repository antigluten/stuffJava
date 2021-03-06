import java.util.Arrays;
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
//            arrayPointsSectionOne[i].showCoordinates();
        }

        System.out.println();

        //turning x2[] and y2[] into array of points
        Point[] arrayPointsSectionTwo = new Point[sectionTwo];
        for (int i = 0; i < sectionTwo; i++) {
            arrayPointsSectionTwo[i] = new Point(xSectionTwo[i], ySectionTwo[i]);
//            arrayPointsSectionTwo[i].showCoordinates();
        }

        // find the nearest point to the first selection
        System.out.println("The Nearest one is: ");
        Point theNearestOne = Point.findTheClosestPointToCenter(arrayPointsSectionOne);
        theNearestOne.showCoordinates();
        theNearestOne.showIteration();

        int[] top10DistancesIterations = Point.findThe10NearestToThePoint(arrayPointsSectionOne,theNearestOne);
//        System.out.println(Arrays.toString(top10DistancesIterations));

//        Point.showPoints(top10DistancesIterations, arrayPointsSectionOne);
        Point[] pattern = Point.pattern(arrayPointsSectionOne, top10DistancesIterations, theNearestOne);

        System.out.println("Pattern: ");
        for (int i = 0; i < pattern.length; i++) {
            pattern[i].showCoordinates();
        }

        // do the same to the next section
        System.out.println("section 2:");
        System.out.println("The Nearest one is: ");
        Point theNearestOneSection2 = Point.findTheClosestPointToCenter(arrayPointsSectionTwo);
        theNearestOneSection2.showCoordinates();
        theNearestOneSection2.showIteration();

        int[] top10DistancesIterationsSection2 = Point.findThe10NearestToThePoint(arrayPointsSectionTwo,theNearestOneSection2);
//        System.out.println(Arrays.toString(top10DistancesIterationsSection2));

//        Point.showPoints(top10DistancesIterationsSection2, arrayPointsSectionTwo);
        Point[] patternSection2 = Point.pattern(arrayPointsSectionTwo, top10DistancesIterationsSection2, theNearestOneSection2);
        System.out.println("Pattern 2: ");
        for (int i = 0; i < patternSection2.length; i++) {
            patternSection2[i].showCoordinates();
        }

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
