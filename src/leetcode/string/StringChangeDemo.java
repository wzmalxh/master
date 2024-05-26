package leetcode.string;

public class StringChangeDemo {
    public static String trans (String s, int n) {
        // write code here
        if(n == 0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i< n; i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append((char)(s.charAt(i) - 'a' + 'A'));
            }else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                sb.append((char)(s.charAt(i) - 'A' + 'a'));
            }else{
                sb.append(s.charAt(i));
            }
        }
        //大小写变换后反转
        sb = sb.reverse();
        System.out.println(sb.toString());
        //遍历找到空格
        for(int i=0; i< n; i++){
            int k = i;
            while(k <n && sb.charAt(k) != ' '){
                k++;
            }
            String temp = sb.substring(i,k);
            StringBuilder sbTemp = new StringBuilder(temp);
            temp = sbTemp.reverse().toString();
            System.out.println("temp is :"+temp);
            sb.replace(i,k,temp);
            i = k;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "This is a sample";
        int n = 16;
        System.out.println(trans(str,n));
    }
}
