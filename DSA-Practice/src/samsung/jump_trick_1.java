package samsung;

import java.util.Scanner;

public class jump_trick_1 {
    //Bài toán yêu cầu tìm đường đi theo quy tắc đơn giản: từ ô hiện tại,
    // bạn di chuyển đến ô xung quanh (tối đa 8 ô lân cận)
    // có giá trị nhỏ nhất nhưng lớn hơn giá trị hiện tại.
    // Nếu không tìm được ô nào thỏa mãn, dừng lại.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Nhập kích thước ma trận
        System.out.print("Nhập số hàng m: ");
        int m = scanner.nextInt();
        System.out.print("Nhập số cột n: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];

        // Nhập ma trận
        System.out.println("Nhập ma trận:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        // Nhập vị trí bắt đầu
        System.out.print("Nhập vị trí bắt đầu (x, y): ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int steps = countMinJumps(matrix, x, y);
        System.out.println("Số bước nhảy tối đa: " + steps);
    }

    public static int countMinJumps(int[][] matrix, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        int steps = 0;

        // array dieu huong
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        while(true) {
            int currentValue = matrix[x][y];
            int nextValue = Integer.MAX_VALUE;
            int nextX = -1, nextY = -1;

            for (int i = 0 ; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int neighborValue = matrix[newX][newY];
                    if (neighborValue > currentValue && neighborValue < nextValue) {
                        nextValue = neighborValue;
                        nextX = newX;nextY = newY;
                    }
                }
            }
            if (nextX == -1 || nextY == -1) break;
            x = nextX; y = nextY;
            steps++;
        }
        return steps;
    }
}
