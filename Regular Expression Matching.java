/*
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

//using the recursive method to do back tracking

public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;
        if (p.length() > 1 && p.charAt(1) == '*') { // match *
            if (isMatch(s, p.substring(2)))
                return true;
            for (int i = 0; i < s.length() && matchChar(p.charAt(0), s.charAt(i)); i++) {
                if (isMatch(s.substring(i+1), p.substring(2)))
                    return true;
            }
            return false;
        }
        else {//no * 
            if (s.length() == 0)
                return false;
            if (matchChar(p.charAt(0), s.charAt(0))) {
                return isMatch(s.substring(1), p.substring(1));
            }   
        }
        return false;
    }
    
    public boolean matchChar(char c, char t) {
        if (c == '.')
            return true;
        return c == t;
    }
}
