/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class Solution {
    public HashMap<Character, String> initMap() {
        HashMap<Character, String> dialMap = new HashMap<Character, String>();
        dialMap.put('2', "abc");
        dialMap.put('3', "def");
        dialMap.put('4', "ghi");
        dialMap.put('5', "jkl");
        dialMap.put('6', "mno");
        dialMap.put('7', "pqrs");
        dialMap.put('8', "tuv");
        dialMap.put('9', "wxyz");
        return dialMap;
    }
    
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> dialMap = initMap();
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0) {
            result.add("");
            return result;
        }
        List<String> next = letterCombinations(digits.substring(1));
        if (digits.charAt(0) == '0' || digits.charAt(0) == '1')
            return next;;
        String curr = dialMap.get(digits.charAt(0));
        for (int i = 0; i < curr.length(); i++) {
            for (String s : letterCombinations(digits.substring(1))) {
                StringBuilder t = new StringBuilder(s);
                t.insert(0, curr.charAt(i));
                result.add(new String(t));
            }
        }
        return result;
    }
}
