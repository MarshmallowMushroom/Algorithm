public class Node implements Comparable{
  int dist;
  int val;
  public Node (int v, int d) {
    this.dist = d;
    this.val = v;
  }
  @Override
  public int compareTo(Node another) {
    return Math.abs(this.dist).compareTo(Math.abs(another.dist));
  }
}

public List<Integer> findClosest (TreeNode root, int target, int k) {
  PriorityQueue<Node> heap = new PriorityQueue<Node>(10, Collections.reverseOrder());
  findHelper(root, target, heap, k);
  List<Integer> list = new ArrayList<Integer>();
  while(!heap.isEmpty()) {
    list.add(heap.poll().val);
  }
  return res; 
}

private void findHelper(TreeNode root, int target, PriorityQueue<Node> heap, int k) {
  if (root == null) {
    return;
  }
  Node n = new Node(root.val, root.val-target);
  insertHeap(k, heap, n);
  findHelper(root.left, target, heap, k);
  findHelper(root.right, target, heap, k);
}

private void insertHeap(int k, PriorityQueue<Node> heap, Node n) {
  heap.add(n);
  if (heap.size() >= k) {
    heap.poll();
  }
}
