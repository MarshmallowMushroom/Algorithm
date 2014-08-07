/*
Using the KMP algorithm O(n) running time
*/
public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return haystack;
        int [] f = failure(needle); //get failure array
        int i = 0, j = 0;
        while(i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == f.length) {
                    return haystack.substring(i - f.length);
                }
            }
            else if (j > 0) {
                j = f[j];
            }
            else { // if j == 0, then match failed, increment i to start from beginning again
                j = 0;
                i++;
            }
        }
        return null;
    }
    
    public int [] failure(String needle) {
        int [] f = new int [needle.length()];
        if (needle.length() == 1) {
            f[0] = 0;
            return f;
        }
        f[0] = f[1] = 0; // first two elements always 0
        int k = 0; //next possible match
        for (int i = 1; i < f.length - 1; i++) {
            while (true) { 
                if (needle.charAt(k) == needle.charAt(i)) { // if there is a match
                    k++;
                    f[i + 1] = k;
                    break;
                }
                else if (k > 0) { // check next possible match
                    k = f[k];
                }
                else { //this has to be the last check, even if k = 0, we need to check if we have match or not, if no, execute this branch
                    f[i + 1] = 0;
                    break;
                }
            }
        }
        return f;
    }
}
