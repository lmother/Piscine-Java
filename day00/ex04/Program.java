package ex04;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        printResult(getArrayCharsCount(str.toCharArray()));
    }

    private static int [] getArrayCharsCount(char [] arr) {
        int [] arrChar = new int[65535 + 1];
        for (char c : arr) {
            if (arrChar[c] == 999)
                continue;
            arrChar[c] += 1;
        }
        return arrChar;
    }

    private static int [] getMaxChar(int [] arr) {
        int [] tmp = new int [2];
        int j = 0;
        for (int i : arr) {
            if (i > tmp[1] && j > tmp[0]) {
                tmp[1] = i;
                tmp[0] = j;
            }
            j++;
        }
        return  tmp;
    }

    private static void printResult(int [] arrCharCount) {
        int [] arrHashTags = new int [10];
        int [] arrLevelChars = new int[10];
        int [] arrChars = new int[10];
        int [] maxChar = getMaxChar(arrCharCount);

        for (int i = 0; i < 10; i++) {
            int [] res = getMaxChar(arrCharCount);
            arrLevelChars[i] = res[1];
            if (res[0] > 0) {
                arrHashTags[i] = (int)((double) res[1] / (double) maxChar[1] * 10);
                arrChars[i] = res[0];
                System.out.printf("%d - %c %d|", res[1], res[0], arrHashTags[i]);
            }
            arrCharCount[res[0]] = 0;
        }
        System.out.println();
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (arrLevelChars[j] == 0)
                    break;
                if ((arrHashTags[j]) - i == 0)
                    System.out.printf("%4d", arrLevelChars[j]);
                if (arrHashTags[j] - i > 0) {
                    System.out.print("   #");
                }
            }
            System.out.println();
        }
        for(int c : arrChars) {
            if (c != 0)
                System.out.print("   " + (char) c);
        }
    }
}
