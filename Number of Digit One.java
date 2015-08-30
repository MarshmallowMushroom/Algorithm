public class Solution {
    public int countDigitOne(int n) {
        int highn = n;
        int lown = 0;
        int lowc = 1;
        int res = 0;
        while(highn > 0) {
            int curr = highn%10;
            highn /= 10;
            if (curr == 0) {
                res += highn * lowc;
            } else if (curr == 1) {
                res += highn * lowc;
                res += lown + 1;
            } else {
                res += (highn + 1) * lowc;
            }
            lown = curr*lowc+lown;
            lowc *= 10;
        }
        return res;
    }
}
