package geek.livingstone.problems.graphs.weighted.directed;


public class EdgeWeightedCycleFinder {
  private boolean[] marked;
  private boolean[] onStack;
  private boolean hasCycle;

  public EdgeWeightedCycleFinder(EdgeWeightedDirectedGraph G) {
    marked = new boolean[G.V()];
    onStack = new boolean[G.V()];
    for (int s = 0; s < G.V(); s++)
      if (!marked[s])
        dfs(G, s);
  }

  private void dfs(EdgeWeightedDirectedGraph G, int u) {
    onStack[u] = true;
    for (DirectedEdge e : G.adj(u)) {
      int v = e.to();
      if (hasCycle())
        return;
      if (!marked[v])
        dfs(G, v);
      else if (onStack[v])
        hasCycle = true;
    }
    onStack[u] = false;
  }

  public boolean hasCycle() {
    return hasCycle;
  }
}
