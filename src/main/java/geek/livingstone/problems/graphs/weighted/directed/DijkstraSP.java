package geek.livingstone.problems.graphs.weighted.directed;

import java.util.LinkedList;
import java.util.List;

public class DijkstraSP {
  private boolean[] marked; // true if i is on SPT
  private IndexMinPQ<Integer> queue; // list of crossing edges.
  private int[] distTo;
  private DirectedEdge[] edgeTo;

  public DijkstraSP(EdgeWeightedDirectedGraph G, int s) {
    marked = new boolean[G.V()];
    queue = new IndexMinPQ<Integer>(G.V());
    distTo = new int[G.V()];
    edgeTo = new DirectedEdge[G.V()];
    for (int i = 0; i < distTo.length; i++) {
      distTo[i] = Integer.MAX_VALUE;
    }

    distTo[s] = 0;
    queue.insert(s, 0);
    while (!queue.isEmpty())
      relax(G, queue.deleteMin());
  }

  private void relax(EdgeWeightedDirectedGraph G, int u) {
    marked[u] = true;
    for (DirectedEdge e : G.adj(u))
    {
      int v = e.to();
      if (distTo[v] > distTo[u] + e.weight()) {
        distTo[v] = distTo[u] + e.weight();
        edgeTo[v] = e;
        if (queue.contains(v))
          queue.changeKey(v, distTo[v]);
        else
          queue.insert(v, distTo[v]);
      }
    }
  }

  public boolean hasPathTo(int u) {
    return edgeTo[u] != null;
  }

  public List<DirectedEdge> pathTo(int u) {
    if (!hasPathTo(u))
      return null;
    LinkedList<DirectedEdge> path = new LinkedList<DirectedEdge>();
    while (edgeTo[u] != null) {
      path.addFirst(edgeTo[u]);
      u = edgeTo[u].from();
    }
    return path;
  }
}
