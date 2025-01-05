package outputstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        String filePath = "/Users/wd/Desktop/didi.txt"; // 替换为你的文件路径
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator()); // 添加行分隔符
            }
            byte[] byteArray = content.toString().getBytes("UTF-8"); // 使用正确的字符编码转换为字节数组

            // 可选：使用java nio包的Files类直接读取文件为字节数组
            // byte[] byteArray = Files.readAllBytes(Paths.get(filePath));

            // 输出字节数组的长度
            System.out.println("字节数组长度: " + byteArray.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
