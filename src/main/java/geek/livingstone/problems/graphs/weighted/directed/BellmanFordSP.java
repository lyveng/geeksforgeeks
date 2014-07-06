package geek.livingstone.problems.graphs.weighted.directed;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BellmanFordSP {
  private Queue<Integer> queue;
  private boolean[] onQueue;
  private int start;
  private int[] distTo;
  private DirectedEdge[] edgeTo;
  private int cost;
  private boolean hasNegativeCycle;

  public BellmanFordSP(EdgeWeightedDirectedGraph G, int s) {
    start = s;
    queue = new LinkedList<>();
    onQueue = new boolean[G.V()];
    distTo = new int[G.V()];
    edgeTo = new DirectedEdge[G.V()];
    for (int i = 0; i < distTo.length; i++) {
      distTo[i] = Integer.MAX_VALUE;
    }
    cost = 0;
    hasNegativeCycle = false;

    distTo[s] = 0;
    queue.add(s);
    onQueue[s] = true;
    int v;
    while (!queue.isEmpty() && !hasNegativeCycle()) {
      v = queue.remove();
      onQueue[v] = false;
      relax(G, v);
    }
  }

  private boolean hasNegativeCycle() {
    return hasNegativeCycle;
  }

  private void relax(EdgeWeightedDirectedGraph G, int u) {
    for (DirectedEdge e : G.adj(u)) {
      int v = e.to();
      if (distTo[v] > distTo[u] + e.weight()) {
        distTo[v] = distTo[u] + e.weight();
        edgeTo[v] = e;
        if (!onQueue[v]) {
          queue.add(v);
          onQueue[v] = true;
        }
      }
      if (cost++ % G.V() == 0)
        findNegativeCycle();
    }
  }

  private void findNegativeCycle() {
    EdgeWeightedDirectedGraph g = new EdgeWeightedDirectedGraph(edgeTo.length);
    for (int i = 0; i < edgeTo.length; i++)
      if (edgeTo[i] != null)
        g.addEdge(edgeTo[i]);
    EdgeWeightedCycleFinder f = new EdgeWeightedCycleFinder(g);
    if (f.hasCycle())
      hasNegativeCycle = true;
  }

  public boolean hasPathTo(int u) {
    return edgeTo[u] != null;
  }

  public List<DirectedEdge> pathTo(int u) {
    if (!hasPathTo(u))
      return null;
    LinkedList<DirectedEdge> path = new LinkedList<>();
    while (edgeTo[u].from() != start) {
      path.addFirst(edgeTo[u]);
      u = edgeTo[u].from();
    }
    path.addFirst(edgeTo[u]);
    return path;
  }
}
