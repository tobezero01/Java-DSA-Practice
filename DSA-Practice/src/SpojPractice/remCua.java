//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class remCua {
    public remCua() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int testCase = 1; testCase <= T; ++testCase) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            scanner.nextLine();
            char[][] building = new char[5 * M + 1][5 * N + 1];

            for(int i = 0; i < 5 * M + 1; ++i) {
                building[i] = scanner.nextLine().toCharArray();
            }

            int[] windowCounts = new int[5];

            int count;
            int j;
            int x;
            for(count = 0; count < M; ++count) {
                for(j = 0; j < N; ++j) {
                    x = 1 + count * 5;
                    int y = 1 + j * 5;
                    int countStars = 0;

                    for(int k = 0; k < 4; ++k) {
                        for(int l = 0; l < 4; ++l) {
                            if (building[x + k][y + l] == '*') {
                                ++countStars;
                            }
                        }
                    }

                    int var10002;
                    if (countStars == 0) {
                        var10002 = windowCounts[0]++;
                    } else if (countStars == 4) {
                        var10002 = windowCounts[1]++;
                    } else if (countStars == 8) {
                        var10002 = windowCounts[2]++;
                    } else if (countStars == 12) {
                        var10002 = windowCounts[3]++;
                    } else if (countStars == 16) {
                        var10002 = windowCounts[4]++;
                    }
                }
            }

            System.out.print("#" + testCase);
            int[] var16 = windowCounts;
            x = windowCounts.length;

            for(j = 0; j < x; ++j) {
                count = var16[j];
                System.out.print(" " + count);
            }

            System.out.println();
        }

        scanner.close();
    }
}
