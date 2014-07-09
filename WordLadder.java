/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        ArrayList<String> next = getOneDiffString(start, dict);
        int dist = 1;
        if (start.equals(end)) 
            return 1;
        while(!next.isEmpty()){
            dist++;
            ArrayList<String> tmpList = new ArrayList<String>();
            for (String tmp : next) {
                if (tmp.equals(end))
                    return dist;
                tmpList.addAll(getOneDiffString(tmp, dict));
            }
            next = tmpList;
        }
        return 0;
    }
    
    private ArrayList<String> getOneDiffString(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(i, c);
                if (!((new String(sb)).equals(s)) && dict.contains(new String(sb))){
                    res.add(new String(sb));
                    dict.remove(new String(sb));
                } 
            }
        }
        return res;
    }
}
