package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileStreamChannelDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("/Users/wd/Desktop/fileTest/didiInterview");
            fos = new FileOutputStream("/Users/wd/Desktop/didi2.txt");

            FileChannel fisChannel = fis.getChannel();

            FileChannel fosChannel = fos.getChannel();
            //创建文件缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while(fisChannel.read(buffer) != -1) {
                buffer.flip();
                fosChannel.write(buffer);
                // 清空缓冲区，准备下一次读取
                buffer.clear();
            }
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
