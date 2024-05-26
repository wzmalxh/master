package leetcode;

import java.util.*;

public class GraphConnectivityDemoMyself {
    private Map<String, List<String>> graph = new HashMap<>();

    public GraphConnectivityDemoMyself(String[][] edges) {
        for (String[] edge : edges) {
            String s = edge[0];
            if (!graph.containsKey(s)) {
                List<String> sList = new ArrayList<>();
                sList.add(edge[1]);
                graph.put(s, sList);
            } else {
                List<String> list = graph.get(s);
                if (!list.contains(edge[1])) {
                    list.add(edge[1]);
                    graph.put(s, list);
                }
            }

            String t = edge[1];
            if (!graph.containsKey(t)) {
                List<String> sList = new ArrayList<>();
                sList.add(edge[0]);
                graph.put(t, sList);
            } else {
                List<String> list = graph.get(t);
                if (!list.contains(edge[0])) {
                    list.add(edge[0]);
                    graph.put(t, list);
                }
            }
        }
    }


    public boolean isConnected(String a, String b) {

        Set<String> visited = new HashSet<>();
        //查找是否存在一个a到b的路径
        if (!graph.containsKey(a) || !graph.containsKey(b)) {
            return false;
        }
        visited.add(a);
        List<String> graphNodes = graph.get(a);
        for (String str : graphNodes) {
            dfsNodes(str, b, visited);
        }
        if (visited.contains(b)) {
            return true;
        } else {
            return false;
        }
    }

    private void dfsNodes(String str, String b, Set<String> visited) {
        if (visited.contains(str)) {
            return;
        }
        visited.add(str);
        if (str.equals(b)) {
            visited.add(b);
            return;
        }
        for (String s : graph.get(str)) {
            dfsNodes(s, b, visited);
        }
    }

    public static void main(String[] args) {
        String[][] edges = {{"a", "b"}, {"b", "c"}, {"c", "d"}, {"e", "f"}};
        GraphConnectivityDemoMyself graph = new GraphConnectivityDemoMyself(edges);
        System.out.println(graph.isConnected("a", "d")); // 输出: true
        System.out.println(graph.isConnected("a", "e")); // 输出: false
    }
}
