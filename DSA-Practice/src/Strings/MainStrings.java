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
    public static void main(String[] args) {

    }
}
