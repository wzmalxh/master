package leetcode.shuzu;

import java.util.HashSet;

public class LongestConnectSequece {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i< nums.length; i++){
            hashSet.add(nums[i]);
        }
        int cnt = 0;
        int maxLength = 0;
        for(int k =0; k< nums.length; k++){
            if(!hashSet.contains(nums[k]-1)) {
                //是起点，向后遍历
                cnt = 1;
                int tmp = nums[k];
                while(cnt < hashSet.size()) {
                    tmp += 1;
                    if(hashSet.contains(tmp)) {
                        cnt ++;
                    } else{
                        break;
                    }
                }
                if(cnt > maxLength) {
                    maxLength = cnt;
                }
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        int []nums = {100,4,1,200,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
