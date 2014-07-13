public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        return helper(s, 4);
    }
    
    private ArrayList<String> helper(String s, int level) {
        ArrayList<String> result = new ArrayList<String>();
        if (s.length() < level || s.length() > level * 3) {
            return result;
        }
        if (level == 1 && isValidIp(s)) {
            result.add(s);
            return result;
        }
        for (int i = 0; i < s.length() && i < 3; i++) {
            if (isValidIp(s.substring(0, i+1))) {
                ArrayList<String> next = helper(s.substring(i+1, s.length()), level - 1);
                for (String sub : next) {
                    String tmp = s.substring(0, i+1) + "." + sub;
                    result.add(tmp);
                }
            }
        }
        return result;
    }
    
    private boolean isValidIp(String s) {
        try {
            int tmp = Integer.parseInt(s);
            if (tmp > 255 || tmp < 0)
                return false;
            //0 need to be treated specially because 00 is not allowed
            if (tmp == 0) {
                return s.length() == 1;
            }
            // 010 is not allowed
            else {
                return s.charAt(0) != '0';
            }
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }
}
