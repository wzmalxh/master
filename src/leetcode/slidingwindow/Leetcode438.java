package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode438 {
    public static List<Integer> findAnagrams(String s, String p) {
        int []sArray = new int[26];
        int []pArray = new int[26];
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();

        for(int i=0; i< p.length(); i++){
            ++sArray[s.charAt(i) - 'a'];
            ++pArray[p.charAt(i) - 'a'];

        }
        if(Arrays.equals(sArray,pArray)){
            result.add(0);
        }
        for(int i=0; i< sLen - pLen; i++){
            --sArray[s.charAt(i) - 'a'];
            ++sArray[s.charAt(i+pLen) - 'a'];

            if (Arrays.equals(sArray, pArray)) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> res = findAnagrams("cbaebabacd","abc");
        System.out.println(res);
    }
}
