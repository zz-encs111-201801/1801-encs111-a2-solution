package q7_power;

public class Solution {

    public int power(int base, int power) {
        if (power == 1) {
            return base;
        }

        int halfPower = power / 2;
        int halfResult = power(base, halfPower);

        int result = halfResult * halfResult;
        if (power % 2 == 1) {
            result *= base;
        }

        return result;
    }
}
