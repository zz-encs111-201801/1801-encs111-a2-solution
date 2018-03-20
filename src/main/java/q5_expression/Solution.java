package q5_expression;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    /*
     * 假设 formula 一定不会是 null
     * 假设 formula 里的公式一定是合法的，也就是说 不可能出现 "1+"
     * 假设 formula 里至少有一个数
     * 假设 formula 里 的运算符只有 + - * /
     * 假设 formula 的 数和运算符 之间 可能有空格，"1 + 2"， 或者 "1 +2"
     */


    public double evaluate(String formula) {

        formula += "$";

        initOperators();

        parse(formula);

        return evaluate();
    }

    //  Mark - Parsing

    private LinkedList<Character> pendingOperators = new LinkedList<>();
    private LinkedList<Integer> pendingNumbers = new LinkedList<>();

    private void parse(String formula) {
        for (int i = 0; i < formula.length(); ) { // 注意，这里没写 i++
            char c = formula.charAt(i);

            if (c == ' ') {
                i++;
                continue;
            }

            if (isOperator(c)) {
                pendingOperators.addLast(c);
                i++;
                continue;
            }

            int number = 0;
            while (i < formula.length()) {
                c = formula.charAt(i);
                if (!Character.isDigit(c)) {
                    break;
                }

                number *= 10;
                int digit = Character.getNumericValue(c);
                number += digit;
                i++;
            }
            pendingNumbers.addLast(number);
        }
    }


    //  Mark - Evaluate

    private LinkedList<Character> operators = new LinkedList<>();
    private LinkedList<Integer> numbers = new LinkedList<>();

    public int evaluate() {
        while (!pendingOperators.isEmpty()) {
            int number = pendingNumbers.removeFirst();
            char operator = pendingOperators.removeFirst();

            while(true) {
                if (operators.isEmpty()) {
                    break;
                }

                char topOperator = operators.getLast();
                if (priority(operator) > priority(topOperator)) {
                    break;
                }

                operators.removeLast();
                int topNumber = numbers.removeLast();
                number = calculate(topNumber, topOperator, number);
            }

            numbers.addLast(number);
            operators.addLast(operator);
        }
        return numbers.getLast();
    }

    private int calculate(int n1, char operator, int n2) {
        if (operator == '+') {
            return n1 + n2;
        } else if (operator == '-') {
            return n1 - n2;
        } else if (operator == '*') {
            return n1 * n2;
        } else if (operator == '/') {
            return n1 / n2;
        }

        return 0;
    }


    //  Mark - Operator Priorities

    private Map<Character, Integer> operatorPriorities;

    private void initOperators() {
        operatorPriorities = new HashMap<>();

        operatorPriorities.put('+', 1);
        operatorPriorities.put('-', 1);
        operatorPriorities.put('*', 2);
        operatorPriorities.put('/', 2);
        operatorPriorities.put('$', 0);
    }

    private boolean isOperator(char c) {
        return operatorPriorities.containsKey(c);
    }

    private int priority(char operator) {
        return operatorPriorities.get(operator);
    }

}
