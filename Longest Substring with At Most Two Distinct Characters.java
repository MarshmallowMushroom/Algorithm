/*
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/

public int findLongestSubstringWithTwo(String s) {
  if (s.length <= 2)
    return s.length();
  int start = 0
  int end = 0;
  Map<Character, Integer> map = new HashMap<Character, Integer>();
  int max = 2;
  while(end < s.length()) {
    end++;
    if (map.containsKey(s.charAt(end))) {
      map.put(s.charAt(end), end);
    } else {
      if (map.size() < 2) {
        map.put(s.charAt(end), end);
      } else {
        int idx = end;
        for (Map.Entry e : map.entrySet()) {
          idx = Math.min(e.getValue());
        }
        start = idx+1;
      }
    }
    max = end - start + 1;
  }
  return max
}
