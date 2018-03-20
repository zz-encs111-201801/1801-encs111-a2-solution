package q11_402;

/*
 *  https://leetcode.com/contest/leetcode-weekly-contest-5/problems/remove-k-digits/
 *  Hint: List + Greedy
 *
 * 请将代码提交到上面的网址进行测试
 */


import java.util.LinkedList;

public class Solution {

    private LinkedList<Integer> numbers = new LinkedList();

    public String removeKdigits(String num, int k) {
        parse(num);

        for (int i = 0; i < k; i++) {
            remove();
        }

        return toInt();
    }

    private void parse(String num) {
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int digit = Character.getNumericValue(c);
            numbers.addLast(digit);
        }
    }

    private void remove() {
        if (numbers.size() == 0) {
            return;
        }

        int index = 0;
        while (true) {
            int nextIndex = index + 1;
            if (nextIndex >= numbers.size()) {
                break;
            }

            if (numbers.get(nextIndex) < numbers.get(index)) {
                break;
            }
            index = nextIndex;
        }
        numbers.remove(index);

        while (true) {
            if (numbers.size() == 0) {
                break;
            }
            if (numbers.getFirst() != 0) {
                break;
            }
            numbers.removeFirst();
        }
    }

    private String toInt() {
        if (numbers.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (Integer number : numbers) {
            sb.append(number);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));
    }
}
