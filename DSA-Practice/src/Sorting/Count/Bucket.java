package Sorting.Count;

import java.util.ArrayList;
import java.util.Collections;

public class Bucket {
    // Hàm sắp xếp Bucket Sort
    public static void bucketSort(float[] arr) {
        if (arr.length == 0) return;

        // 1. Tạo n bucket
        int n = arr.length;
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2. Phân phối các phần tử vào bucket
        for (float num : arr) {
            int bucketIndex = (int) (num * n); // Xác định bucket dựa trên giá trị
            buckets[bucketIndex].add(num);
        }

        // 3. Sắp xếp các bucket bằng sắp xếp bất kỳ (ở đây dùng Collections.sort)
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 4. Gom các phần tử từ bucket về mảng gốc
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }

    // Hàm main để kiểm tra thuật toán
    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.23f, 0.52f, 0.25f, 0.47f, 0.51f};

        System.out.println("Mảng trước khi sắp xếp:");
        for (float num : arr) {
            System.out.print(num + " ");
        }

        bucketSort(arr);

        System.out.println("\nMảng sau khi sắp xếp:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}
