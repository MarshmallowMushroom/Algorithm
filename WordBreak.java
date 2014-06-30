Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

A naive solution:

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0)
            return true;
        if (dict.contains(s))
            return true;
        for (int i = 1; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i)) && wordBreak(s.substring(i, s.length()), dict))
                return true;
        }
        return false;
    }
}

The running time is O(2^n), why? because if we have an input string with all "a"s with a b at the end, and the dictinary contains "a", "aa", "aaa"... Then we have to check all the subset of the input string and the number of subset of a string with n chars are 2^n (powerset including empty string and the stirng itself).

The dynamic programming algorithm can reduce the run time to O(n^2) or O(n*size of dict).



