package geek.livingstone.problems.graphs.undirected;


public class DepthFirstPaths extends Paths {


  public DepthFirstPaths(Graph G, int s) {
    super(G, s);
    dfs(G, s);
  }

  private void dfs(Graph G, int u) {
    marked[u] = true;
    for (int v : G.adj(u))
      if (!marked[v]) {
        edgeTo[v] = u;
        dfs(G, v);
      }
  }
}
