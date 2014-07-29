public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] result = new int [2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int curr = numbers[i];
            if (map.containsKey(target - curr)) {
                result[0] = map.get(target - curr) + 1;
                result[1] = i + 1;
                return result;
            }
            else {
                map.put(curr, i);
            }
        }
        return result;
    }
}
