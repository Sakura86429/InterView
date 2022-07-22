package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Topic 剑指 Offer 56 - I. 数组中数字出现的次数（找到数组中两个只出现一次的数字）
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/30 13:02
 */
public class 第56数组中数字出现的次数 {
    public static int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[] ans = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) ans[index++] = entry.getKey();
        }
        return ans;
    }

    public static int[] singleTowNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) {   // 得到a，b异或后的结果
            ret ^= n;
        }
        int target = 1;
        while ((target & ret) == 0) {   // 找到第一个不同的位--->第一个！=0；==0就左移1位   // 也可以写成！=1，一个意思
            target <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {   // 利用与target异或为0/1来将a，b到不同组
            if ((n & target) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
//        int[] ans = singleNumbers(new int[]{1,2,10,4,1,4,3,3});
        int[] ans = singleTowNumber(new int[]{1,2,10,4,1,4,3,3});
        for (int n : ans) {
            System.out.print(n + " ");
        }
    }

}
