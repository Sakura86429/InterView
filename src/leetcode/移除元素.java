package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/19 21:08
 */
public class 移除元素 {
    public static void main(String[] args) {

    }
    // 两个单向2n遍历的双指针
//    public int removeElement(int[] nums, int val) {   // 如果元素的位置在1这里，就需要把每一个元素都左移一位
//        int slow = 0;
//        for (int fast = 0; fast < nums.length; fast++) {
//            if (nums[fast] != val) {
//                nums[slow++] = nums[fast];
//            }
//        }
//        return slow;
//    }
    // 相向双指针
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = nums.length - 1;
        while (slow <= fast) {
            if (nums[slow] == val) {
                nums[slow] = nums[fast];
                fast--;
            } else {
                slow++;   // 把fast移动到原val位置后还要++，所以最后直接返回slow
            }
        }
        return slow;
    }
}
