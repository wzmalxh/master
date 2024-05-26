package javatest;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutPutTextFromCSVDemo {
    private static final String INPUT_TEXT = "/Users/wd/Desktop/csv.txt";
    private static final String OUTPUT_TEXT = "/Users/wd/Desktop/output.txt";

    public static void main(String[] args) throws Exception {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(INPUT_TEXT));
            writer = new BufferedWriter(new FileWriter(OUTPUT_TEXT));
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(parseColumn(line), writer);
            }
        } catch (IOException e) {
            throw new Exception("读取/写入文件异常", e);
        } finally {
            reader.close();
            writer.close();
        }
    }

    private static List<String> parseColumn(String brLine) {
        List<String> fieldList = new ArrayList<>();
        StringBuilder columnField = new StringBuilder();
        FileInputStream fis = null;
        //判断是否在引号内
        boolean flag = false;
        for (int i = 0; i < brLine.length(); i++) {
            char ch = brLine.charAt(i);
            System.out.println(ch);
            if (flag) {
                if (ch == '"') {
                    // 检查是否是转义的双引号
                    if (i + 1 < brLine.length() && brLine.charAt(i + 1) == '"') {
                        // 遍历到了csv引号，添加一个引号
                        columnField.append('"');
                        i += 1;
                    } else {
                        flag = false;
                    }
                } else {
                    columnField.append(ch);
                }
            } else {
                if (ch == '"') {
                    //遇到引号，进入下一轮判断
                    flag = true;
                    i++;
                } else if (i == brLine.length() - 1) {
                    String str = columnField.append(ch).toString();
                    fieldList.add(str);
                } else if (ch == ',') {
                    //不在引号范围内的逗号，切分字段
                    fieldList.add(columnField.toString());
                    columnField = new StringBuilder();
                } else {
                    columnField.append(ch);
                }
            }
        }
        return fieldList;
    }

    private static void processLine(List<String> fields, BufferedWriter writer) throws IOException {
        String str = "'";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (String field : fields) {
            try {
                //解析列为整数
                int intValue = Integer.parseInt(field);
                writer.write(String.valueOf(intValue));
            } catch (Exception e) {
                try {
                    //解析列为float
                    float floatValue = Float.parseFloat(field);
                    writer.write(String.valueOf(floatValue));
                } catch (NumberFormatException ex) {
                    //当前解析列属于日期
                    try {
                        Date date = sdf.parse(field);
                        writer.write(sdf.format(date));
                    } catch (ParseException pe) {
                        //解析列属于字符串
                        String resField = str + field + str;
                        writer.write(resField);
                    }
                }
            }
            //保存tab符
            writer.write("\t");
        }
        writer.newLine();
    }
}
