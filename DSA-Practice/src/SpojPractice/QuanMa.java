//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class QuanMa {
    static final int Q = 0;
    static final int K = 1;
    static final int P = 2;
    static final int Safe = 3;
    static final int Unsafe = 4;
    static int[][] board;
    static int ROW;
    static int COL;
    static int[] K_row = new int[]{-1, -2, 1, 2, -2, -1, 2, 1};
    static int[] K_col = new int[]{2, 1, 2, 1, -1, -2, -1, -2};
    static int[] Q_row = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
    static int[] Q_col = new int[]{1, -1, -1, 0, 1, -1, 0, 1};
    static int Sum;

    public QuanMa() {
    }

    static int checkK(int row, int col) {
        int count = 0;

        for(int i = 0; i < 8; ++i) {
            int r = row + K_row[i];
            int c = col + K_col[i];
            if (r <= ROW && r >= 0 && c <= COL && c >= 0 && board[r][c] == 3) {
                board[r][c] = 4;
                ++count;
            }
        }

        return count;
    }

    static void checkQ(int row, int col, int direct) {
        int r = row + Q_row[direct];
        int c = col + Q_col[direct];
        if (r <= ROW && r >= 0 && c <= COL && c >= 0) {
            if (board[r][c] == 3) {
                board[r][c] = 4;
                --Sum;
                checkQ(r, c, direct);
            } else if (board[r][c] == 4) {
                checkQ(r, c, direct);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 0;

        while(true) {
            ROW = sc.nextInt();
            COL = sc.nextInt();
            if (ROW == 0 && COL == 0) {
                sc.close();
                return;
            }

            ++tc;
            Sum = ROW * COL;
            --ROW;
            --COL;
            board = new int[ROW + 1][COL + 1];

            for(int r = 0; r <= ROW; ++r) {
                for(int c = 0; c <= COL; ++c) {
                    board[r][c] = 3;
                }
            }

            int[][] row = new int[2][100];
            int[][] col = new int[2][100];
            int[] num = new int[3];

            int j;
            int i;
            for(j = 0; j < 3; ++j) {
                num[j] = sc.nextInt();

                for(i = 0; i < num[j]; ++i) {
                    int r = sc.nextInt() - 1;
                    int c = sc.nextInt() - 1;
                    board[r][c] = j;
                    if (j != 2) {
                        row[j][i] = r;
                        col[j][i] = c;
                    }
                }
            }

            Sum -= num[0] + num[1] + num[2];

            for(j = 0; j < num[1]; ++j) {
                Sum -= checkK(row[1][j], col[1][j]);
            }

            for(j = 0; j < num[0]; ++j) {
                for(i = 0; i < 8; ++i) {
                    checkQ(row[0][j], col[0][j], i);
                }
            }

            System.out.println("Board " + tc + " has " + Sum + " safe squares.");
        }
    }
}
