package geek.livingstone.problems.graphs.undirected;

public class TwoColor {
  private boolean[] marked;
  private boolean[] color;
  private boolean isTwoColorable;

  public TwoColor(Graph G) {
    marked = new boolean[G.V()];
    color = new boolean[G.V()];
    isTwoColorable = true;
    for (int s = 0; s < G.V(); s++)
      if (!marked[s])
        dfs(G, s);
  }

  private void dfs(Graph G, int u) {
    marked[u] = true;
    for (int v : G.adj(u))
      if (!marked[v]) {
        color[v] = !color[u];
        dfs(G, v);
      } else if (color[v] == color[u])
        isTwoColorable = false;
  }

  public boolean isTwoColorable() {
    return isTwoColorable;
  }
}
