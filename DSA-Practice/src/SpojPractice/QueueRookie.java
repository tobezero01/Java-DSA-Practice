//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SpojPractice;

import java.util.Scanner;

public class QueueRookie {
    public QueueRookie() {
    }

    public static int[] countingSort(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];

        int range;
        for(range = 1; range < n; ++range) {
            min = Math.min(min, nums[range]);
            max = Math.max(max, nums[range]);
        }

        range = max - min + 1;
        int[] count = new int[range];

        int index;
        for(index = 0; index < n; ++index) {
            ++count[nums[index] - min];
        }

        index = 0;

        for(int i = 0; i < range; ++i) {
            while(count[i] > 0) {
                nums[index++] = i + min;
                int var10002 = count[i]--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while(T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            int[] finalPos = new int[N];

            int max;
            for(max = 0; max < N; ++max) {
                arr[max] = scanner.nextInt();
            }

            max = Integer.MIN_VALUE;

            for(int i = 0; i < N; ++i) {
                if (arr[i] >= max) {
                    max = arr[i];
                }
            }

            int[] highIndex = new int[max + 1];

            int i;
            for(i = 0; i <= max; ++i) {
                highIndex[i] = 0;
            }

            for(i = 0; i < N; ++i) {
                highIndex[arr[i]] = scanner.nextInt();
            }

            arr = countingSort(arr);

            for(i = 0; i < N; ++i) {
                int cnt = highIndex[arr[i]];

                for(int j = 0; j < N; ++j) {
                    if (cnt == 0 && finalPos[j] == 0) {
                        finalPos[j] = arr[i];
                        break;
                    }

                    if (finalPos[j] == 0) {
                        --cnt;
                    }
                }
            }

            for(i = 0; i < N; ++i) {
                System.out.print(finalPos[i] + " ");
            }

            System.out.println();
        }

        scanner.close();
    }
}
