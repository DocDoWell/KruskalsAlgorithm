package graph;

public class Edge implements Comparable<Edge> {

    private double weight;
    private Vertex start;
    private Vertex target;

    public Edge(Vertex start, Vertex target, double weight) {
        this.weight = weight;
        this.start = start;
        this.target = target;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getTarget() {
        return target;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return start + " ------ " + weight +" -------> " + target;
    }
}
