public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //this record out nodes
        Map<Integer, Set<Integer>> adjMatrix = new HashMap<Integer, Set<Integer>>();
        //this record the indegree of each node
        Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
        //setup the adjMatrix and inDegree
        for(int i=0; i<prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            if (adjMatrix.containsKey(from)) {
                //this is to deal with double edge with same from and same to
                //dont count in degree twice
                if (adjMatrix.get(from).contains(to)) {
                    inDegree.put(to, inDegree.get(to)-1);
                }
                adjMatrix.get(from).add(to);
            } else {
                Set<Integer> s = new HashSet<Integer>();
                s.add(to);
                adjMatrix.put(from, s);
            }
            if (inDegree.containsKey(to)) {
                inDegree.put(to, inDegree.get(to)+1);
            } else {
                inDegree.put(to, 1);
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        //bfs queue
        Queue<Integer> queue = new LinkedList<Integer>(); 
        //find the starting point
        for(int i=0; i<numCourses; i++) {
            if (!inDegree.containsKey(i)) {
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()) {
            //update inDegree map
            int out = queue.remove();
            if (adjMatrix.get(out) != null) {
                for(int node : adjMatrix.get(out)) {
                    int deg = inDegree.get(node);
                    if (deg == 1) { // in degree will be 0 after this bfs
                        inDegree.remove(node);
                        queue.add(node);
                    } else {
                        inDegree.put(node, deg-1);
                    }
                }
            }
            result.add(out);
        }
        if (result.size() != numCourses) {
            return new int[0];
        }
        //convert to array
        int[] rtn = new int [numCourses];
        for (int i=0; i<numCourses; i++) {
            rtn[i] = result.get(i);
        }
        return rtn;
    }
}
