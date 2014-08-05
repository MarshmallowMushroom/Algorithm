/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

//A very briliant method to solve this problem in O(N) time

public class Solution {
    /*The O(n) solution*/
    public String preProcess(String s) { // and # between the characters, also add ^ and $ so that we don't need to check for boundary. 
        StringBuilder tmp = new StringBuilder();
        tmp.append('^');
        tmp.append('#');
        for (int i = 0; i < s.length(); i++) {
            tmp.append(s.charAt(i));
            tmp.append('#');
        }
        tmp.append('$');
        return new String(tmp);
    }
    
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s;
        int C = 0;
        int R = 0;
        String T = preProcess(s);
        int [] P = new int [T.length()];
        P[0] = 0;
        for (int i = 1; i < T.length() - 1; i++) {
            int m = 2*C - i;
            if (i >= R)
                P[i] = 0;
            else 
                P[i] = Math.min(P[m], R - i);
            //extend the palindrome centered at i, 
            //This inner loop can extend R, during the whole process, at most N times
            while(T.charAt(i + P[i] + 1) == T.charAt(i - P[i] - 1))
                P[i]++;
            
            //if palindrome centered at i passed the R, change C to i and R to new boarder
            if (i + P[i] > R) {
                R = i + P[i];
                C = i;
            }
        }
        //find the palindrome 
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < P.length - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        return s.substring((centerIndex - 1)/2 - maxLen/2, (centerIndex - 1)/2 + (maxLen + 1)/2);
    }
}
