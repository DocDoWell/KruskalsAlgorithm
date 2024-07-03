package algorithm;

import graph.Edge;
import graph.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algorithm {

    public void run(List<Vertex> vertexList, List<Edge> edgeList) {
        DisjointSet disjointSet = new DisjointSet(vertexList);
        List<Edge> mst = new ArrayList<>();

        // use merge sort to sort the edges
        Collections.sort(edgeList);

        for(Edge edge : edgeList) {

            Vertex u = edge.getStart();
            Vertex v = edge.getTarget();

            // the edge is in the MST is the nodes are in different sets
            if(disjointSet.find(u.getNode()) != disjointSet.find(v.getNode())){
                mst.add(edge);
                disjointSet.union(u.getNode(), v.getNode());
            }
        }

        // we show the MST
        System.out.println("Edges in MST are:");
        for(Edge edge : mst)
            System.out.println(edge);
    }
}
