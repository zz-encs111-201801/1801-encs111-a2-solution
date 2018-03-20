package q9_781;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/contest/weekly-contest-71/problems/rabbits-in-forest/
 * Hint: Greedy
 *
 * 请将代码提交到上面的网址进行测试
 */
public class Solution {
    public int numRabbits(int[] answers) {

        Map<Integer, Integer> counts = new HashMap<>();
        for (int answer : answers) {
            int count = counts.getOrDefault(answer, 0);
            counts.put(answer, count + 1);
        }

        int total = 0;
        Set<Map.Entry<Integer, Integer>> entries = counts.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int declare = entry.getKey();
            int count = entry.getValue();
            int countInGroup = declare + 1;
            int group = (int) Math.ceil(1.0 * count / countInGroup);
            total += group * countInGroup;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 2};
        System.out.println(solution.numRabbits(arr));
    }
}
