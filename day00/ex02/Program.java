package ex02;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class Program {

    private static int sumOfNum(int n) {
        if (n == 0)
            return 0;
         return sumOfNum(n / 10) + (n % 10);
    }

    private static boolean isPrime(int n) {
        int i;
        for(i = 2; i < n / i; i++) {
            if ((n % i) == 0)
                return false;
        }
        return  true;
    }

    public static void main(String[] args) {
        int count_request = 0;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num != 42) {
            if (isPrime(sumOfNum(num)))
                count_request++;
            num = sc.nextInt();
        }
        System.out.println("Count of coffee-request - " + count_request);
    }
}
