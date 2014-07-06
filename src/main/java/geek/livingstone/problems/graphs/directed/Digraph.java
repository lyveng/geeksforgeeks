package geek.livingstone.problems.graphs.directed;

import java.util.ArrayList;
import java.util.List;

public class Digraph {
  int V;
  List<Integer>[] edges;
  int E;

  public Digraph(int V) {
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
    E++;
  }

  public List<Integer> adj(int u) {
    return edges[u];
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }
}
