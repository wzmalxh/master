package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinCoverSubArray {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mapS = new HashMap<>();
        HashMap<Character,Integer> mapT = new HashMap<>();
        HashMap<Character,Integer> mapTCnt = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        String result = "";
        for(int i=0 ; i< t.length(); i++){
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0)+1);
            mapTCnt.put(t.charAt(i), mapTCnt.getOrDefault(t.charAt(i), 0)+1);
        }

        //统计t中各个字符的数量
        boolean cover = true;
        for(int left =0, right =0 ; right < s.length(); right ++){
            mapS.put(s.charAt(right), mapS.getOrDefault(s.charAt(right), 0)+1);

            //如果还没到边界，说明这个是结果中需要的字符
            if(mapT.containsKey(s.charAt(right))){
                if(mapS.get(s.charAt(right)) <= mapT.get(s.charAt(right))){
                   mapTCnt.put(s.charAt(right), mapTCnt.get(s.charAt(right)) -1);
                }
            }
            //如果有重复元素，需要挪动左边界来删除重复的元素
            while(left < right && (!mapT.containsKey(s.charAt(left)) || (mapS.get(s.charAt(left)) > mapT.get(s.charAt(left))))){
                mapS.put(s.charAt(left), mapS.get(s.charAt(left))-1);
                left ++ ;
            }
            for(Map.Entry<Character,Integer> m : mapTCnt.entrySet()){
                if (m.getValue() > 0) {
                    cover = false;
                    break;
                }
            }
            if( cover && (right - left +1 < minLength)){
                minLength = right - left +1;
                result = s.substring(left,right +1 );
            }
        }
        return  result;

    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        MinCoverSubArray min = new MinCoverSubArray();
        System.out.println(min.minWindow(s,t));
    }
}
