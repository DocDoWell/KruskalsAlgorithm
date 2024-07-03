package algorithm;

import graph.Vertex;

import java.util.ArrayList;
import java.util.List;


public class DisjointSet {
    public DisjointSet(List<Vertex> vertexList) {
        makeSets(vertexList);
    }

    // find the representative (root node) for node 'node'
    public Node find(Node node) {
        Node root = node;

        // find the representative (root)
        while(root.getParent() != null)
            root = root.getParent();

        // "path compression" to make sure that next time we look for the
        // representative of the node we have O(1)

        while(node != root) {
            Node temp = node.getParent();
            node.setParent(root);
            node = temp;
        }

        return root;
    }

    // combine two sets
    public void union(Node node1, Node node2) {
        Node root1 = find(node1);
        Node root2 = find(node2);

        if(root1.equals(root2)){
            return;
        }

        // attach the smaller tree to the root of the larger tree "union by height"
        if(root1.getHeight() < root2.getHeight()) {
            root1.setParent(root2);
        } else if(root2.getHeight() < root1.getHeight()) {
            root2.setParent(root1);
        } else {
            root2.setParent(root1);
            root1.setHeight(root1.getHeight() + 1);
        }
    }

    private void makeSets(List<Vertex> vertexList) {
        for(Vertex vertex : vertexList){
            makeSet(vertex);
        }
    }

    private void makeSet(Vertex vertex) {
        Node node = new Node(0, null);
        vertex.setNode(node);
    }
}
