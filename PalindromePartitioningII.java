public class Solution {
    public int minCut(String s) {
        if (s.length() == 0 || s.length() == 1)
            return 0;
        //first generate the 2d dp array to record wether the substring(i, j) inclusive is a palindrome or not
        boolean [][] isPal = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) { //because we need isPal[i+1] before we calculate isPal[i], i need to grow from s.length() - 1 to 0
            for (int j = i; j < s.length(); j++) {
                if (i == j)
                    isPal[i][j] = true;
                else if (j - i == 1)
                    isPal[i][j] = s.charAt(i) == s.charAt(j);
                else 
                    isPal[i][j] = (s.charAt(i) == s.charAt(j)) && isPal[i+1][j-1];
            }
        }
        //Then use another dynamic programming array to determine the minimum cut
        int [] minCut = new int [s.length()];
        minCut[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            minCut[i] = minCut[i-1] + 1; // min cut is at least minCut[i-1] + 1
            if (isPal[0][i])
                minCut[i] = 0;
            else {
                for(int j = 1; j < i; j++) {
                    if (isPal[j][i]) {
                        minCut[i] = Math.min(minCut[i], minCut[j-1] + 1);
                    }
                }
            }
        }
        return minCut[s.length() - 1];
    }
}
