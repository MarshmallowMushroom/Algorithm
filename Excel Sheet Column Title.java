public class Solution {
    public String convertToTitle(int n) {
        //converting base 10 to base 26
        Map<Integer, Character> map = new HashMap<Integer, Character>();
        for (int i=0; i<26; i++) {
            map.put(i, (char)('A' + i));
        }
        StringBuilder result = new StringBuilder();
        while(n > 0) {
            n--; // becase usual convertion should start from 0, take a 26/27 for example.
            Character c = map.get(n%26);
            result.insert(0, c);
            n /= 26;
        }
        return result.toString();
    }
}
