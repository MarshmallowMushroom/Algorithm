public class Solution {
    public int reverse(int x) {
        boolean neg = x < 0;
        long l = Math.abs(x);
        long result = 0;
        while(l > 0) {
            result = result * 10;
            result += l % 10;
            l = l / 10;
        }
        return (int)(neg? -1 * result : result);
    }
}
