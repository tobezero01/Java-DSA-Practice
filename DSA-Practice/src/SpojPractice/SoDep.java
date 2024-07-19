//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class SoDep {
    public SoDep() {
    }

    public static int countSpecialValues(int number, int[] specialValues) {
        int count;
        for(count = 0; number > 0; number /= 10) {
            int digit = number % 10;
            int[] var7 = specialValues;
            int var6 = specialValues.length;

            for(int var5 = 0; var5 < var6; ++var5) {
                int specialValue = var7[var5];
                if (digit == specialValue) {
                    ++count;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int i = 1; i <= T; ++i) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] beautifulNumbers = new int[n];

            int x;
            for(x = 0; x < n; ++x) {
                beautifulNumbers[x] = scanner.nextInt();
            }

            x = scanner.nextInt();
            int y = scanner.nextInt();
            int count = 0;

            for(int k = x; k <= y; ++k) {
                if (countSpecialValues(k, beautifulNumbers) >= m) {
                    ++count;
                }
            }

            System.out.println("#" + i + " " + count);
        }

        scanner.close();
    }
}
