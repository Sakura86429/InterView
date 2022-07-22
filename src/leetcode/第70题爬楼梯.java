package leetcode;

/**
 * Topic
 * Description
 * f3 = f2 + f1  可以用滚动数组优化
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/28 15:57
 */
public class 第70题爬楼梯 {
    public static int climb(int n) {
        int f1 = 1, f2 = 2;
        if (n < 2) return f1;
        if (n < 3) return f2;
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = f1 + f2;
            f1 = f2;
            f2 = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(climb(3));
    }
}
