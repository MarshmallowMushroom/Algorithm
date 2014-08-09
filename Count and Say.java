public class Solution {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");
        if (n == 1)
            return new String(result);
        for (int i = 0; i < n - 1; i++)
            result = count(result);
        return new String(result);
    }
    
    public StringBuilder count(StringBuilder input) {
        StringBuilder result = new StringBuilder();
        input.append("#"); //append a special character so that last comparison will be false
        char prev = input.charAt(0);
        int count = 1;
        for(int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == prev) {
                count++;
            }
            else {
                result.append(Integer.toString(count));
                result.append(Character.toString(prev));
                count = 1;
            }
            prev = input.charAt(i);
        }
        return result;
    }
}
