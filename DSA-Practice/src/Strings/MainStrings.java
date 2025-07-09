package Strings;

import java.util.Arrays;

public class MainStrings {
    //3
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int maxLength = 0;
        int[] temp = new int[128];
        Arrays.fill(temp, -1);
        for (int r = 0; r < n; r++) {
            if (temp[s.charAt(r)] >= l) {
                l = temp[s.charAt(r)] + 1;
            }
            temp[s.charAt(r)] = r;
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;

    }

    //    5. Longest Palindromic Substring
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) return "";

        int startStringIndex = 0, maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // kiểm tra chuỗi lẻ
            int len2 = expandAroundCenter(s, i, i+1); // kiểm tra chuỗi chẵn

            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                startStringIndex = i - (len - 1) /2;
            }
        }
        return s.substring(startStringIndex, startStringIndex + maxLength);
    }
    // kiểm tra từ trung tâm chuỗi đối xứng
    private int expandAroundCenter(String s, int left, int right) {
        while(left <= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; right++;
        }
        return right - left - 1;
    }

    // 7. Reverse Integer
    public static int Reverse(int x) {
        int res = 0 ;
        boolean isNegative = 0 < x;
        String strX = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder(strX).reverse();

        try {
            res = Integer.parseInt(sb.toString());
        } catch (NumberFormatException ex) {
            return 0;
        }
        return isNegative ? -res : res;
    }

    //8. String to Integer (atoi)
    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        int index = 0;
        int n = s.length();

        // bo qua khoang trang
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // neu het chuoi
        if (index == n) return 0;

        //xac dinh dau
        int sign = 1;
        char tempChar = s.charAt(index);
        if (tempChar == '+' || tempChar == '-') {
            if (tempChar == '-') sign = -1;
            index++;
        }

        long res = 0; // chuoi co the rat dai
        while (index < n && s.charAt(index) == '0') {
            index++;
        }

        while (index < n) {
            tempChar = s.charAt(index);
            if (tempChar < '0' || tempChar > '9') break;

            int digit = tempChar - '0';
            res = res*10 + digit;

            long signedRes = res * sign;
            if (signedRes <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (signedRes >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            index++;
        }
        res *= sign;
        return (int) res;
    }
    public static void main(String[] args) {

    }
}
