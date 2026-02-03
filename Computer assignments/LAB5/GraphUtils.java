import java.util.*;

public class GraphUtils<T> {

    /* 
     * The time complexity for my findReachableNodes method is O(2n) with n being the number of nodes
     * in the graph, as the method calls the method DFS twice.
     * I first check if the graph is empty, if it is I return null. Else, I create two empty 
     * Hashsets that will be used as parameters for my DFS (Deapth First Search) method. 
     * I then create two Hashsets using my DFS method, one for A and one for B, which stores all
     * the nodes that I can traverse from A (Set NodesOfA) and B (Set NodesOfB). I then go over 
     * the set A and compare the two sets, NodesOf A and NodesOfB. If they share a same node, I 
     * add it to a Hashset (NodesOfAandB). I then return NodesOfAandB, a Hashset of nodes
     * which is reachable from A and B.
     */
    public static <T> Set<T> findReachableNodes(Graph<T> graph, T a, T b){
       // implement your method here
        if (graph == null){
            return null;
        }else{
            Set<T> emptyA = new HashSet<T>();
            Set<T> emptyB = new HashSet<T>();
            // neighbor nodes of A
            Set<T> NodesOfA = DFS(graph, a, emptyA);
            // neighbor nodes of B
            Set<T> NodesOfB = DFS(graph, b, emptyB);
            // nodes shared by A and B
            Set<T> NodesOfAandB = new HashSet<T>();
            
            for (T node : NodesOfA){
                if (NodesOfA.contains(NodesOfB)){
                    NodesOfAandB.add(node);
                }
            }
        return NodesOfAandB;
        }
    }
    
    /*
     * The time complexity for my DFS method is O(n) with n being the number of vertices in the graph,
     * as the method goes through each node in the graph once and goes through its neighbors.
     * My method takes as input a graph, a starting node A and an empty hashset visitedNodes.
     * It loops through the graphs and checks the neighbors of the starting node and adds them
     * to the visitedNodes hashset. It then calls the method recursively with the next node in the graph.
     * The output is the hashset visitedNodes.
     */
    public static <T> Set<T> DFS(Graph<T> graph, T A, Set<T> visistedNodes){

        for (T nextNode : graph.neighbors(A)){
        visistedNodes.add(A);
        DFS(graph, nextNode, visistedNodes);
        }
        return visistedNodes;
    }
}
