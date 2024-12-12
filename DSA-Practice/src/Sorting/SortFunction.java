package Sorting;

import java.util.Arrays;

public class SortFunction {

    // O(n^2)
    public static void bubbleSort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //Lấy phần tử hiện tại và so sánh và chèn với các phần tử trước nó trong phần đã sắp xếp.
    // O(n^2)
    public static void insertSort(int[] arr) {

    }

    public static void main(String[] args) {

    }
}
