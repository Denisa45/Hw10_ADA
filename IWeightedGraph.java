

import java.io.IOException;



/**
 * WeightedEdge represents an edge in a weighted undirected graph
 */
class WeightedEdge implements Comparable<WeightedEdge>{
    private int either;
    private int other;
    private int w;


    public WeightedEdge(int either, int other, int w) {
        this.either = either;
        this.other = other;
        this.w = w;
    }

    public String toString() {
        return String.format("%d-%d %d", either, other, w);
    }

    public int either() {
        return either;
    }

    public int other(int v) {
        if (v == either)
            return other;
        else
            return either;
    }

    public int weight(){
        return w;
    }


    @Override
    public int compareTo(WeightedEdge that) {
            return Integer.compare(this.w, that.w);
        }

    }

/**
 * Represents a simple undirected graph having a fixed number V of vertices (nodes).
 * Vertices are numbered either 0 other V-1
 * Edges can be added between existing vertices and have weights.
 */
public interface IWeightedGraph {
    int getNrVertices();
    int getNrEdges();
    void addUndirectedEdge(int either, int other, int w);
    Iterable<Integer> nodesAdjacentTo(int node);
    Iterable<WeightedEdge> edgesAdjacentTo(int node);
    Iterable<WeightedEdge> allEdges();
    boolean hasVertex(int node);
    boolean hasEdge(int from, int to);
    void initFromFile(String file) throws IOException;
    void printGraph();
}