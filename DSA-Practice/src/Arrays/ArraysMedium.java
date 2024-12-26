//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysMedium {
    public ArraysMedium() {
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int max = Integer.MIN_VALUE;

        while(l < r) {
            int minHeight = Math.min(height[l], height[r]);

            for(max = Math.max(max, (r - l) * minHeight); height[l] <= minHeight; ++l) {
            }

            while(height[r] <= minHeight) {
                --r;
            }
        }

        return max;
    }

    //274. H-Index
    public static int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);

        for (int i = 0; i < n; i++) {
            if(citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

    //134. Gas Station
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal = 0, costTotal = 0, tank = 0;
        int startPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            costTotal += cost[i];
            gasTotal += gas[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                startPoint = i + 1;
                tank = 0;
            }
        }
        return gasTotal < costTotal ? -1 : startPoint;
    }

    //238. Product of Array Except Self
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0 ; i--) {
            res[i] = res[i] * suffix;
            suffix *= nums[i];
        }
        return res;
    }



    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = n-1;

            while (l < r) {
                int totalSum = nums[i] + nums[l] + nums[r];
                if(totalSum == 0) {
                    List<Integer> lt = new ArrayList<>();
                    lt.add(nums[i]);
                    lt.add(nums[l]);
                    lt.add(nums[r]);
                    list.add(lt);
                    l++;
                    while (nums[l] == nums[l-1] && l < r) l++;
                }else if(totalSum > 0) r--;
                else l++;
            }
        }
        return list;


    }

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closeSum = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i = 0; i < n; ++i) {
            if (i <= 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = n - 1;

                while(j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - sum) < Math.abs(target - closeSum)) {
                        closeSum = sum;
                    } else if (sum < target) {
                        ++j;
                    } else {
                        --k;
                    }
                }
            }
        }

        return closeSum;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> q = new ArrayList();
        int n = nums.length;

        for(int i = 0; i < n - 3; ++i) {
            if (i <= 0 || nums[i] != nums[i - 1]) {
                label69:
                for(int j = i + 1; j < n; ++j) {
                    if (j <= i + 1 || nums[j] != nums[j - 1]) {
                        int l = j + 1;
                        int r = n - 1;

                        while(true) {
                            while(true) {
                                if (l >= r) {
                                    continue label69;
                                }

                                long sum = (long)nums[i] + (long)nums[j] + (long)nums[l] + (long)nums[r];
                                if ((long)target == sum) {
                                    ArrayList<Integer> al = new ArrayList();
                                    al.add(nums[i]);
                                    al.add(nums[j]);
                                    al.add(nums[l]);
                                    al.add(nums[r]);
                                    Collections.sort(al);
                                    q.add(al);
                                    ++l;
                                    --r;

                                    while(l < r && nums[r] == nums[r + 1]) {
                                        --r;
                                    }

                                    while(l < r && nums[l] == nums[l - 1]) {
                                        ++l;
                                    }
                                } else if (sum < (long)target) {
                                    ++l;
                                } else {
                                    --r;
                                }
                            }
                        }
                    }
                }
            }
        }

        return q;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            this.swap(nums, start, end);
            ++start;
            --end;
        }

    }

    public void nextPermutation(int[] nums) {
        if (nums != null && nums.length > 1) {
            int i;
            for(i = nums.length - 2; i >= 0 && nums[i] >= nums[i + 1]; --i) {
            }

            if (i >= 0) {
                int j;
                for(j = nums.length - 1; j >= 0 && nums[j] <= nums[i]; --j) {
                }

                this.swap(nums, i, j);
            }

            this.reverse(nums, i + 1, nums.length - 1);
        }
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r) {
            int mid = (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (target > nums[mid] && target <= nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int valIndex = -1;

        int fIndex;
        while(l <= r) {
            fIndex = l + (r - l) / 2;
            if (nums[fIndex] == target) {
                valIndex = fIndex;
                break;
            }

            if (nums[fIndex] > target) {
                r = fIndex - 1;
            } else {
                l = fIndex + 1;
            }
        }

        if (valIndex == -1) {
            return new int[]{-1, -1};
        } else {
            for(fIndex = valIndex; fIndex > 0 && nums[fIndex - 1] == target; --fIndex) {
            }

            int lIndex;
            for(lIndex = valIndex; lIndex < n - 1 && nums[lIndex + 1] == target; ++lIndex) {
            }

            return new int[]{fIndex, lIndex};
        }
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - 49;
                    int boxIndex = i / 3 * 3 + j / 3;
                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false;
                    }

                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }

        return true;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        int i;
        int j;
        int temp;
        for(i = 0; i < n; ++i) {
            for(j = i; j < n; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(i = 0; i < n; ++i) {
            for(j = 0; j < n / 2; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

    }

    //151. Reverse Words in a String
    public static String reverseWords(String s) {
        String [] tempString = s.split(" ");
        int n = tempString.length;
        int l = 0, r = n -1 ;
        while (l <= r) {
            String temp = tempString[l];
            tempString[l] = tempString[r];
            tempString[r]= temp;
            l++;r--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : tempString) {
            if (word != null && !word.isEmpty()) {
                if (word.length() > 0) stringBuilder.append(" ");
                stringBuilder.append(word);
            }
        }
        return stringBuilder.toString();
    }

    //6. Zigzag Conversion
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        char[][] charArray = new char[numRows][s.length()];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                charArray[i][j] = ' ';
            }
        }

        int i = 0, j = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            charArray[i][j] = c;
            if (i == 0 || i == numRows - 1) goingDown = !goingDown;
            i += goingDown ? 1 : -1;
            if (!goingDown) j++;
        }

        StringBuilder result = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col <= j; col++) {
                if (charArray[row][col] != ' ') {
                    result.append(charArray[row][col]);
                }
            }
        }

        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));

//        char[][] var10000 = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        int[] s = new int[]{5, 7, 7, 8, 8, 10};
//        int[] l = searchRange(s, 8);
//        System.out.println(l[0] + l[1]);

    }
}
