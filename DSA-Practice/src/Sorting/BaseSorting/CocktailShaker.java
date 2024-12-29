package Sorting.BaseSorting;

public class CocktailShaker {
    /*
    Ý tưởng thuật toán
        Cocktail Shaker Sort là một phiên bản cải tiến của Bubble Sort.
        Thay vì chỉ duyệt một chiều (trái sang phải), thuật toán sẽ duyệt hai chiều:
            Lượt đi (trái sang phải): Đưa phần tử lớn nhất còn lại về cuối mảng.
            Lượt về (phải sang trái): Đưa phần tử nhỏ nhất còn lại về đầu mảng.
        Tiếp tục giảm phạm vi kiểm tra (bỏ qua các phần tử đã sắp xếp) cho đến khi
        không có phần tử nào cần hoán đổi.
    * */
    // O(n) --> O(n^2)
    public static void cocktailShakerSort(int[] arr) {
        boolean swapped = true;
        int start = 0;
        int end = arr.length - 1;

        while (swapped) {
            swapped = false;

            // Duyệt từ trái sang phải
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }

            // Nếu không có phần tử nào hoán đổi, mảng đã sắp xếp
            if (!swapped) break;

            // Giảm giới hạn của mảng cần kiểm tra
            swapped = false;
            end--;

            // Duyệt từ phải sang trái
            for (int i = end - 1; i >= start; i--) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }

            // Tăng giới hạn của mảng cần kiểm tra
            start++;
        }
    }

    // Hàm đổi chỗ hai phần tử
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Hàm main để kiểm tra thuật toán
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8, 0, 2};

        System.out.println("Mảng trước khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        cocktailShakerSort(arr);

        System.out.println("\nMảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
