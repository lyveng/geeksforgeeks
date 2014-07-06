package geek.livingstone.problems.graphs.undirected;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths extends Paths {
  public BreadthFirstPaths(Graph G, int s) {
    super(G, s);
    bfs(G, s);
  }

  private void bfs(Graph G, int s) {
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    while (!q.isEmpty()) {
      int u = q.remove();
      for (int v : G.adj(u))
        if (!marked[v])
        {
          q.add(v);
          edgeTo[v] = u;
          marked[v] = true;
        }
    }
  }
}
