package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class ZOrderString {
    public static void main(String[] args) {

        String str = "PAYPALISHIRING";
        System.out.println(convertZString("AB",1));
    }

    public static String convert(String s, int numRows) {
        char[][] array = new char[Math.min(numRows, s.length())][];
        for (int i = 0; i < array.length; i++) {
            // 假设每行最多包含s.length()个字符
            array[i] = new char[s.length()];
        }
        int k = 0;
        int j= 0;
        boolean flag = false;
        for(char c : s.toCharArray()){
            array[j][k] = c;
            if(j == 0 || j == numRows -1){
                flag = !flag;
            }
            j += flag ? 1 : -1;
            //如果不是第一行，更新列指标
            if (j > 0) {
                k++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < numRows; i++){
            for( j=0; j < k; j++){
                if(array[i][j] != 0){
                    sb.append(array[i][j]);
                }
            }
        }
        return sb.toString();
    }


    public static String convertNew(String s, int numRows) {
        if (numRows <= 1 || s.length() == 0) {
            return s; // 如果只有一行或字符串为空，则直接返回
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder()); // 为每一行创建一个 StringBuilder
        }

        int currRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c); // 在当前行添加字符

            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown; // 到达第一行或最后一行时改变方向
            }

            currRow += goingDown ? 1 : -1; // 根据方向移动
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }



    public static String convertZString(String s, int numRows) {
        if (numRows <= 1 || s.length() == 0) {
            return s; // 如果只有一行或字符串为空，则直接返回
        }

        // 初始化二维字符数组
        char[][] matrix = new char[Math.min(numRows, s.length())][];
        for (int i = 0; i < matrix.length; i++) {
            // 假设每行最多包含s.length()个字符
            matrix[i] = new char[s.length()];
        }

        int currRow = 0;
        boolean goingDown = false;
        int col = 0; // 跟踪二维数组的列索引

        for (char c : s.toCharArray()) {
            // 将字符放入当前行
            matrix[currRow][col] = c;

            // 更新当前行索引
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;

            // 如果不是第一行，且当前列已有字符，则需要更新列索引
            if (currRow > 0 && matrix[currRow - 1][col] != 0) {
                col++;
            }
        }

        // 构造结果字符串
        StringBuilder result = new StringBuilder();
        for (char[] row : matrix) {
            for (char c : row) {
                if (c != 0) { // 跳过没有字符的位置
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
