//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class demTu {
    public demTu() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; ++tc) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String[] words = new String[m];

            for(int i = 0; i < m; ++i) {
                words[i] = scanner.next();
            }

            char[][] matrix = new char[n][n];

            int j;
            for(int i = 0; i < n; ++i) {
                String line = scanner.next();

                for(j = 0; j < n; ++j) {
                    matrix[i][j] = line.charAt(j);
                }
            }

            int[] wordCount = new int[m];

            int k;
            int i;
            for(i = 0; i < n; ++i) {
                for(j = 0; j < n; ++j) {
                    for(k = 0; k < m; ++k) {
                        if (checkWord(matrix, i, j, words[k])) {
                            int var10002 = wordCount[k]++;
                        }
                    }
                }
            }

            System.out.print("#" + tc);
            int[] var12 = wordCount;
            k = wordCount.length;

            for(j = 0; j < k; ++j) {
                i = var12[j];
                System.out.print(" " + i);
            }

            System.out.println();
        }

        scanner.close();
    }

    static boolean checkWord(char[][] matrix, int x, int y, String word) {
        int n = matrix.length;
        int len = word.length();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int[][] var10 = directions;
        int var9 = directions.length;

        for(int var8 = 0; var8 < var9; ++var8) {
            int[] direction = var10[var8];
            int dx = direction[0];
            int dy = direction[1];
            int nx = x;
            int ny = y;
            boolean match = true;

            for(int k = 0; k < len; ++k) {
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || matrix[nx][ny] != word.charAt(k)) {
                    match = false;
                    break;
                }

                nx += dx;
                ny += dy;
            }

            if (match) {
                return true;
            }
        }

        return false;
    }
}
