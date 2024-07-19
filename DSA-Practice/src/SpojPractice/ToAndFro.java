//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class ToAndFro {
    public ToAndFro() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int NUM_COL = scanner.nextInt();
            if (NUM_COL == 0) {
                return;
            }

            String str = scanner.next();
            int length = str.length();
            char[][] Mat = new char[101][21];
            int col = 0;
            int row = 0;
            int delta = 1;

            for(int i = 0; i < length; ++i) {
                Mat[row][col] = str.charAt(i);
                col += delta;
                if (col >= NUM_COL) {
                    Mat[row][col] = 0;
                    ++row;
                    Mat[row][col] = 0;
                    delta = -1;
                    col += delta;
                } else if (col < 0) {
                    ++row;
                    delta = 1;
                    col += delta;
                }
            }

            StringBuilder result = new StringBuilder();

            for(int j = 0; j < NUM_COL; ++j) {
                for(int i = 0; i < row; ++i) {
                    result.append(Mat[i][j]);
                }
            }

            System.out.println(result);
        }
    }
}
