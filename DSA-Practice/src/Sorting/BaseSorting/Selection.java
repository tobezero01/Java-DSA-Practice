package Sorting.BaseSorting;

public class Selection {

    // Ý tưởng: Tìm phần tử nhỏ nhất trong mảng chưa sắp xếp
    // và hoán đổi nó với phần tử ở vị trí đầu tiên của phần chưa sắp xếp.
    // O(n^2)
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Gia su phan tu dau tien la min

            // Tìm phần tử nhỏ nhất trong phần chưa sắp xếp
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;// Cập nhật chỉ số phần tử nhỏ nhất
                }
            }

            // Hoán đổi phần tử nhỏ nhất với phần tử đầu tiên của phần chưa sắp xếp
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Mảng trước khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectionSort(arr);

        System.out.println("\nMảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
