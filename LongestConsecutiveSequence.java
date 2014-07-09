/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            }
            else {
                map.put(n, 1);
            }
        }
        int max = 0;
        for (int n : num) {
            //if current element has not been checked
            if (map.get(n) > 0) {
                int currMax = 1;
                //search left and right to extend the sequence as far as possible
                int next = n+1;
                while(map.containsKey(next) && map.get(next) > 0) {
                    currMax++;
                    map.put(next, 0);
                    next++;
                }
                next = n-1;
                while(map.containsKey(next) && map.get(next) > 0) {
                    currMax++;
                    map.put(next, 0);
                    next--;
                }
                max = Math.max(max, currMax);
            }
        }
        return max;
    }
}
