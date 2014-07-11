//The running time of this algorithm is 2^n for the brute force algorithm. Because we try each of the possible segmentation positions and the total number of that is 2^n

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        //same method, get the boolean array of canSeperate
        if (s.length() == 0)
            return null;
        boolean [] canSeperate = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i+1)))
                canSeperate[i] = true;
            else {
                for (int j = i; j > 0; j--) {
                    if (dict.contains(s.substring(j, i+1)) && canSeperate[j-1]) {
                        canSeperate[i] = true;
                    }
                }
            }
        }
        return buildSepList(s.length() - 1, canSeperate, s, dict);
        
    }
    
    private ArrayList<String> buildSepList(int end, boolean [] canSeperate, String s, Set<String> dict) {
        //go from right to left because canSeperate[i] indicates substring(0, i) can be separated
        ArrayList<String> res = new ArrayList<String>();
        if (dict.contains(s.substring(0, end+1))) {
            res.add(s.substring(0, end+1));
        }
        for (int i = end; i > 0; i--) {
            if (canSeperate[i-1] && dict.contains(s.substring(i, end+1))){
                ArrayList<String> tmp = buildSepList(i-1, canSeperate, s, dict);
                for (String sub : tmp) {
                    sub = sub + " " + s.substring(i, end+1);
                    res.add(sub);
                }
            }
        }
        return res;
    }
}
