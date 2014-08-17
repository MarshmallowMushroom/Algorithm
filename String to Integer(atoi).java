public class Solution {
    public int atoi(String str) {
        boolean neg = false;
        str = str.trim(); //need to assign to str, trim will not affect the original string
        if (str.length() == 0)
            return 0;
        if (str.charAt(0) == '-') {
            neg = true;
            str = str.substring(1);
        }
        else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        if (str.length() == 0)
            return 0;
        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c))
                break;
            result *= 10;
            result += (int)(c - '0');
            if (neg && -1 * result <= Integer.MIN_VALUE) //need to check with neg, otherwise positve - (2 ^ 31 - 1) can not be catched correctly
                return Integer.MIN_VALUE;
            if (!neg && result >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        return (int)(neg? -1 * result : result);
    }
}
