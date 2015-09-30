/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together inedges.
*/

public boolean isTree(int[][] edges, int n) {
  List<Set<Integer>> adjMatrix = new ArrayList<Set<Integer>>();
  for (int i=0; i<n; i++) {
    adjMatrix.add(new HashSet<Integer>>();
  }
  //create adj matrix from edges
  for(int[] e : edges) {
    int from = e[0];
    int to = e[1];
    adjMatrix.get(from).add(to));
    adjMatrix.get(to).add(from));
  }

  //start from an arbitrary point
  int start = edges[0][0];

  Set<Integer> visited = new HashSet<Integer>();
  return dfsHelper(adjMatrix, int s, visited);
}

private boolean dfsHelper(List<Set<Integer>> adjMatrix, int s, Set<Integer> visited) {
  if (visited.contains(s)) {
    return false;
  }
  visited.add(s);
  Set<Integer> next = adjMatrix.get(s);
  for(int n : next) {
    adjMatrix.get(n).remove(s); //do not count same edge twice
    if (!dfsHelper(adjMatrix, n, visited)) {
      return false;
    }
  }
  visited.remove(s);
  return true;
  
}
