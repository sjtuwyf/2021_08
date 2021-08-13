package ttest.tst;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author ssqswyf
 * @Date 2021/7/31
 */
public class ScannerTest {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
//        System.out.println(number);
//        String str = scanner.next();
//        System.out.println(str);
        Random rnd = new Random();
        System.out.println(rnd.nextInt());
        System.out.println(rnd.nextInt(3));
    }
}
