package Sorting.Count;

public class Counting {
    /*
    * Ý tưởng thuật toán
        Counting Sort là thuật toán dựa trên số lần xuất hiện của các phần tử trong mảng.
        Các bước thực hiện:
        Tìm giá trị lớn nhất (max) và nhỏ nhất (min) để xác định kích thước mảng đếm.
        Duyệt qua mảng ban đầu, lưu số lần xuất hiện của mỗi phần tử vào mảng đếm (count).
        Dùng mảng đếm để xác định vị trí của các phần tử trong mảng đã sắp xếp.
        Thuật toán hoạt động tốt với các số nguyên trong một phạm vi giá trị nhỏ.*/
    // Hàm sắp xếp Counting Sort
    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        // Tìm giá trị lớn nhất và nhỏ nhất trong mảng
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // Tạo mảng đếm kích thước dựa trên khoảng giá trị
        int range = max - min + 1;
        int[] count = new int[range];

        // Đếm số lần xuất hiện của mỗi phần tử
        for (int num : arr) {
            count[num - min]++;
        }

        // Cập nhật lại mảng ban đầu theo mảng đếm
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
    }

    // Hàm main để kiểm tra thuật toán
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Mảng trước khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        countingSort(arr);

        System.out.println("\nMảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
