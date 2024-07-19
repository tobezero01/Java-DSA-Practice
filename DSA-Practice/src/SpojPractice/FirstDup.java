//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class FirstDup {
    public FirstDup() {
    }

    public static int firstDuplicate(int[] arr) {
        int[] count = new int[arr.length + 1];
        int minIndex = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; ++i) {
            ++count[arr[i]];
            if (count[arr[i]] == 2 && i < minIndex) {
                minIndex = i;
            }
        }

        if (minIndex == Integer.MAX_VALUE) {
            return -1;
        } else {
            return arr[minIndex];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int i = 1; i <= T; ++i) {
            int N = scanner.nextInt();
            int[] arr = new int[N];

            int result;
            for(result = 0; result < N; ++result) {
                arr[result] = scanner.nextInt();
            }

            result = firstDuplicate(arr);
            System.out.println("#" + i + " " + result);
        }

        scanner.close();
    }
}
