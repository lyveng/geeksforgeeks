package geek.livingstone.problems.graphs.directed;

public class DepthFirstDirectedPaths extends Paths {

  public DepthFirstDirectedPaths(Digraph G, int s) {
    super(G, s);
    dfs(G, s);
  }

  private void dfs(Digraph G, int u) {
    marked[u] = true;
    for (int v : G.adj(u))
      if (!marked[v]) {
        edgeTo[v] = u;
        dfs(G, v);
      }
  }
}
