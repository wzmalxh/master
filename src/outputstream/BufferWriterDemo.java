package outputstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterDemo {
    public static void main(String[] args) {
        try {
            // 创建BufferedWriter对象，用于写入文件
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/wd/Desktop/testDemo.txt"));

            // 模拟接口返回的数据，通常这些数据来自于接口的实现类
            String[][] data = {
                    {"表头1", "表头2", "表头3"},
                    {"数据1", "数据2", "数据3"},
                    {"数据4", "数据5", "数据6"}
            };

            // 写入数据到文件
            for (String[] row : data) {
                for (String cell : row) {
                    writer.write(cell);
                    writer.write(" ");
                }
                writer.newLine(); // 写入一行结束
                writer.newLine(); // 表格之间空两行
            }

            // 关闭writer
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
