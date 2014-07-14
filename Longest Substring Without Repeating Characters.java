public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        int start = 0; 
        //int end = 0;
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }
            map.put(s.charAt(end), end);
            max = Math.max(end - start + 1, max);
        }
        return max;
    }
}
