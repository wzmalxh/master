package leetcode.string;

public class LastStringLength {
    public static int lengthOfLastWord(String s) {
        StringBuilder sb = new StringBuilder();
        sb = sb.append(s);
        String reverse = sb.reverse().toString();
        StringBuffer res = new StringBuffer();
        for(int i=0; i< reverse.length(); i++){
            if(reverse.charAt(i) != ' '){
                res = res.append(reverse.charAt(i));
            }else{
                break;
            }
        }
         res = res.reverse();
        System.out.println(res.toString());

        return  res.length();
    }

    public static void main(String[] args) {
        String str  ="Hello World";
        System.out.println(lengthOfLastWord(str));
    }
}
