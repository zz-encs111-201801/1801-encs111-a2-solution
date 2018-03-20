package q10_713;

/*
 * https://leetcode.com/contest/leetcode-weekly-contest-55/problems/subarray-product-less-than-k/
 * Hint: Greedy + List
 *
 * 请将代码提交到上面的网址进行测试
 */

public class Solution {

    //  Mark - Context

    private int[] nums;
    private int limit;

    private int value;
    private int count;

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // base cases
        if (nums.length == 0) {
            return 0;
        }

        if (k < 2) {
            return 0;
        }

        // init
        this.nums = nums;
        limit = k;
        value = nums[0];

        start = 0;
        end = 1;

        // core
        while (true) {
            seekEnd();
            if (inLimit()) {
                break;
            }
            seekStart();
        }

        return count;
    }

    //  Mark - Seek

    private int start;
    private int end;

    private void seekStart() {
        while (true) {
            if (inLimit()) {
                return;
            }

            if (canMoveStart()) {
                moveStart();
            } else {
                break;
            }
        }
    }

    private void seekEnd() {
        while (true) {
            if (!inLimit()) {
                return;
            }

            collect();

            if (canMoveEnd()) {
                moveEnd();
            } else {
                break;
            }
        }
    }

    private boolean canMoveStart() {
        return start < nums.length - 1;
    }

    private void moveStart() {
        value /= nums[start];
        start += 1;
    }

    private boolean canMoveEnd() {
        return end < nums.length;
    }

    private void moveEnd(){
        value *= nums[end];
        end += 1;
    }

    private void collect() {
        count += end - start;
    }

    private boolean inLimit() {
        return value < limit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10, 5, 2, 6};
        System.out.println(solution.numSubarrayProductLessThanK(arr, 100));
    }
}
