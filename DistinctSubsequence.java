/*

Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

*/
public class Solution {
    public int numDistinct(String S, String T) {
        if (S.length() < T.length())
            return 0;
        if (T.length() == 0)
            return 1;
        int [][] num = new int[T.length()][S.length()];
        for (int i = 0; i < T.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (i == 0 && j == 0)// if both T and S are only one char
                    num[i][j] = T.charAt(0) == S.charAt(0)? 1 : 0;
                else if (i == 0) // if T is only one char and S is not
                    num[i][j] = T.charAt(0) == S.charAt(j)? num[i][j-1] + 1 : num[i][j-1];
                else if (j == 0) // if S is only one char and T is not
                    num[i][j] = 0;
                else 
                    num[i][j] = T.charAt(i) == S.charAt(j)? num[i-1][j-1] + num[i][j-1] : num[i][j-1];
            }
        }
        return num[T.length() - 1][S.length() - 1];        
    }
}
