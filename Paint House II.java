	public int minCost(int[][] costs) {
		int n = costs.length;
		int k = costs[0].length;
		PriorityQueue<Pair>[] pairs = new PriorityQueue[n];
		for (int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				if (i==0) {
					Pair p = new Pair(j, costs[i][j]);
					insertMin(p, pairs[i]);
				} else {
					Pair lastMin2 = pairs[i-1].poll(); //second smallest
					Pair lastMin1 = pairs[i-1].poll(); //first smallest
					Pair p = null;
					if (j == lastMin1.color) {
						p = new Pair(j, costs[i][j] + lastMin2.cost);
					} else {
						p = new Pair(j, costs[i][j] + lastMin1.cost);
					}
					insertMin(p, pairs[i]);
				}
			}
		}
		pairs[n-1].poll();
		return pairs[n-1].poll().cost;
	}
	private void insertMin(Pair p, PriorityQueue<Pair> queue) {
		queue.add(p);
		if (queue.size() > 2) {
			queue.remove();
		}
	}
