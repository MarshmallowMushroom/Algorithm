/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

//Use recursion to find all the result. we write a seperate function isPalindrome to figure out whether a string is palindrome or not
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s.length() == 0) // if 0, return empty string for result
            return res;
        for(int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                //if the whole string is palindrome add to the res
                if (i == s.length()) {
                    List<String> tmp = new ArrayList<String>();
                    tmp.add(s);
                    res.add(tmp);
                }
                else {
                    List<List<String>> next = partition(s.substring(i, s.length()));
                    if (!next.isEmpty()) {
                        for (List<String> l : next) {
                            l.add(0, s.substring(0, i));
                            res.add(l);
                        }
                    }
                }
            }
        }
        return res;   
    }
    
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return true;
        else {
            int i = 0;
            int j = s.length() - 1;
            while(i < j) {
                if (s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }
}
