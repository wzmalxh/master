package javatest;

import java.nio.ByteBuffer;

public class Buffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10); // 创建容量为10字节的ByteBuffer，初始处于写模式

        // 写模式下写入数据
        buffer.put((byte) 10);
        buffer.put((byte) 20);
        buffer.put((byte) 30);
        System.out.println("写模式下，position: " + buffer.position() + ", limit: " + buffer.limit());

        buffer.flip(); // 切换到读模式
        System.out.println("读模式下，position: " + buffer.position() + ", limit: " + buffer.limit());

        byte b = buffer.get();
        System.out.println("读取一个字节后，position: " + buffer.position() + ", limit: " + buffer.limit());

        byte[] readData = new byte[2];
        buffer.get(readData);
        System.out.println("再读取两个字节后，position: " + buffer.position() + ", limit: " + buffer.limit());
    }
}
