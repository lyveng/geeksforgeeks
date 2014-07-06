package geek.livingstone.problems.graphs.undirected;

public class Cycle {
  private boolean[] marked;
  private boolean hasCycle;
  public Cycle(Graph G) {
    marked = new boolean[G.V()];
    hasCycle = false;
    for (int u = 0 ; u < G.V(); u++)
      if (!marked[u])
        dfs(G, u, u);
  }

  private void dfs(Graph G, int v, int u) {
    marked[v] = true;
    for (int w : G.adj(v))
      if (!marked[w])
        dfs(G, w, v);
      else if (w != u)
        hasCycle = true;
  }

  public boolean hasCycle() {
    return hasCycle;
  }
}
