package leetcode.string;


public class CharArrayCompress {
    public static int compress(char[] chars) {
        if(chars == null || chars.length == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int index = 0 ;
        int j = 0 ;
        while(cnt < chars.length) {
            int tmp = 0;
            char ch = chars[cnt];
            while(cnt < chars.length  && chars[cnt] == ch) {
                cnt++;
                tmp ++;
            }
            chars[index++] = ch;
            if(tmp != 1) {
                //将tmp转换为 char数组，循环写入原数组位置
                char []tmpChar = String.valueOf(tmp).toCharArray();
                for(int k=0; k< tmpChar.length; k++) {
                    chars[index ++] = tmpChar[k];
                }
            }
        }
       /* String result = sb.toString();
        char []resultChar = result.toCharArray();
        for(int i=0; i< resultChar.length; i++) {
            System.out.print(resultChar[i]+" ");
        }*/
        return index;
    }

    public static void main(String[] args) {
        char []chars = {'a','b','b','b','b','b','b'};
        int res = compress(chars);
        System.out.println(res);
        for(int i=0; i< res; i++) {
            System.out.print(chars[i]+ " ");
        }
    }
}
