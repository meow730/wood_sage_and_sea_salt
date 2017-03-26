public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
  if (node == null) return null;
  UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
  Queue<UndirectedGraphNode> q = new LinkedList<>();
  HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();// label, new clone node
  map.put(node.label, ret);
  q.offer(node);

  while (!q.isEmpty()) {
    UndirectedGraphNode cur = q.poll();
    for (UndirectedGraphNode n : cur.neighbors ) {
      if (!map.containsKey(n.label)) {
        map.put(n.label, new UndirectedGraphNode(n.label));
        q.offer(n);
      }
      map.get(cur.label).neighbors.add(map.get(n.label));
    }
  }
  return ret;
}
