//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class RobotThamHiem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; ++t) {
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[][] ar = new int[N][N];

            for(int i = 0; i < N; ++i) {
                for(int j = 0; j < N; ++j) {
                    ar[i][j] = sc.nextInt();
                }
            }

            int[] dx = new int[]{0, -1, 0, 1};
            int[] dy = new int[]{-1, 0, 1, 0};
            boolean breakP = true;

            int ans;
            int tempY;
            for(ans = ar[x][y]; breakP; y = tempY) {
                boolean flag = false;
                int max = ar[x][y];
                int tempX = x;
                tempY = y;

                for(int h = 0; h < 4; ++h) {
                    int newX = x + dx[h];
                    int newY = y + dy[h];
                    if (newX >= 0 && newX < N && newY >= 0 && newY < N && ar[newX][newY] > max) {
                        flag = true;
                        tempX = newX;
                        tempY = newY;
                        max = ar[newX][newY];
                    }
                }

                if (flag) {
                    ans += max;
                } else {
                    breakP = false;
                }

                x = tempX;
            }

            System.out.println("#" + (t + 1) + " " + ans);
        }

    }
}

