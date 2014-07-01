/*There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

public class Solution {
    public int candy(int[] ratings) {
        //scan from right to left to make sure that child at position i have more candy if he/she havs higher rating then left child
        int [] candy = new int [ratings.length];
        for (int i = 1; i < candy.length; i++) {
            if (ratings[i-1] < ratings[i])
                candy[i] = candy[i-1] + 1;
        }
        //scan from right to left to make sure that child at position i have more candy if he/she havs higher rating then right child
        for (int i = candy.length-2; i>= 0; i--) {
            if (ratings[i+1] <ratings[i])
                candy[i] = Math.max(candy[i], candy[i+1] + 1);
        }
        //sum up all candies plus 1 for one candy for every child.
        int total = 0;
        for (int i : candy) {
            total += i + 1;
        }
        return total;
    }
}
