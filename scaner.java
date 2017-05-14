import java.util.Scanner;

/**
 * @author Feng_zhulin
 * @since 17/3/20
 */
public class scaner {

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int maxQps= Integer.valueOf(in.nextLine());
        final String[] rtList = in.nextLine().split(",");
        final int requestNum = Integer.valueOf(in.nextLine());
        final int threadNum = Integer.valueOf(in.nextLine());
        System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
    }
    /**
     * 如果使用最优的最大吞吐量负载均衡算法，按照最优模型多久能够处理完所有请求，单位毫秒。
     * @return
     */
    static long doneTime(int maxQps,String[] rtList,int requestNum,int threadNum) {
        //TODO
        int qpsSum = 0;
        for (String rtString : rtList) {
            int singleMaxQps = threadNum * 1000 / Integer.valueOf(rtString);
            if (singleMaxQps > maxQps) {
                qpsSum += maxQps;
            }else {
                qpsSum += singleMaxQps;
            }
        }

        return requestNum / qpsSum * 1000;
    }
}