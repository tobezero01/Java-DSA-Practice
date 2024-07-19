//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class vuotChuongNgaiVat {
    public vuotChuongNgaiVat() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        for(int t = 1; t <= T; ++t) {
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[][] matrix = new int[N][N];

            int count;
            int minX;
            for(count = 0; count < N; ++count) {
                for(minX = 0; minX < N; ++minX) {
                    matrix[count][minX] = sc.nextInt();
                }
            }

            count = 0;

            while(true) {
                minX = -1;
                int minY = -1;
                int minVal = Integer.MAX_VALUE;

                for(int i = 0; i < 8; ++i) {
                    int nX = x + dx[i];
                    int nY = y + dy[i];
                    if (nX >= 0 && nX < N && nY >= 0 && nY < N && minVal > matrix[nX][nY] && matrix[nX][nY] > matrix[x][y]) {
                        minX = nX;
                        minY = nY;
                        minVal = matrix[nX][nY];
                    }
                }

                if (minX == -1) {
                    System.out.println("#" + t + " " + count);
                    break;
                }

                ++count;
                x = minX;
                y = minY;
            }
        }

    }
}
