public class Solution {
    public int trailingZeroes(int n) {
        long power = 5;
        long num = (long)n;
        long result = 0;
        while(num >= power) {
            result += n/power;
            power *= 5;
        }
        return (int)result;
    }
}
