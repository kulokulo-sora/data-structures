package SqlistTest;

import java.util.Scanner;

public class Test_26_8_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pos = sc.nextInt();
        int digit = sc.nextInt();

        SqListTest sqt = new SqListTest(n);
        sqt.insert(pos,digit);

    }

}
