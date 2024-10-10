package graph;

import java.util.*;

public class CourseTableDemo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        if (numCourses <= 0) {
            return new int[0];
        }
        int[]inDegrees = new int[numCourses];
        //构建图元素
        Map<Integer,HashSet<Integer>> orderGraph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            orderGraph.put(i,new HashSet<Integer>());
        }
        for(int i=0; i< prerequisites.length; i++) {
            orderGraph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegrees[prerequisites[i][0]] ++;
        }
        int []result = new int[numCourses];
        boolean []visited = new boolean[numCourses];
        for(int k=0; k< numCourses; k++) {
            visited[k] = false;
        }
        int count = 0;
        for(int i= 0; i< numCourses; i++) {
            if(inDegrees[i] == 0 && !visited[i]) {
                queue.offer(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()) {
            int top = queue.poll();
            result[index++] = top;
            visited[top] = true;
            count++;
            Set<Integer> valueSet = orderGraph.get(top);
            if(valueSet != null) {
                for(Integer ele:valueSet) {
                    inDegrees[ele] --;
                    if(inDegrees[ele] == 0 && !visited[ele]) {
                        queue.offer(ele);
                    }
                }
            }
        }
        if(count == numCourses) {
            //统计值和结果相等，返回result
            return result;
        }
        return new int[0];

    }
}
