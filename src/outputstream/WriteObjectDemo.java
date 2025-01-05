package outputstream;

import java.io.*;

public class WriteObjectDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Person p = new Person();
        p.setAge(10);
        p.setName("Wangning");
        p.setAddress("278582065@qq.com");
        FileOutputStream fileOut1 = new FileOutputStream("/Users/wd/Desktop/person.txt");
        try  {
            FileOutputStream fileOut = new FileOutputStream("data.ser");
            OutputStreamWriter writer = new OutputStreamWriter(fileOut, "UTF-8");
           /* ObjectOutputStream out = new ObjectOutputStream();
            out.writeObject(p);
            out.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fileOut1 != null) {
                try {
                    fileOut1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
