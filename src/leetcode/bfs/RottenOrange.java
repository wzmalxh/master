package leetcode.bfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int row = grid.length;
        int column = grid[0].length;
        int countGoodOrange = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    countGoodOrange++;
                } else if (grid[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                }
            }
        }
        //将腐烂的橘子构建pair对，从队列中取出
        int result = 0;
        while (!queue.isEmpty() && countGoodOrange > 0) {
            result++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Pair<Integer, Integer> tmpPair = queue.poll();
                int r = tmpPair.getKey();
                int c = tmpPair.getValue();
                //分别向四个方向遍历，如果r c坐标上下左右位置有1，将其腐烂为2，并加入队列
                if (r + 1 < row && c < column) {
                    if (grid[r + 1][c] == 1) {
                        grid[r + 1][c] = 2;
                        countGoodOrange--;
                        queue.offer(new Pair<>(r + 1, c));
                    }
                }
                if (r < row && c - 1 >= 0) {
                    if (grid[r][c - 1] == 1) {
                        grid[r][c - 1] = 2;
                        countGoodOrange--;
                        queue.offer(new Pair<>(r, c - 1));
                    }
                }
                if (r < row && c + 1 < column) {
                    if (grid[r][c + 1] == 1) {
                        grid[r][c + 1] = 2;
                        countGoodOrange--;
                        queue.offer(new Pair<>(r, c + 1));
                    }
                }
                if (r - 1 >= 0 && c < column) {
                    if (grid[r - 1][c] == 1) {
                        grid[r - 1][c] = 2;
                        countGoodOrange--;
                        queue.offer(new Pair<>(r - 1, c));
                    }
                }
            }

        }
        return countGoodOrange > 0 ? -1 : result;
    }
}
