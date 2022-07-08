package ex03;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weekNumber = 1;
        long minScores = 0;
        String week = sc.nextLine();
        while (!week.equals("42") && weekNumber <= 18) {
            if (!week.equals("Week " + weekNumber)) {
                System.err.println("Illegal Argument");
                System.exit(-1);
            }
            int tmp = getMin(sc);
            minScores = minScores * 10 + tmp;
            week = sc.nextLine();
            weekNumber++;
        }
        printResult(rotateScores(minScores));
    }

    private static int getMin(Scanner s) {
        int tmp = s.nextInt();
        int min = tmp;
        for (int i = 0; i < 4; i++) {
            tmp = s.nextInt();
            if (min > tmp)
                min = tmp;
        }
        s.nextLine();
        return  min;
    }

    private static long rotateScores(long n) {
        long tmp = 0;
        for (;n > 0; n /= 10) {
            tmp = tmp * 10 + n % 10;
        }
        return tmp;
    }

    private static void printResult(long s) {
        for (;s > 0; s /= 10) {
            int i = 1;
            System.out.print("Week ");
            System.out.print(i);
            System.out.print(" ");
            i++;
            for (int j = 0; j < (s % 10); j++) {
                System.out.print("=");
            }
            System.out.println(">");
        }
    }
}
