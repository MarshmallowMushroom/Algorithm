public class Solution {
    public int nthUglyNumber(int n) {
        Deque<Long> q2 = new LinkedList<Long>();
        Deque<Long> q3 = new LinkedList<Long>();
        Deque<Long> q5 = new LinkedList<Long>();
        q2.addLast(2L);
        q3.addLast(3L);
        q5.addLast(5L);
        
        long result = 1;
        for(int i=1; i<n; i++) {
            result=Math.min(q2.getFirst(), Math.min(q3.getFirst(), q5.getFirst()));
            if (result == q2.getFirst()) {
                q2.removeFirst();
                q2.addLast(result * 2);
                q3.addLast(result * 3);
                q5.addLast(result * 5);
            } else if (result == q3.getFirst()) {
                q3.removeFirst();
                q3.addLast(result * 3);
                q5.addLast(result * 5);
            } else if (result == q5.getFirst()) {
                q5.removeFirst();
                q5.addLast(result * 5);
            }
        }
        return (int)result;
    }
}
