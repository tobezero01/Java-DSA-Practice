package Strings;

import java.util.Arrays;

public class StringOnLeetcodeMedium {
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
        return null;
    }

    public static void main(String[] args) {

    }
}
