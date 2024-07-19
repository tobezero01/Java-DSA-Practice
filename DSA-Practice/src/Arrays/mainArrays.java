//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class mainArrays {
    public mainArrays() {
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            i = Math.abs(nums[i]) - 1;
            if (nums[i] > 0) {
                nums[i] = -nums[i];
            }
        }

        List<Integer> result = new ArrayList();

        for(int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int l = 0;
        int r = 0;
        if (s != null && g != null) {
            Arrays.sort(g);
            Arrays.sort(s);

            while(l < g.length && r < s.length) {
                int child = g[l];
                int cook = s[r];
                if (cook < child) {
                    ++r;
                }

                if (cook >= child) {
                    ++count;
                    ++r;
                    ++l;
                }
            }

            return count;
        } else {
            return 0;
        }
    }

    public static int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int s = 0;

        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    s += 4;
                }

                if (i > 0 && grid[i - 1][j] == 1) {
                    s -= 2;
                }

                if (j > 0 && grid[i][j - 1] == 1) {
                    s -= 2;
                }
            }
        }

        return s;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int[] count = new int[nums.length];
        int x = 0;

        int m;
        for(m = 0; m < nums.length; ++m) {
            if (nums[m] == 0) {
                ++x;
            } else {
                int var10002 = count[x]++;
            }
        }

        m = count[0];
        int[] var7 = count;
        int var6 = count.length;

        for(int var5 = 0; var5 < var6; ++var5) {
            int i = var7[var5];
            if (i > m) {
                m = i;
            }
        }

        return m;
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = duration;
        if (timeSeries == null) {
            return 0;
        } else {
            for(int i = 0; i < timeSeries.length - 1; ++i) {
                if (timeSeries[i + 1] - timeSeries[i] >= duration) {
                    count += duration;
                } else {
                    count += timeSeries[i + 1] - timeSeries[i];
                }
            }

            return count;
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];
        int max = nums2[0];
        int[] vt = new int[n];

        for(int i = 0; i < m; ++i) {
            if (max < nums2[i]) {
                max = nums2[i];
            }
        }

        int[] check = new int[max + 1];

        int i;
        for(i = 0; i < max + 1; ++i) {
            check[i] = 0;
        }

        int j;
        for(i = 0; i < n; ++i) {
            for(j = 0; j < m; ++j) {
                if (nums1[i] == nums2[j]) {
                    vt[i] = j;
                }
            }
        }

        for(i = 0; i < n; ++i) {
            for(j = 0; j < m; ++j) {
                if (nums1[i] < nums2[j] && vt[i] < j) {
                    check[nums1[i]] = nums2[j];
                    break;
                }

                check[nums1[i]] = -1;
            }
        }

        for(i = 0; i < n; ++i) {
            for(j = 0; j < check.length; ++j) {
                if (nums1[i] == j) {
                    ans[i] = check[j];
                }
            }
        }

        return ans;
    }

    public static String[] findWords(String[] words) {
        String[] n = new String[words.length];
        int k = 0;

        int check;
        for(int i = 0; i < words.length; ++i) {
            check = row(words[i].charAt(0));

            for(int j = 1; j < words[i].length(); ++j) {
                if (check != row(words[i].charAt(j))) {
                    check = 0;
                    break;
                }
            }

            if (check != 0) {
                n[k] = words[i];
                ++k;
            }
        }

        String[] ans = new String[k];

        for(check = 0; check < k; ++check) {
            ans[check] = n[check];
        }

        return ans;
    }

    public static int row(char c) {
        c = Character.toLowerCase(c);
        String str1 = "qwertyuiop";
        String str2 = "asdfghjkl";
        String str3 = "zxcvbnm";
        if (str1.contains(String.valueOf(c))) {
            return 1;
        } else if (str2.contains(String.valueOf(c))) {
            return 2;
        } else {
            return str3.contains(String.valueOf(c)) ? 3 : 0;
        }
    }

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int max = 0;
        String[] answer = new String[n];

        for(int i = 0; i < n; ++i) {
            max = Math.max(max, score[i]);
        }

        int[] temp = new int[max + 1];

        int place;
        for(place = 0; place < n; ++place) {
            temp[score[place]] = place + 1;
        }

        place = 1;

        for(int i = max; i >= 0; --i) {
            if (temp[i] != 0) {
                int actualPlace = temp[i] - 1;
                if (place == 1) {
                    answer[actualPlace] = "Gold Medal";
                } else if (place == 2) {
                    answer[actualPlace] = "Silver Medal";
                } else if (place == 3) {
                    answer[actualPlace] = "Bronze Medal";
                } else {
                    answer[actualPlace] = String.valueOf(place);
                }

                ++place;
            }
        }

        return answer;
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;

        for(int i = 0; i < nums.length - 1; i += 2) {
            res += nums[i];
        }

        return res;
    }

    public static int distributeCandies(int[] candyType) {
        boolean[] types = new boolean[200001];
        int count = 0;
        int[] var6 = candyType;
        int var5 = candyType.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            int candy = var6[var4];
            if (!types[candy + 100000]) {
                types[candy + 100000] = true;
                ++count;
            }
        }

        return Math.min(count, candyType.length / 2);
    }

    public static int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        } else {
            int minrow = Integer.MAX_VALUE;
            int mincol = Integer.MAX_VALUE;
            int[][] var8 = ops;
            int var7 = ops.length;

            for(int var6 = 0; var6 < var7; ++var6) {
                int[] grid = var8[var6];
                minrow = Math.min(minrow, grid[0]);
                mincol = Math.min(mincol, grid[1]);
            }

            return minrow * mincol;
        }
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap();

        for(int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList();
        int minSum = Integer.MAX_VALUE;

        for(int i = 0; i < list2.length; ++i) {
            if (map.containsKey(list2[i])) {
                int j = (Integer)map.get(list2[i]);
                int currentSum = i + j;
                if (currentSum < minSum) {
                    result.clear();
                    result.add(list2[i]);
                    minSum = currentSum;
                } else if (currentSum == minSum) {
                    result.add(list2[i]);
                }
            }
        }

        return (String[])result.toArray(new String[result.size()]);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for(int i = 0; i < flowerbed.length; i += 2) {
            if (flowerbed[i] == 0) {
                if (i != flowerbed.length - 1 && flowerbed[i + 1] != 0) {
                    ++i;
                } else {
                    ++count;
                }
            }

            if (count >= n) {
                return true;
            }
        }

        return false;
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }

    public static int maximumProduct(int[] nums, int n) {
        Arrays.sort(nums);
        int len = nums.length;
        int maxProduct = 1;

        int i;
        for(i = len - 1; i >= len - n; --i) {
            maxProduct *= nums[i];
        }

        for(i = 0; i <= n; ++i) {
            int tempProduct = 1;

            int j;
            for(j = 0; j < i; ++j) {
                tempProduct *= nums[j];
            }

            for(j = len - 1; j >= len - (n - i); --j) {
                tempProduct *= nums[j];
            }

            maxProduct = Math.max(maxProduct, tempProduct);
        }

        return maxProduct;
    }

    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;

        for(int i = 0; i < k; ++i) {
            sum += (double)nums[i];
        }

        double currentSum = sum;

        for(int i = 0; i < nums.length - k; ++i) {
            currentSum += (double)(nums[i + k] - nums[i]);
            sum = Math.max(sum, currentSum);
        }

        return sum / (double)k;
    }

    public static int findLengthOfLCIS(int[] nums) {
        int count = 1;
        if (nums == null) {
            count = 0;
        }

        int n = nums.length;
        int curCount = count;

        for(int i = 0; i < n - 1; ++i) {
            if (nums[i] < nums[i + 1]) {
                ++curCount;
            } else {
                curCount = 1;
            }

            count = Math.max(count, curCount);
        }

        return count;
    }

    public static int calPoints(String[] operations) {
        int n = operations.length;
        int[] score = new int[n];
        int index = 0;
        String[] var7 = operations;
        int var6 = operations.length;

        int i;
        for(i = 0; i < var6; ++i) {
            String op = var7[i];
            if (op.equals("+")) {
                score[index] = score[index - 1] + score[index - 2];
                ++index;
            } else if (op.equals("D")) {
                score[index] = 2 * score[index - 1];
                ++index;
            } else if (op.equals("C")) {
                --index;
            } else {
                score[index] = Integer.parseInt(op);
                ++index;
            }
        }

        int sum = 0;

        for(i = 0; i < index; ++i) {
            sum += score[i];
        }

        return sum;
    }

//    public static int findShortestSubArray(int[] nums) {
//        int max = 0;
//        int[] var5 = nums;
//        int n = nums.length;
//
//        int m;
//        for(m = 0; m < n; ++m) {
//            int n = var5[m];
//            if (max < n) {
//                max = n;
//            }
//        }
//
//        int[] arr = new int[max + 1];
//        m = 0;
//        int[] var7 = nums;
//        int end = nums.length;
//
//        int start;
//        int var10002;
//        for(start = 0; start < end; ++start) {
//            n = var7[start];
//            var10002 = arr[n]++;
//            if (m < arr[n]) {
//                m = arr[n];
//            }
//        }
//
//        if (m == 1) {
//            return 1;
//        } else {
//            int[] temp = new int[max + 1];
//            start = 0;
//            end = 0;
//            int n = nums.length;
//
//            int ans;
//            for(ans = n; end < nums.length; ++end) {
//                int x = nums[end];
//                var10002 = temp[x]++;
//                if (temp[x] == m) {
//                    while(nums[start] != x) {
//                        --temp[nums[start]];
//                        ++start;
//                    }
//
//                    ans = Math.min(ans, end - start + 1);
//                }
//            }
//
//            return ans;
//        }
//    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (n < 2) {
            return true;
        } else {
            int i = 0;

            while(i < n - 1) {
                if (bits[i] == 1) {
                    i += 2;
                } else {
                    ++i;
                }
            }

            if (i == n - 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        } else {
            int sumL = 0;
            int sumR = 0;
            int[] var7 = nums;
            int var6 = nums.length;

            int i;
            for(int var5 = 0; var5 < var6; ++var5) {
                i = var7[var5];
                sumR += i;
            }

            for(i = 0; i < n; ++i) {
                sumR -= nums[i];
                if (sumR == sumL) {
                    return i;
                }

                sumL += nums[i];
            }

            return -1;
        }
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        char[] var5 = letters;
        int var4 = letters.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            char l = var5[var3];
            if (l > target) {
                return l;
            }
        }

        return letters[0];
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        for(int i = 2; i < cost.length + 1; ++i) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[dp.length - 1];
    }

    public static int dominantIndex(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int val = 0;

        int i;
        for(i = 0; i < n; ++i) {
            if (max < nums[i]) {
                max = nums[i];
                val = i;
            }
        }

        System.out.println("" + max + " " + val);

        for(i = 0; i < n; ++i) {
            if (max / 2 < nums[i]) {
                return -1;
            }
        }

        return val;
    }

    public static double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0.0;

        for(int i = 0; i < n - 2; ++i) {
            for(int j = i + 1; j < n - 1; ++j) {
                for(int k = j + 1; k < n; ++k) {
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];
                    double area = 0.5 * (double)Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]));
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        return maxArea;
    }

    public String mostCommonWord(String s, String[] banned) {
        Set<String> set = new HashSet();
        String[] var7 = banned;
        int var6 = banned.length;

        int n;
        for(n = 0; n < var6; ++n) {
            String b = var7[n];
            set.add(b);
        }

        char[] cs = s.toCharArray();
        n = cs.length;
        String ans = null;
        Map<String, Integer> map = new HashMap();
        int i = 0;

        while(true) {
            String sub;
            do {
                do {
                    do {
                        if (i >= n) {
                            return ans;
                        }

                        if (Character.isLetter(cs[i])) {
                            break;
                        }

                        ++i;
                    } while(i >= 0);

                    int j;
                    for(j = i; j < n && Character.isLetter(cs[j]); ++j) {
                    }

                    sub = s.substring(i, j).toLowerCase();
                    i = j + 1;
                } while(set.contains(sub));

                map.put(sub, (Integer)map.getOrDefault(sub, 0) + 1);
            } while(ans != null && (Integer)map.get(sub) <= (Integer)map.get(ans));

            ans = sub;
        }
    }

    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];
        int k = 0;
        int count = 0;

        for(int i = 0; i < n; ++i) {
            if (s.charAt(i) == c) {
                ++count;
            }
        }

        int[] save = new int[count];

        int i;
        for(i = 0; i < n; ++i) {
            if (s.charAt(i) == c) {
                save[k++] = i;
            }
        }

        for(i = 0; i < n; ++i) {
            int min = Integer.MAX_VALUE;

            for(int j = 0; j < save.length; ++j) {
                min = Math.min(min, Math.abs(i - save[j]));
            }

            answer[i] = min;
        }

        return answer;
    }

    public static boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        if (bills[0] != 5) {
            return false;
        } else {
            int count5 = 0;
            int count10 = 0;

            for(int i = 0; i < n; ++i) {
                if (bills[i] == 5) {
                    ++count5;
                } else if (bills[i] == 10) {
                    if (count5 == 0) {
                        return false;
                    }

                    --count5;
                    ++count10;
                } else {
                    if (count5 == 0) {
                        return false;
                    }

                    if (count5 < 3 && count10 == 0) {
                        return false;
                    }

                    if (count5 >= 3 && count10 == 0) {
                        count5 -= 3;
                    } else {
                        --count5;
                        --count10;
                    }
                }
            }

            return true;
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] temp = new int[col][row];

        for(int i = 0; i < col; ++i) {
            for(int j = 0; j < row; ++j) {
                temp[i][j] = matrix[j][i];
            }
        }

        return temp;
    }

    public static int projectionArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        int x = 0;

        for(int i = 0; i < m; ++i) {
            int maxRow = Integer.MIN_VALUE;
            int maxCol = Integer.MIN_VALUE;

            for(int j = 0; j < n; ++j) {
                if (grid[i][j] != 0) {
                    ++x;
                }

                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
            }

            result += maxRow + maxCol;
        }

        return result + x;
    }

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumAlice = 0;
        int sumBob = 0;
        int[] var7 = aliceSizes;
        int a = aliceSizes.length;

        int diff;
        int var5;
        for(var5 = 0; var5 < a; ++var5) {
            diff = var7[var5];
            sumAlice += diff;
        }

        var7 = bobSizes;
        a = bobSizes.length;

        for(var5 = 0; var5 < a; ++var5) {
            diff = var7[var5];
            sumBob += diff;
        }

        diff = (sumAlice - sumBob) / 2;
        Set<Integer> bobSet = new HashSet();
        int[] var9 = bobSizes;
        int var8 = bobSizes.length;

        int var12;
        for(var12 = 0; var12 < var8; ++var12) {
            a = var9[var12];
            bobSet.add(a);
        }

        var9 = aliceSizes;
        var8 = aliceSizes.length;

        for(var12 = 0; var12 < var8; ++var12) {
            a = var9[var12];
            int b = a - diff;
            if (bobSet.contains(b)) {
                return new int[]{a, b};
            }
        }

        return new int[0];
    }

    public static boolean isMonotonic(int[] nums) {
        int n = nums.length - 1;
        boolean inc = true;
        boolean dec = true;

        for(int i = 0; i < n; ++i) {
            if (nums[i] > nums[i + 1]) {
                inc = false;
            }

            if (nums[i] < nums[i + 1]) {
                dec = false;
            }
        }

        if (!inc && !dec) {
            return false;
        } else {
            return true;
        }
    }

    public static int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int l = 0;
        int r = n - 1;

        for(int i = 0; i < n; ++i) {
            if (nums[i] % 2 == 0) {
                temp[l++] = nums[i];
            } else {
                temp[r--] = nums[i];
            }
        }

        return temp;
    }

    public static int smallestRangeI(int[] nums, int k) {
        int max_val = nums[0];
        int min_val = nums[0];

        for(int i = 0; i < nums.length; ++i) {
            min_val = Math.min(min_val, nums[i]);
            max_val = Math.max(max_val, nums[i]);
        }

        return min_val + k >= max_val - k ? 0 : max_val - k - (min_val + k);
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int l = 0;
        int r = 1;

        for(int i = 0; i < n; ++i) {
            if (nums[i] % 2 == 0) {
                temp[l] = nums[i];
                l += 2;
            } else {
                temp[r] = nums[i];
                r += 2;
            }
        }

        return temp;
    }

    public static String newEmail(String email) {
        StringBuilder str = new StringBuilder();
        int atIndex = email.indexOf(64);

        for(int i = 0; i < atIndex; ++i) {
            char ch = email.charAt(i);
            if (ch == '+') {
                break;
            }

            if (ch != '.') {
                str.append(ch);
            }
        }

        str.append(email.substring(atIndex));
        return str.toString();
    }

    public static int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet();
        String[] var5 = emails;
        int var4 = emails.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            String email = var5[var3];
            uniqueEmails.add(newEmail(email));
        }

        return uniqueEmails.size();
    }

    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        } else {
            int i;
            for(i = 0; i + 1 < n && arr[i] < arr[i + 1]; ++i) {
            }

            if (i != 0 && i != n - 1) {
                while(i + 1 < n && arr[i] > arr[i + 1]) {
                    ++i;
                }

                return i == n - 1;
            } else {
                return false;
            }
        }
    }

    public static int[] diStringMatch(String s) {
        int n = s.length() + 1;
        int[] arr = new int[n];
        int index = 0;
        int l = 0;
        int r = n - 1;
        char[] var9;
        int var8 = (var9 = s.toCharArray()).length;

        for(int var7 = 0; var7 < var8; ++var7) {
            char ch = var9[var7];
            if (ch == 'I') {
                arr[index++] = l++;
            } else {
                arr[index++] = r--;
            }
        }

        arr[n - 1] = l;
        return arr;
    }

    public static int minDeletionSize(String[] strs) {
        int numRows = strs.length;
        int numCols = strs[0].length();
        int count = 0;

        for(int col = 0; col < numCols; ++col) {
            for(int row = 1; row < numRows; ++row) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    ++count;
                    break;
                }
            }
        }

        return count;
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int[] charOrder = new int[26];

        int i;
        for(i = 0; i < order.length(); charOrder[order.charAt(i) - 97] = i++) {
        }

        for(i = 0; i < words.length - 1; ++i) {
            if (!isInCorrectOrder(words[i], words[i + 1], charOrder)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isInCorrectOrder(String word1, String word2, int[] charOrder) {
        int len1 = word1.length();
        int len2 = word2.length();
        int len = Math.min(len1, len2);

        for(int i = 0; i < len; ++i) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 != c2) {
                if (charOrder[c1 - 97] < charOrder[c2 - 97]) {
                    return true;
                }

                return false;
            }
        }

        return len1 <= len2;
    }

    public static int repeatedNTimes(int[] nums) {
        HashSet<Integer> hp = new HashSet();
        int[] var5 = nums;
        int var4 = nums.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            int a = var5[var3];
            if (hp.contains(a)) {
                return a;
            }

            hp.add(a);
        }

        return -1;
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for(int i = nums.length - 1; i > 1; --i) {
            int a = nums[i - 2];
            int b = nums[i - 1];
            int c = nums[i];
            int s = a + b + c;
            if (a + b > c) {
                return s;
            }
        }

        return 0;
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for(int index = n - 1; left <= right; --index) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                ++left;
            } else {
                result[index] = rightSquare;
                --right;
            }
        }

        return result;
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        String nums = "";
        int[] var6 = num;
        int var5 = num.length;

        int sum;
        for(int var4 = 0; var4 < var5; ++var4) {
            sum = var6[var4];
            nums = nums + String.valueOf(sum);
        }

        sum = Integer.parseInt(nums) + k;
        System.out.println(sum);

        ArrayList list;
        for(list = new ArrayList(); sum > 0; sum /= 10) {
            list.add(sum % 10);
        }

        Collections.reverse(list);
        return list;
    }

    public static List<String> commonChars(String[] words) {
        int[] minFrequency = new int[26];
        Arrays.fill(minFrequency, Integer.MAX_VALUE);
        String[] var5 = words;
        int var4 = words.length;

        int i;
        for(i = 0; i < var4; ++i) {
            String word = var5[i];
            int[] charCount = new int[26];
            char[] var10;
            int var9 = (var10 = word.toCharArray()).length;

            for(int var8 = 0; var8 < var9; ++var8) {
                i = var10[var8];
                ++charCount[i - 97];
            }

            for(i = 0; i < 26; ++i) {
                minFrequency[i] = Math.min(minFrequency[i], charCount[i]);
            }
        }

        List<String> list = new ArrayList();

        for(i = 0; i < 26; ++i) {
            while(minFrequency[i] > 0) {
                list.add(String.valueOf((char)(i + 97)));
                int var10002 = minFrequency[i]--;
            }
        }

        return list;
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int res;
        for(res = 0; res < n; ++res) {
            if (k > 0 && nums[res] < 0) {
                --k;
                nums[res] = -nums[res];
            }
        }

        res = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; ++i) {
            res += nums[i];
            min = Math.min(min, nums[i]);
        }

        return res - k % 2 * min * 2;
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;

        int part;
        for(part = 0; part < arr.length; ++part) {
            sum += arr[part];
        }

        if (sum % 3 != 0) {
            return false;
        } else {
            part = sum / 3;
            int temp = 0;
            int count = 0;
            int[] var8 = arr;
            int var7 = arr.length;

            for(int var6 = 0; var6 < var7; ++var6) {
                int x = var8[var6];
                temp += x;
                if (temp == part) {
                    temp = 0;
                    ++count;
                }
            }

            if (count >= 3) {
                return true;
            } else {
                return false;
            }
        }
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList();
        int sum = 0;

        for(int i = 0; i < nums.length; ++i) {
            sum = (sum * 2 + nums[i]) % 5;
            if (sum != 0) {
                list.add(false);
            } else {
                list.add(true);
            }
        }

        return list;
    }

    public static long calcBinary(String str) {
        long sum = 0L;
        long index = 0L;

        for(int i = str.length() - 1; i >= 0; --i) {
            char k = str.charAt(i);
            if (k == '1') {
                sum = (long)((double)sum + Math.pow(2.0, (double)index));
            }

            ++index;
        }

        return sum /= 5L;
    }

    public static boolean isBoomerang(int[][] points) {
        if (points[1][1] == points[2][1] && points[2][1] == points[3][1]) {
            return false;
        } else if (points[1][2] == points[2][2] && points[2][2] == points[3][3]) {
            return false;
        } else {
            return points[0][0] * (points[1][1] - points[2][1]) + points[1][0] * (points[2][1] - points[0][1]) + points[2][0] * (points[0][1] - points[1][1]) != 0;
        }
    }

    public static int heightChecker(int[] heights) {
        int n = heights.length;
        int[] temp = new int[n];
        int index = 0;
        int count = 0;
        int[] var8 = heights;
        int var7 = heights.length;

        int i;
        for(int var6 = 0; var6 < var7; ++var6) {
            i = var8[var6];
            temp[index++] = i;
        }

        Arrays.sort(heights);

        for(i = 0; i < n; ++i) {
            if (temp[i] != heights[i]) {
                ++count;
            }
        }

        return count;
    }

    public static void duplicateZeros(int[] arr) {
        int[] tempArr = new int[arr.length];
        int arrIndex = 0;

        for(int tempIndex = 0; tempIndex < tempArr.length; ++arrIndex) {
            tempArr[tempIndex] = arr[arrIndex];
            if (tempArr[tempIndex++] == 0 && tempIndex < tempArr.length) {
                tempArr[tempIndex++] = 0;
            }
        }

        System.arraycopy(tempArr, 0, arr, 0, arr.length);
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] counter = new int[100];
        int[][] var6 = dominoes;
        int var5 = dominoes.length;

        int var4;
        for(var4 = 0; var4 < var5; ++var4) {
            int[] d = var6[var4];
            int d0 = d[0];
            int d1 = d[1];
            if (d0 < d1) {
                ++counter[d0 * 10 + d1];
            } else {
                ++counter[d1 * 10 + d0];
            }
        }

        int[] var10 = counter;
        var5 = counter.length;

        for(var4 = 0; var4 < var5; ++var4) {
            int v = var10[var4];
            res += v * (v - 1) / 2;
        }

        return res;
    }

    public static int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] countFreq = new int[26];
        char[] var7;
        int var6 = (var7 = chars.toCharArray()).length;

        int var5;
        for(var5 = 0; var5 < var6; ++var5) {
            char s = var7[var5];
            ++countFreq[s - 97];
        }

        String[] var14 = words;
        var6 = words.length;

        for(var5 = 0; var5 < var6; ++var5) {
            String word = var14[var5];
            int[] countWord = new int[26];
            char[] var12;
            int var11 = (var12 = word.toCharArray()).length;

            int i;
            for(i = 0; i < var11; ++i) {
                char x = var12[i];
                ++countWord[x - 97];
            }

            boolean canMatch = true;

            for(i = 0; i < 26; ++i) {
                if (countFreq[i] < countWord[i]) {
                    canMatch = false;
                    break;
                }
            }

            if (canMatch) {
                count += word.length();
            }
        }

        return count;
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int totalDistance = 0;
        int[] var8 = distance;
        int var7 = distance.length;

        int des;
        int i;
        for(i = 0; i < var7; ++i) {
            des = var8[i];
            totalDistance += des;
        }

        des = 0;
        if (start < destination) {
            for(i = start; i < destination; ++i) {
                des += distance[i];
            }
        } else {
            for(i = start - 1; i >= destination; --i) {
                des += distance[i];
            }
        }

        return Math.min(des, totalDistance - des);
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - 1; ++i) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        List<List<Integer>> list = new ArrayList();

        for(int i = 0; i < arr.length - 1; ++i) {
            if (arr[i + 1] - arr[i] == min) {
                List<Integer> sublist = new ArrayList();
                sublist.add(arr[i]);
                sublist.add(arr[i + 1]);
                list.add(sublist);
            }
        }

        return list;
    }

    public static boolean uniqueOccurrences(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        int count = 0;

        int range;
        for(range = 0; range < n; ++range) {
            max = Math.max(max, arr[range]);
            min = Math.min(min, arr[range]);
        }

        range = max - min + 1;
        int[] temp = new int[range];

        for(int i = 0; i < n; ++i) {
            ++temp[arr[i] - min];
        }

        HashSet<Integer> hs = new HashSet();

        for(int i = min; i <= max; ++i) {
            if (temp[i - min] > 0) {
                ++count;
                hs.add(temp[i - min]);
            }
        }

        if (count == hs.size()) {
            return true;
        } else {
            return false;
        }
    }

    public static int minCostToMoveChips(int[] position) {
        return 0;
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        } else {
            int x1 = coordinates[0][0];
            int y1 = coordinates[0][1];
            int x2 = coordinates[1][0];
            int y2 = coordinates[1][1];

            for(int i = 2; i < coordinates.length; ++i) {
                int x3 = coordinates[i][0];
                int y3 = coordinates[i][1];
                if ((y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1)) {
                    return false;
                }
            }

            return true;
        }
    }

    public static int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int res = 0;
        int lMax = 0;
        int rMax = 0;

        while(l < r) {
            if (height[l] <= height[r]) {
                if (height[l] >= lMax) {
                    lMax = height[l];
                } else {
                    res += lMax - height[l];
                }

                ++l;
            } else {
                if (height[r] >= rMax) {
                    rMax = height[r];
                } else {
                    res += rMax - height[r];
                }

                --r;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.print(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    }
}
