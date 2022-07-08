package ex01;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()){
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        int num = sc.nextInt();
        if (num <= 1) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        int i;
        for(i = 2; i < num / i; i++) {
            if ((num % i) == 0) {
                System.out.println(false + " " + (i - 1));
                return;
            }
        }
        System.out.println(true + " " + (i - 1));
    }
}
