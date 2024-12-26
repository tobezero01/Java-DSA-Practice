package Sorting.BaseSorting;

public class Insertion {

    // Ý tưởng: Chia mảng thành hai phần - đã sắp xếp và chưa sắp xếp.
    // Lấy từng phần tử trong mảng chưa sắp xếp và chèn vào đúng vị
    // trí trong phần đã sắp xếp.
    // Tốt nhất : O(n)
    // tệ nhất : O(n^2)
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Lưu giá trị phần tử hiện tại
            int j = i - 1;

            // Dịch chuyển các phần tử lớn hơn `key` về phía sau
            while ( j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // dich chuyen phan tu do vao day sap xep
                j--;
            }
            arr[j+1] = key;
        }
    }

    // Hàm main để kiểm tra thuật toán
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Mảng trước khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        insertionSort(arr);

        System.out.println("\nMảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
