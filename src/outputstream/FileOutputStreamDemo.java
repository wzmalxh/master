package outputstream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        OutputStream out = System.out;
        FileOutputStream fos = new FileOutputStream("/Users/wd/Desktop/didi.txt");
        String path = "/Users/wd/Desktop/didi.txt"; // 替换为你的文件路径
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("1");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String args[]) throws Exception {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(new File("/Users/wd/Desktop/didi.txt"));
            out = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024 * 8];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
            System.out.println(out.toString("UTF-8"));//使用GBK编码转换成字符串
        } catch (FileNotFoundException e) {
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
            }
        }
    }*/


}
