package geek.livingstone.problems.graphs.weighted.directed;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDirectedGraph {
  private int V;
  private List<DirectedEdge>[] adj;

  public EdgeWeightedDirectedGraph(int v) {
    super();
    V = v;
    adj = (List<DirectedEdge>[]) new List[V];
    for (int i = 0; i < adj.length; i++) {
      adj[i] = new ArrayList<>();
    }
  }

  public void addEdge(int u, int v, int weight) {
    assert u < V && v < V;
    adj[u].add(new DirectedEdge(u, v, weight));
  }

  public void addEdge(DirectedEdge e) {
    assert e.from() < V && e.to() < V;
    adj[e.from()].add(e);
  }

  public List<DirectedEdge> adj(int u) {
    return adj[u];
  }

  public int V() {
    return V;
  }
}
