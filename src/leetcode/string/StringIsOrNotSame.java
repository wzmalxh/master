package leetcode.string;

import java.util.Arrays;
import java.util.Comparator;

public class StringIsOrNotSame {
    public boolean closeStrings(String word1, String word2) {
        if ((word2 == null && word1 != null) || (word2 != null && word1 == null)) {
            return false;
        }
        if(word2.length() != word1.length()) {
            return false;
        }
        char[] charString1 = word1.toCharArray();
        char[] charString2 = word2.toCharArray();
        Arrays.sort(charString1);
        Arrays.sort(charString2);
        for(int i=0; i< charString1.length; i++) {
            if(charString1[i] != charString2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNearString(String word1,String word2) {
        int []n1 = new int [26];
        int []n2 = new int[26];
        char []ch1 = word1.toCharArray();
        char []ch2= word2.toCharArray();
        for(int i=0; i< ch1.length; i++) {
            n1[ch1[i]-'a'] ++;
        }for(int i=0; i< ch2.length; i++) {
            n2[ch2[i]-'a'] ++;
        }

        Arrays.sort(n1);
        Arrays.sort(n2);
        for (int i = 0; i < 26; i++) {
            if (n1[i] != n2[i]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String str1 = "cabbba";
        String str2 = "aabbss";
        System.out.println(isNearString(str1,str2));
    }
}
