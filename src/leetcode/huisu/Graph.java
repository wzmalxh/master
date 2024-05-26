package leetcode.huisu;

import leetcode.GraphConnectivity;

import java.util.*;

public class Graph {

    private final Map<String, Set<String>> gr;


    public Graph(String[][] edges) {
        gr = new HashMap<>();
        for (String[] edge : edges) {
            String node1 = edge[0];
            String node2 = edge[1];
            gr.putIfAbsent(node1, new HashSet<>());
            gr.putIfAbsent(node2, new HashSet<>());
            gr.get(node1).add(node2);// 因为是无向图，所以两个方向都要添加
            gr.get(node2).add(node1);// 因为是无向图，所以两个方向都要添加

        }
    }

    public boolean isConnection(String a,String b){
        if(!gr.containsKey(a) || !gr.containsKey(b)){
            return false;
        }
        Set<String> visit = new HashSet<>();
        return dfs(a,b,visit);
    }
    public boolean dfs(String a, String b, Set<String> visited){
        visited.add(a);
        if(a.equals(b)){
            return  true;
        }
        Set<String> arrayList = gr.get(a);
        for(String cc : arrayList){
            if(!visited.contains(cc)){
                if (dfs(cc,b,visited)){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String[][] edges = {{"a", "b"}, {"b", "c"}, {"c", "d"}, {"e", "f"}};
        Graph graph = new Graph(edges);
        System.out.println(graph.isConnection("a", "d")); // 输出: true
        System.out.println(graph.isConnection("a", "e")); // 输出: false
    }
}
