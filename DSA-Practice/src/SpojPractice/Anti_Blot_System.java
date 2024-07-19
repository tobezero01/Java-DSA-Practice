package SpojPractice;

import java.util.Scanner;

public class Anti_Blot_System {
    public Anti_Blot_System() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for(int tc = 0; tc < T; ++tc) {
            scanner.nextLine();
            String[] parts = scanner.nextLine().split("\\s+");
            int[] nums = new int[5];

            int n1;
            for(n1 = 0; n1 < 5; ++n1) {
                nums[n1] = convertStringToInt(parts[n1]);
            }

            n1 = nums[0];
            int n2 = nums[2];
            if (n1 < 0) {
                nums[0] = nums[4] - nums[2];
            } else if (n2 < 0) {
                nums[2] = nums[4] - nums[0];
            } else {
                nums[4] = nums[0] + nums[2];
            }

            System.out.println(nums[0] + " + " + nums[2] + " = " + nums[4]);
        }

    }

    private static boolean isNumeric(String str) {
        if (str != null && !str.isEmpty()) {
            char[] var4;
            int var3 = (var4 = str.toCharArray()).length;

            for(int var2 = 0; var2 < var3; ++var2) {
                char c = var4[var2];
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private static int convertStringToInt(String str) {
        return isNumeric(str) ? Integer.parseInt(str) : -1;
    }
}
