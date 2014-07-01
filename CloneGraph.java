/*Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    //map original node to the cloned node
    HashMap<UndirectedGraphNode, UndirectedGraphNode> visited;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return cloneNode(node, visited);
    }
    
    public UndirectedGraphNode cloneNode(UndirectedGraphNode n, HashMap<UndirectedGraphNode, UndirectedGraphNode> visited) {
        if (n == null)
            return null;
        if (visited.containsKey(n)) {
            return visited.get(n);
        }
        else {
            UndirectedGraphNode res = new UndirectedGraphNode(n.label);
            visited.put(n, res);
            if (!n.neighbors.isEmpty()) {
                for (UndirectedGraphNode neig : n.neighbors) {
                    res.neighbors.add(cloneNode(neig, visited));
                }
            }
            return res;
        }
    }
    
}
