/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //a map that maps a list node in the original list to the node in the new list
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        //helper that points to a new node
        RandomListNode helper = new RandomListNode(-1);
        RandomListNode p = helper;
        RandomListNode h = head;
        while(h != null) {
            p.next = new RandomListNode(h.label);
            p = p.next;
            map.put(h, p);
            h = h.next;
        }
        //scan the new list again to copy the random pointers
        p = helper.next;
        h = head;
        while(p != null) {
            p.random = map.get(h.random);
            p = p.next;
            h = h.next;
        }
        return helper.next;
    }
}
