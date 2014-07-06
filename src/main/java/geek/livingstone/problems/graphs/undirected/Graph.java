package geek.livingstone.problems.graphs.undirected;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  int V;
  List<Integer>[] edges;
  int E;

  public Graph(int V) {
    this.V = V;
    edges = (List<Integer>[]) new List[V];
    for (int i = 0; i < V; i++) {
      edges[i] = new ArrayList<>();
    }
    E = 0;
  }

  public void addEdge(int u, int v) {
    assert u < V && v < V;
    edges[u].add(v);
    edges[v].add(u);
    E++;
  }

  public List<Integer> adj(int u) {
    return edges[u];
  }

  public int V() {
    return V;
  }
}
