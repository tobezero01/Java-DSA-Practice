package Sorting.DiviceAndConquer;

public class Merge {
    /*
    Minh hoa : https://www.youtube.com/shorts/dZhFmu19N9U
    Ý tưởng thuật toán
    Chia:
        Chia mảng thành hai nửa, tiếp tục chia nhỏ cho đến khi mỗi nửa chỉ còn một
        phần tử (được xem là đã sắp xếp).
    Trộn:
        Trộn hai nửa đã sắp xếp lại thành một mảng lớn hơn theo thứ tự tăng dần.
        Lặp lại quá trình trộn cho đến khi toàn bộ mảng được sắp xếp.
    * */
    // O(nlogn)

    public static void mergeSort(int[] arr, int left, int right) {
        // dam bao con 2 phan tu de sap xep
        if (left < right) {
            int mid = left + (right - left)/2;

            // Gọi đệ quy để chia nhỏ mảng thành hai nửa
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Trộn hai nửa đã sắp xếp
            merge(arr, left, mid, right);
        }
    }

    // Hàm trộn hai mảng con đã sắp xếp
    private static void merge(int[] arr, int left, int mid, int right) {
        // Kích thước của hai mảng con
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Tạo hai mảng con tạm thời
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Sao chép dữ liệu vào hai mảng con
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Chỉ số bắt đầu của hai mảng con
        int i = 0, j = 0;
        // Chỉ số bắt đầu của mảng đã trộn
        int k = left;

        // Trộn các phần tử từ hai mảng con theo thứ tự tăng dần
        while ( i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j] ) {
                arr[k] = leftArray[i];i++;
            } else {
                arr[k] = rightArray[j];j++;
            }
            k++;
        }


        // Sao chép các phần tử còn lại của mảng con trái (nếu có)
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của mảng con phải (nếu có)
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] arr = {12, -11, 13, 5, 6, 7};

        System.out.println("Mảng trước khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nMảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
