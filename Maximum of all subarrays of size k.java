/*
Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

Examples:

Input :
arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6

Input :
arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
k = 4
Output :
10 10 10 15 15 90 90
*/

public ArrayList<Integer> maxInSubarray(ArrayList<Integer> array, int k) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Deque<Integer> queue = new LinkedList<Integer>();
    //first k element
    for (int i = 0; i < array.size(); i++) {
        int ele = array.get(i);
        while(!queue.isEmpty() && queue.peekLast() < ele) {
            queue.removeLast();
        }
        queue.addLast(ele);
        if (queue.size() > k) // if the queue is full, pop first element
            queue.removeFirst();
        if (i >= k-1) // only record result when we reached the first window, that is when i = k - 1;
        	result.add(queue.peekFirst());
    }
    return result;
}
