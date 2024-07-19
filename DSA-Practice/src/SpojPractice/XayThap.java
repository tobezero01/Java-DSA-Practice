//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Arrays;
import java.util.Scanner;

public class XayThap {
    public XayThap() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int testCase = 1; testCase <= T; ++testCase) {
            int N = scanner.nextInt();
            int M1 = scanner.nextInt();
            int M2 = scanner.nextInt();
            int[] weights = new int[N];

            int costM1;
            for(costM1 = 0; costM1 < N; ++costM1) {
                weights[costM1] = scanner.nextInt();
            }

            Arrays.sort(weights);
            costM1 = 0;
            int costM2 = 0;
            int index = N - 1;
            int i;
            if (M1 >= M2) {
                for(i = 1; i <= M2; ++i) {
                    costM1 += i * weights[index--];
                    costM2 += i * weights[index--];
                }

                for(i = M2 + 1; i <= M1; ++i) {
                    costM1 += i * weights[index--];
                }
            } else {
                for(i = 1; i <= M1; ++i) {
                    costM1 += i * weights[index--];
                    costM2 += i * weights[index--];
                }

                for(i = M1 + 1; i <= M2; ++i) {
                    costM2 += i * weights[index--];
                }
            }

            i = costM1 + costM2;
            System.out.println("#" + testCase + " " + i);
        }

        scanner.close();
    }
}
