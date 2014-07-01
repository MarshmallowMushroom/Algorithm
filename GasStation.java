/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //first figure out if we could finish a circle.
        //if total number of gas is greater than the total number of cost, then we can finish the circle starting at some point
        int total = 0;
        int [] diff = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
            total += diff[i];
        }
        if (total < 0)
            return -1;
        // if can finish, we find the place where we have the most left over gas (since the solution is guaranteed to be unique)
        int start = 0;
        int sum = 0;
        //if at point i diff drops below 0, then the start point should be the next.
        for(int i = 0; i < diff.length; i++) {
            sum += diff[i];
            if (sum < 0) {
                sum = 0;
                start = i+1;
            }
        }
        return start;
    }
}
