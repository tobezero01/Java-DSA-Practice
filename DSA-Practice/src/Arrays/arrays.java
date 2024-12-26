//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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


    //13. Roman to Integer
    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int currVal = romanMap.get(s.charAt(i));
            if (i < n - 1 && currVal < romanMap.get(s.charAt(i+1))) {
                res -= currVal;
            } else {
                res += currVal;
            }
        }
        return res;
    }

    public String intToRoman(int num) {
        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if(num == 0) break;
            while (num > values[i]) {
                stringBuilder.append(symbols[i]);
                num-=values[i];
            }
        }
        return stringBuilder.toString();
    }

    //58. Length of Last Word
    public int lengthOfLastWord(String s) {
        int n = s.length() - 1;
        while (n >= 0 && s.charAt(n) == ' ') n--;
        int m = n;
        while (m >= 0 && s.charAt(m) != ' ') m--;
        return n - m;
    }
//    public int lengthOfLastWord(String s) {
//        int res = 0;boolean counting = false;
//        for (char c : s.toCharArray()) {
//            if(c != ' ') {
//                if (!counting) {
//                    counting = true;res = 1;
//                } else {
//                    res++;
//                }
//            } else {
//                counting = false;
//            }
//        }
//        return res;
//    }

    //14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String s = "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[n-1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++)  {
            char c = first.charAt(i);
            if (c != last.charAt(i)) return s;
            s+= String.valueOf(c);
        }
        s = s.trim();

        return s;
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

