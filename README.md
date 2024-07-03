# KruskalsAlgorithm

An algorithm to find the minimum spanning tree of a weighted graph.

Spanning Tree is a subgraph that contains all the nodes of the graph.

Minimum Spanning tree is the subgraph whose summed weighted edges not larger than all other subgraphs.


1. Sort edges according to weight ascendingly. O(ElogE) 

2. Create disjoint sets for nodes. O(logN).

3. For each edge, if the nodes are in disjoint sets then they are part of the MST so add them to solution and merge disjoin sets that contain them. Otherwise ignore edge.