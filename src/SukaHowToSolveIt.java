import java.util.Scanner;

public class SukaHowToSolveIt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sectionOne = scanner.nextInt();

        scanner.nextLine();

        String [] arrayOne = new String[sectionOne];
        for (int i = 0; i < sectionOne; i++) {
            arrayOne[i] = scanner.nextLine();
        }

        int sectionTwo = scanner.nextInt();

        scanner.nextLine();

        String [] arrayTwo = new String[sectionTwo];
        for (int i = 0; i < sectionTwo; i++) {
            arrayTwo[i] = scanner.nextLine();
        }

        double[] xSectionOne = parsingDoublePart1(arrayOne, sectionOne);
        double[] ySectionOne = parsingDoublePart2(arrayOne, sectionOne);
        showDouble(xSectionOne,ySectionOne);

        double[] xSectionTwo = parsingDoublePart1(arrayTwo, sectionTwo);
        double[] ySectionTwo = parsingDoublePart2(arrayTwo, sectionTwo);
        showDouble(xSectionTwo,ySectionTwo);

    }

    public static double[] parsingDoublePart1(String[] s, int n) {
        double[] coordinates = new double[n];
        for (int i = 0; i < coordinates.length; i++){
            int index = s[i].indexOf(" ") +1;
            String strPartOne = s[i].substring(0, index);
            coordinates[i] = Double.parseDouble(strPartOne);
        }

        return coordinates;
    }

    public static double[] parsingDoublePart2(String[] s, int n) {
        double[] coordinates = new double[n];
        for (int i = 0; i < coordinates.length; i++){
            int index = s[i].indexOf(" ") + 1;
            String strPartTwo = s[i].substring(index);
            coordinates[i] = Double.parseDouble(strPartTwo);
        }
        return coordinates;
    }
    public static void showDouble(double[] xOne, double[] yOne){
        for (int i = 0; i < xOne.length; i++) {
            System.out.println(xOne[i] + " " + yOne[i]);
        }
    }
}
