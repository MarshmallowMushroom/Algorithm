public class LRUCache {
    HashMap<Integer, dListNode> map ;
    int max;
    int cap;
    dListNode head, tail;
   
    public LRUCache(int capacity) {
        max = capacity;
        map = new HashMap<Integer, dListNode>();
        head = new dListNode(-1, -1);
        tail = new dListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int res = map.get(key).value;
        dListNode n = map.get(key);
        //disconnect the node 
        n.next.prev = n.prev;
        n.prev.next = n.next;
        //move to the head
        dListNode tmp = head.next;
        head.next = n;
        n.prev = head;
        n.next = tmp;
        tmp.prev = n;
        return res;
    }
    
    public void set(int key, int value) {
        dListNode n;
        if (map.containsKey(key)) {
            n = map.get(key);
            n.value = value;
            //disconnect the node 
            n.next.prev = n.prev;
            n.prev.next = n.next;
            //move to the head
            dListNode tmp = head.next;
            head.next = n;
            n.prev = head;
            n.next = tmp;
            tmp.prev = n;
        }
        else {
            n = new dListNode(key, value);
            if (cap < max) {
                cap++;
            } else {
                //remove from tail
                dListNode tmp = tail.prev;
                tail.prev = tmp.prev;
                tmp.prev.next = tail;
                map.remove(tmp.key);
            }
            //move to the head
            dListNode tmp = head.next;
            head.next = n;
            n.prev = head;
            n.next = tmp;
            tmp.prev = n;
            map.put(key, n);
        }
    }
    
    public class dListNode {
        int key, value;
        dListNode prev, next;
        public dListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

