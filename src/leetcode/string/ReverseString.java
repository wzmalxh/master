package leetcode.string;


public class ReverseString {
    public static String reverseWords(String s) {
        String trim = s.trim();
        String[] chars = trim.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i= chars.length-1; i>=0 ; i--) {
            sb.append(chars[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println(reverseWords(str));
    }
}
