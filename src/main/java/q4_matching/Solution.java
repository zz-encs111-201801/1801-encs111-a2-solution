package q4_matching;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    /*
     * 假设 formula 一定不会是 null
     */

    public boolean isValid(String formula) {
        if (formula.length() == 0) {
            return true;
        }

        initPairs();

        LinkedList<Character> opens = new LinkedList();

        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);

            if (isOpen(c)) {
                opens.addLast(c);

            } else {
                if (opens.isEmpty()) {
                    return false;
                }

                char open = opens.getLast();
                if (open != pairedOpen(c)) {
                    return false;
                }

                opens.removeLast();
            }
        }
        if (!opens.isEmpty()) {
            return false;
        }

        return true;
    }

    // MARK - Pairs

    private List<Character> opens;
    private List<Character> closes;

    private void initPairs() {
        opens = new LinkedList<>();
        closes = new LinkedList<>();

        opens.add('(');
        opens.add('[');
        opens.add('{');
        closes.add(')');
        closes.add(']');
        closes.add('}');
    }

    private boolean isOpen(char c) {
        return opens.contains(c);
    }

    private char pairedOpen(char c) {
        int index = closes.indexOf(c);
        return opens.get(index);
    }

}
