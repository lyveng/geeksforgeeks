package geek.livingstone.problems.graphs.directed;

public class DirectedDFS {
  private boolean[] marked;

  public DirectedDFS(Digraph G, int s) {
    marked = new boolean[G.V()];
    dfs(G, s);
  }

  public DirectedDFS(Digraph G, Iterable<Integer> sources) {
    marked = new boolean[G.V()];
    for (int s : sources)
      if (!marked[s])
        dfs(G, s);
  }

  private void dfs(Digraph G, int u) {
    marked[u] = true;
    for (int v : G.adj(u))
      if (!marked[v])
        dfs(G, v);
  }

  public boolean isReachable(int u) {
    return marked[u];
  }
}
