public class Solution {
    public boolean isNumber(String s) {
        if (s.length() == 0)
            return false;
        int start = 0;
        start += skipSpaces(s, start); //skip space if exist
        if (start == s.length()) //the string has only " " characters
            return false;
        start += skipSign(s, start);
        int d1 = skipDigits(s, start);
        start += d1;
        if (start == s.length()) // xxx only
            return true;
        if (s.charAt(start) == '.') //xxx.xx
            start++;
        int d2 = skipDigits(s, start);
        start += d2;
        if (d1 == 0 && d2 == 0)
            return false;
        if (start == s.length()) // xxx.xx
            return true;
        if (s.charAt(start) == 'e' || s.charAt(start) == 'E') {//xxxexxx
            start++;
            start += skipSign(s, start);
            int d3 = skipDigits(s, start);
            if (d3 == 0)
                return false;
            start += d3;
        }
        
        start += skipSpaces(s, start);
        return (start == s.length());
    }
    
    public int skipSign(String s, int start) {
        if (start < s.length() && (s.charAt(start) == '+' || s.charAt(start) == '-'))
            return 1;
        return 0;
    } 
    
    public int skipDigits(String s, int start) {
        int len = 0;
        while (start < s.length() && Character.isDigit(s.charAt(start))) {
            len++;
            start++;
        }
        return len;
    }
    
    public int skipSpaces(String s, int start) {
        //increment until space was not found
        int len = 0;
        while(start < s.length() && (s.charAt(start) == ' ')) {
            len++;
            start++;
        }
        return len;
    }
}
