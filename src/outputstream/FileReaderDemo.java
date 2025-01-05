package outputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try {
            File file1 = new File("/Users/wd/Desktop/didi.txt");
            FileReader fileReader = new FileReader(file1);
            char[] c=new char[1024];               //创建一个字符数组，由于长度未知，可暂时设定为1024，如不够，再尝试其他长度。
            int length=0;
            while((length=fileReader.read(c))!=-1)
            {
                String data=new String(c,0,length);
                System.out.print(data);
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
