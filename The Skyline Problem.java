public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<Edge> edges = new ArrayList<Edge>();
        for(int[] b : buildings) {
            Edge left = new Edge(b[0], b[2], true);
            Edge right = new Edge(b[1], b[2], false);
            edges.add(left);
            edges.add(right);
        }
        Collections.sort(edges, new Comparator<Edge>() {
           @Override
           public int compare(Edge e1, Edge e2) {
               if (e1.x != e2.x) {
                   return e1.x - e2.x;
               }
               if (e1.left != e2.left) {
                   if (e1.left) {
                       return -1;
                   }
                   return 1;
               }
               if (e1.left == true) { //left edge, higher one go in heap first
                   return e2.height - e1.height;
               } //right edge lower one go out heap first
               return e1.height - e2.height;
           }
        });
        List<int[]> result = new ArrayList<int[]>();
        PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder()); //max heap
        for(int i=0; i<edges.size(); i++) {
            Edge e = edges.get(i);
            if (e.left) {
                if (heightHeap.isEmpty() || e.height > heightHeap.peek()) {
                    result.add(new int[]{e.x, e.height});
                }
                heightHeap.add(e.height);
            } else {
                heightHeap.remove(e.height);
                if (heightHeap.isEmpty()) {
                    result.add(new int[]{e.x, 0});
                } else if (heightHeap.peek() < e.height) {
                    result.add(new int[]{e.x, heightHeap.peek()});
                }
            }
        }
        return result;
    }
}

class Edge {
    int x;
    int height;
    boolean left;
    public Edge(int x, int height, boolean left) {
        this.x = x;
        this.height = height;
        this.left = left;
    } 
}
