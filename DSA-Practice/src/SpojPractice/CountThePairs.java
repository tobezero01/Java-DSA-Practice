//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class CountThePairs {
    public CountThePairs() {
    }

    public static int abs(int n) {
        return n >= 0 ? n : -n;
    }

    public static int countPairsWithDifferenceK(int[] nums, int N, int K) {
        int count = 0;

        for(int i = 0; i < N; ++i) {
            for(int j = i + 1; j < N; ++j) {
                if (abs(nums[i] - nums[j]) == K) {
                    ++count;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int t = 1; t <= T; ++t) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] nums = new int[N];

            int result;
            for(result = 0; result < N; ++result) {
                nums[result] = scanner.nextInt();
            }

            result = countPairsWithDifferenceK(nums, N, K);
            System.out.println(result);
        }

        scanner.close();
    }
}
