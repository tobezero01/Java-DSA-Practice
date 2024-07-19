//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class HeThongVienThong {
    public HeThongVienThong() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int testCase = 1; testCase <= T; ++testCase) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            char[][] map = new char[M][N];

            int count;
            int i;
            for(count = 0; count < M; ++count) {
                String line = scanner.next();

                for(i = 0; i < N; ++i) {
                    map[count][i] = line.charAt(i);
                }
            }

            count = 0;
            boolean[][] check = new boolean[M][N];

            int j;
            for(i = 0; i < M; ++i) {
                for(j = 0; j < N; ++j) {
                    char chr = map[i][j];
                    if (chr == 'A' || chr == 'B' || chr == 'C') {
                        int y;
                        int y2;
                        int x;
                        int x2;
                        if (chr == 'A') {
                            check[i][j] = true;
                            y = j - 1 >= 0 ? j - 1 : 0;
                            y2 = j + 1 < N ? j + 1 : N - 1;
                            check[i][y] = true;
                            check[i][y2] = true;
                            x = i + 1 < M ? i + 1 : M - 1;
                            x2 = i - 1 >= 0 ? i - 1 : 0;
                            check[x][j] = true;
                            check[x2][j] = true;
                        } else {
                            int k;
                            if (chr == 'B') {
                                check[i][j] = true;
                                y = j - 2 >= 0 ? j - 2 : 0;
                                y2 = j + 2 < N ? j + 2 : N - 1;

                                for(x = y; x <= y2; ++x) {
                                    check[i][x] = true;
                                }

                                x = i - 2 >= 0 ? i - 2 : 0;
                                x2 = i + 2 < M ? i + 2 : M - 1;

                                for(k = x; k <= x2; ++k) {
                                    check[k][j] = true;
                                }
                            } else if (chr == 'C') {
                                check[i][j] = true;
                                y = j - 3 >= 0 ? j - 3 : 0;
                                y2 = j + 3 < N ? j + 3 : N - 1;

                                for(x = y; x <= y2; ++x) {
                                    check[i][x] = true;
                                }

                                x = i - 3 >= 0 ? i - 3 : 0;
                                x2 = i + 3 < M ? i + 3 : M - 1;

                                for(k = x; k <= x2; ++k) {
                                    check[k][j] = true;
                                }
                            }
                        }
                    }
                }
            }

            for(i = 0; i < M; ++i) {
                for(j = 0; j < N; ++j) {
                    if (!check[i][j] && map[i][j] == 'H') {
                        ++count;
                    }
                }
            }

            System.out.println("#" + testCase + " " + count);
        }

        scanner.close();
    }
}
