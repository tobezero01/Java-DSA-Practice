//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class vungBaoLonNhat {
    public vungBaoLonNhat() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int t = 1; t <= T; ++t) {
            int H = scanner.nextInt();
            int W = scanner.nextInt();
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int[][] matrix = new int[M][N];

            int maxEvenSum;
            int i;
            for(maxEvenSum = 0; maxEvenSum < M; ++maxEvenSum) {
                for(i = 0; i < N; ++i) {
                    matrix[maxEvenSum][i] = scanner.nextInt();
                }
            }

            maxEvenSum = Integer.MIN_VALUE;

            for(i = 0; i <= M - H; ++i) {
                for(int j = 0; j <= N - W; ++j) {
                    int currentEvenSum = 0;

                    for(int x = i; x < i + H; ++x) {
                        if (x != i && x != i + H - 1) {
                            if (matrix[x][j] % 2 == 0) {
                                currentEvenSum += matrix[x][j];
                            }

                            if (matrix[x][j + W - 1] % 2 == 0) {
                                currentEvenSum += matrix[x][j + W - 1];
                            }
                        } else {
                            for(int y = j; y < j + W; ++y) {
                                int value = matrix[x][y];
                                if (value % 2 == 0) {
                                    currentEvenSum += value;
                                }
                            }
                        }
                    }

                    if (currentEvenSum > maxEvenSum) {
                        maxEvenSum = currentEvenSum;
                    }
                }
            }

            System.out.println("#" + t + " " + maxEvenSum);
        }

        scanner.close();
    }
}
