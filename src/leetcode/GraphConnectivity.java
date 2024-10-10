package leetcode;

import java.util.*;

public class GraphConnectivity {
    private Map<String, List<String>> graph;

    public GraphConnectivity(String[][] edges) {
        graph = new HashMap<>();
        for (String[] edge : edges) {
            String node1 = edge[0];
            String node2 = edge[1];
            graph.putIfAbsent(node1, new ArrayList<>());
            graph.putIfAbsent(node2, new ArrayList<>());
            graph.get(node1).add(node2);// 因为是无向图，所以两个方向都要添加
            graph.get(node2).add(node1);
        }
    }

    public boolean isConnected(String a, String b) {
        if (!graph.containsKey(a) || !graph.containsKey(b)) {
            return false; // 如果a或b不在图中，它们肯定不连通
        }
        Set<String> visited = new HashSet<>();
        return dfs(a, b, visited);
    }

    private boolean dfs(String current, String target, Set<String> visited) {
        if (current.equals(target)) {
            return true; // 找到目标节点，返回true
        }
        visited.add(current);
        List<String> nodeList = graph.get(current);
        if(nodeList != null){
            for (String neighbor : nodeList) {
                //没有被访问过，继续深度优先
                if (!visited.contains(neighbor)) {
                    if (dfs(neighbor, target, visited)) {
                        return true; // 在邻居节点中找到目标节点，返回true
                    }
                }
            }
        }
        return false; // 没有找到目标节点，返回false
    }

    public static void main(String[] args) {
        String[][] edges = {{"a", "b"}, {"b", "c"}, {"c", "d"}, {"e", "f"}};
        int []n = {0};
        GraphConnectivity graph = new GraphConnectivity(edges);
        System.out.println(graph.isConnected("a", "d")); // 输出: true
        System.out.println(graph.isConnected("a", "e")); // 输出: false
    }
}
