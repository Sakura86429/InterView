package leetcode;

/**
 * Topic
 * Description  动态规划，x位置的可能是从x-1一步过来的，也可能是从x-2两步过来的，这两种可能，所以f(x) = f(x-1) + f(x-2)
 * 滚动数组优化只要让f(x=1)=1,f(x=2) = 2就可以往前递推了
 * f3 = f2 + f1  可以用滚动数组优化
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/28 15:57
 */
public class 第70题爬楼梯 {
//    public static int climbStairs(int n) {
//        int f1 = 1, f2 = 2;
//        if (n < 2) return f1;
//        if (n < 3) return f2;
//        int ans = 0;
//        for (int i = 3; i <= n; i++) {
//            ans = f1 + f2;
//            f1 = f2;
//            f2 = ans;
//        }
//        return ans;
//    }
    public static int climbStairs(int n) {
        int f1 = 0, f2 = 0, f3 = 1;   // 0 0 1 前移一步得到 0 1 0+1=1，第三个下标为f(1)的值；再往前移一步，1 1 1+1=2，第三个下标为f(2)的值
        // 再后面也一直都是后两个数相加，所以满足条件
        for (int i = 1; i <= n; i++) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;   // 也就是移动之前的f2和f3
        }
        return f3;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
