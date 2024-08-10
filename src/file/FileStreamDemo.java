package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
             fis = new FileInputStream("/Users/wd/Desktop/fileTest/didiInterview");
             fos = new FileOutputStream("/Users/wd/Desktop/didi.txt");

             //创建文件缓冲区
            byte[] buffer = new byte[2048];
            int br = 0;
            while((br = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, br);
            }
            // 刷新输出流，确保所有数据都被写出
            fos.flush();

            System.out.println("文件复制成功！");

        }catch (FileNotFoundException e){
            System.out.println("无法找到文件");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(fis != null) {
                    fis.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }


            try{
                if(fos != null) {
                    fos.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
