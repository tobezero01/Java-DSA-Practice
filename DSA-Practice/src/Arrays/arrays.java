//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Arrays;

import java.util.Scanner;

public class arrays {
    public arrays() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        int m;
        for(m = 0; m < n; ++m) {
            array[m] = scanner.nextInt();
        }

        m = scanner.nextInt();
        scanner.nextLine();

        int num;
        int index;
        for(num = 0; num < m; ++num) {
            String operation = scanner.nextLine();
            if (operation.startsWith("insert")) {
                String[] tokens = operation.split(" ");
                index = Integer.parseInt(tokens[1]);
                int value = Integer.parseInt(tokens[2]);
                array = insert(array, index, value);
            } else if (operation.startsWith("delete")) {
                index = Integer.parseInt(operation.split(" ")[1]);
                array = delete(array, index);
            }
        }

        int[] var12 = array;
        index = array.length;

        for(int var10 = 0; var10 < index; ++var10) {
            num = var12[var10];
            System.out.print("" + num + " ");
        }

        System.out.println();
        scanner.close();
    }

    private static int[] insert(int[] array, int index, int value) {
        if (index >= 0 && index <= array.length) {
            int[] newArray = new int[array.length + 1];

            int i;
            for(i = 0; i < index; ++i) {
                newArray[i] = array[i];
            }

            newArray[index] = value;

            for(i = index; i < array.length; ++i) {
                newArray[i + 1] = array[i];
            }

            return newArray;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + array.length);
        }
    }

    private static int[] delete(int[] array, int index) {
        if (index >= 0 && index < array.length) {
            int[] newArray = new int[array.length - 1];
            int i = 0;

            for(int j = 0; i < array.length; ++i) {
                if (i != index) {
                    newArray[j++] = array[i];
                }
            }

            return newArray;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + array.length);
        }
    }
}

