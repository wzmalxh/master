package javatest.ratelimit;

public class RateLimiterDemo {

    /***
     * 滑动窗口法
     * @param args
     */

    //窗口数量
    private int windowNum;

    //定义需要的变量
    private int[] windowSize;

    private int maxRequestPerWindow;

    private long currentTimeId;

    private long rightSideOfWindow;

    //当前窗口下标
    private int windowId;

    //

    public static void main(String[] args) {
        System.out.println("这是测试限流算法的类");


    }


   /* public synchronized boolean tryAcquire() {
        long currentTime = System.currentTimeMillis();

        String str1= "q1r1r";
        System.out.println(str1.length());

        if (currentTime > rightSideOfWindow){
            do {
                windowId = (++windowId) % windowNum;
                totalCount -= perWindowCount[windowId];
                perWindowCount[windowId]=0;
                rightSideOfWindow += perWindowSize;
            }while (windowRightBorder < currentTime);
        }
        if (totalCount < maxRequestCount){
            System.out.println("tryAcquire success,{}"+windowId);
            perWindowCount[windowId]++;
            totalCount++;
            return true;
        }else{
            System.out.println("tryAcquire fail,{}"+windowId);
            return false;
        }*/
}
