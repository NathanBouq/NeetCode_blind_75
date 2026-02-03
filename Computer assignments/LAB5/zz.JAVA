import java.util.*;

public class zz {
    public static void main(String[] args) {
        int arr [] = new arr {1, 2, 3 ,4, 5};
        Set<T> NodesOfAandB = new HashSet<T>();
        for (T hello : )

    }
    public static <T> Set<T> DFS(Graph<T> graph, T A, Set<T> visistedNodes){

        for (T nextNode : graph.neighbors(A)){
        visistedNodes.add(A);
        DFS(graph, nextNode, visistedNodes);
        }
        return visistedNodes;
    }
}