/* this is relatively easy because you do not need to deal with duplicate */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length - 2; i++) {
            int tmp = num[i] + twoSumClosest(num, target - num[i], i + 1);
            if (Math.abs(target - tmp) < Math.abs(target - result))
                result = tmp;
        }
        return result;
    }
    
    public int twoSumClosest(int[] num, int target, int start) {
        int result = num[start] + num[start + 1]; //record the closest num to the target
        int s = start;
        int e = num.length - 1;
        while(s < e) {
            if (Math.abs(target - num[s] - num[e]) < Math.abs(target - result)) {
                result = num[s] + num[e];
            }
            if (num[s] + num[e] == target) {
                return target;
            }
            else if (num[s] + num[e] < target) {
                s++;
            }
            else {
                e--;
            }
            
        }
        return result;
    } 
}
