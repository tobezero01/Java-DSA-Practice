package samsung;

import java.util.Scanner;

public class jump_trick_2 {
    static int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},         { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
    };
    static int m, n;
    static int maxSteps = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước ma trận
        System.out.print("Nhập số hàng m: ");
        m = scanner.nextInt();
        System.out.print("Nhập số cột n: ");
        n = scanner.nextInt();

        // Nhập ma trận
        int[][] matrix = new int[m][n];
        System.out.println("Nhập ma trận:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Nhập vị trí bắt đầu
        System.out.print("Nhập vị trí bắt đầu (x, y): ");
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();

        // Tính số bước nhảy tối đa
        maxSteps = findMaxSteps(matrix, startX, startY, -1); // -1: Giá trị khởi đầu nhỏ nhất
        System.out.println("Số bước nhảy tối đa: " + maxSteps);
    }

    static int findMaxSteps(int[][] matrix, int x, int y, int prevValue) {
        // Kiểm tra vị trí hiện tại có hợp lệ không
        if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= prevValue) {
            return 0;
        }

        int steps = 0;
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            steps = Math.max(steps, findMaxSteps(matrix, newX, newY, matrix[x][y]));
        }

        return 1 + steps; // Tính bước nhảy hiện tại
    }
}
