package Sorting.DiviceAndConquer;

public class Quick {
    /*
    minh hoa : https://www.youtube.com/shorts/-5cEMbsyMgs
    Ý tưởng thuật toán
        Chọn pivot:
            Chọn một phần tử làm chốt (trong cài đặt này, phần tử cuối cùng của mảng).
        Phân vùng:
            Đưa các phần tử nhỏ hơn hoặc bằng pivot về bên trái.
            Đưa các phần tử lớn hơn pivot về bên phải.
            Đặt pivot vào đúng vị trí giữa hai mảng con.
        Đệ quy:
            Sắp xếp hai mảng con bằng cách lặp lại quá trình trên.
    * */
    /*
        Tốt nhất: O(nlogn),
        Tệ nhất: O(n^2)
    * */

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Tìm chỉ số của phần tử phân vùng
            int partitionIndex = partition(arr, low, high);

            // Gọi đệ quy sắp xếp hai mảng con
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex, high);
        }
    }

    // Hàm phân vùng
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Chọn phần tử chốt là phần tử cuối cùng
        int i = low - 1; // Chỉ số của phần tử nhỏ hơn pivot

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Đặt pivot vào đúng vị trí giữa hai mảng con
        swap(arr, i + 1, high);
        return i + 1; // Trả về chỉ số của pivot
    }

    // Hàm đổi chỗ hai phần tử
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, -8, 9, -1, 5};

        System.out.println("Mảng trước khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nMảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
