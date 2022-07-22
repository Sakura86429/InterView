package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/28 10:20
 */
public class 第33题搜索旋转排序数组 {
    public static void main(String[] args) {

    }
//    public int search(int[] nums, int target) {
//        if (nums.length == 0) return -1;
//        if (nums.length == 1) return nums[0] == target ? 0 : -1;
//        int l = 0, r = nums.length - 1;
//        while (l <= r) {   // 当为单个元素的时候，l=r=0
//            int mid = (l + r) / 2;
//            if (nums[mid] == target) return mid;   // 已经判断过nums[mid]是否等于target了，所以后续可以直接=mid+-1
//            if (nums[mid] >= nums[0]) {   // 说明l到mid为有序，使用nums[0]0判断   // 此处应该为>=，因为当nums=[1,3],target=1的时候，这个if>不满足进入else中mid-r，所以会有r=mid-1最后返回-1了
//                if (target >= nums[l] && target < nums[mid]) {   // 因为移动r，所以左边可以相等   // target在左有序
//                    r = mid - 1;
//                } else {   // target不在左有序
//                    l = mid + 1;   // 因为前面已经判断过nums[mid]==target了，所以这里不用=mid可以直接=mid+1
//                }
//            } else {   // 当l到mid无序时，说明下标mid+1到右边有序
//                if (target > nums[mid] && target <= nums[r]) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            }
//        }
//        return -1;   // 都没找到就返回-1
//    }

    public int search(int[] nums, int target) {   // [3, 1]
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;   // 二分法需要先n至少为2
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {   // 左有序【456 7 8 123】
                if (nums[0] <= target && target < nums[mid]) r = mid - 1;
                else l = mid + 1;   // 相等的情况前第3行，此时已经排除了
            } else {   // 右有序【78 12 3 45】
                if (nums[mid] < target && target <= nums[n - 1]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }

}
