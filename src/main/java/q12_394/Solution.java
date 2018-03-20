package q12_394;


import java.util.LinkedList;
import java.util.Stack;

/*
 *  https://leetcode.com/contest/leetcode-weekly-contest-3/problems/decode-string/
 *  Hint: List
 *
 *  请将代码提交到上面的网址进行测试
 */
public class Solution {
    public String decodeString(String s) {
        if (s.length() == 0) {
            return "";
        }

        strings.addLast(new StringBuffer());

        boolean digitChain = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                if (digitChain) {
                    multipliers.getLast().append(c);
                } else {
                    multipliers.addLast(new StringBuffer(c + ""));
                }

            } else if (Character.isLetter(c)) {
                strings.getLast().append(c);

            } else if (c == '[') {
                strings.addLast(new StringBuffer(""));

            } else if (c == ']') {
                int repeat = Integer.valueOf(multipliers.removeLast().toString());
                StringBuffer pattern = strings.removeLast();

                for (int j = 0; j < repeat; j++) {
                    strings.getLast().append(pattern);
                }
            }

            digitChain = Character.isDigit(c);
        }

        return strings.getLast().toString();
    }

    private LinkedList<StringBuffer> strings = new LinkedList<>();
    private LinkedList<StringBuffer> multipliers = new LinkedList<>();


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("10[a3[b]]"));
    }
}

