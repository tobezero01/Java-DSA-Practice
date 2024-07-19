//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class chuoiDoiXung {
    public chuoiDoiXung() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for(int t = 1; t <= T; ++t) {
            String str = scanner.nextLine();
            int max = Integer.MIN_VALUE;

            for(int start = 0; start < str.length(); ++start) {
                for(int end = start + 1; end <= str.length(); ++end) {
                    String substring = str.substring(start, end);
                    if (isPalindrome(substring) && end - start >= max) {
                        max = end - start;
                    }
                }
            }

            System.out.println("#" + t + " " + max);
        }

    }

    private static boolean isPalindrome(String str) {
        int left = 0;

        for(int right = str.length() - 1; left < right; --right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            ++left;
        }

        return true;
    }
}
