public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        //key here is to go from right to left
        int total = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            //if left > right, add
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i+1)))
                total += map.get(s.charAt(i));
            // if left < right, substract
            else
                total -= map.get(s.charAt(i));
        }
        return total;
    }
}
