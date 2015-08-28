//using a set makes more sense, but that will increase the run time.

public class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean [] notPrime = new boolean [n+2];
        
        int i = 2;
        while(i*i < n) {
            if (!notPrime[i]) {
                int j = i; //start from i*i.
                while(j*i < n) {
                    notPrime[j*i] = true;
                    j++;
                }
            }
            i++;
        }
        
        int count = 0;
        for(int k=2; k<n; k++) {
            if (!notPrime[k]) {
                count++;
            }
        }
        return count;
    }
}
