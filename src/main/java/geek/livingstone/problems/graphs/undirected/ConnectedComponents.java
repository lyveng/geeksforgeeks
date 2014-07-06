package geek.livingstone.problems.graphs.undirected;

public class ConnectedComponents {
  private int[] id;
  private boolean[] marked;
  private int count;

  public ConnectedComponents(Graph G) {
    id = new int[G.V()];
    marked = new boolean[G.V()];
    count = 0;
    for (int i = 0; i < G.V(); i++)
      if (!marked[i]) {
        dfs(G, i);
        count++;
      }
  }

  private void dfs(Graph G, int u) {
    marked[u] = true;
    id[u] = count;
    for (int v : G.adj(u))
      if (!marked[v])
        dfs(G, v);
  }

  public boolean connected(int u, int v) {
    return id[u] == id[v];
  }

  public int count() {
    return count;
  }

  public int id(int u) {
    return id[u];
  }
}
