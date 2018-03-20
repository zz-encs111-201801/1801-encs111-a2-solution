package q8_779;

/*
 * https://leetcode.com/contest/weekly-contest-70/problems/k-th-symbol-in-grammar/
 * Hint: Greedy + Decrease
 *
 * 请将代码提交到上面的网址进行测试
 */

public class Solution {
    public int kthGrammar(int N, int K) {
        if ( N == 1 ) {
            return 0;
        }

        int length = (int)Math.pow(2, N - 1);

        if (K > length / 2)  {
            int result = kthGrammar(N - 1, K - length / 2);
            return result == 0 ? 1 : 0;
        } else {
            return kthGrammar(N - 1, K);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthGrammar(3, 3));
    }
}
