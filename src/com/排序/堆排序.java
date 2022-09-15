package com.排序;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/19 16:46
 */
public class 堆排序 {
//    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {   // 1.构建大顶堆（从第一个非叶子节点从下至上，从右至左调整结构）
//            adjust(arr, i, arr.length);   // 从底元素逐渐一个一个添加元素进去构建大顶堆
//        }
//        for (int j = arr.length - 1; j > 0; j--) {   // 2.调整堆结构+交换堆顶元素和末尾元素(到下标为2的时候，长度为2，构建大顶堆交换后就可以结束了)
//            int tem = arr[j];
//            arr[j] = arr[0];
//            arr[0] = tem;
//            adjust(arr, 0, j);   // 从顶元素开始重新调整为长度为j的大顶堆
//        }
//
//        for (int i : arr) System.out.print(i + " ");
//    }
//
//    private static void adjust(int[] arr, int i, int length) {
//        int temp = arr[i];
//        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {   // 从i结点的左子结点开始自顶往下，也就是2i+1处开始
//            if (k + 1 < length && arr[k] < arr[k + 1]) k++;
//            if (arr[k] > temp) {   // 如果子节点值大于父节点，将子节点值赋给父节点（不用进行交换）
//                arr[i] = arr[k];
//                i = k;   // 哪个地方变化i就移动到哪个地方
//            } else break;
//        }
//        arr[i] = temp;   // temp赋给arr[i]这个位置上   //将temp值放到最终的位置
//    }

//    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            adjust(arr, i, arr.length);
//        }
//        for (int j = arr.length - 1; j > 0; j--) {
//            int tem = arr[j];
//            arr[j] = arr[0];
//            arr[0] = tem;
//            adjust(arr, 0, j);
//        }
//        for (int n : arr) System.out.print(n + " ");
//    }
//
//    private static void adjust(int[] arr, int i, int length) {
//        int tem = arr[i];
//        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
//            if (k + 1 < length && arr[k] < arr[k + 1]) k++;
//            if (arr[k] > tem) {
//                arr[i] = arr[k];   // 保证顶是3个数里面最大的
//                i = k;   // 只做移动tem的位置来用，方便最后arr[i] = tem
//            } else break;;
//        }
//        arr[i] = tem;
//    }

//    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            adjust(arr, i, arr.length);
//        }
//        for (int i = arr.length - 1; i > 0; i--) {
//            int tem = arr[i];
//            arr[i] = arr[0];
//            arr[0] = tem;
//            adjust(arr, 0, i);
//        }
//        for (int n : arr) System.out.print(n + " ");
//    }
//
//    private static void adjust(int[] arr, int i, int length) {
//        int tem = arr[i];
//        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {   // 是length，不是arr.length
//            if (k + 1 < length && arr[k] < arr[k + 1]) k++;
//            if (arr[k] > tem) {
//                arr[i] = arr[k];   // 下面两个是把当前arr[k]赋给当前的arr[i]
//                i = k;
//            } else break;
//        }
//        arr[i] = tem;
//    }

//    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            adjust(arr, i, arr.length);
//        }
//        for (int i = arr.length - 1; i > 0; i--) {
//            int tem = arr[i];
//            arr[i] = arr[0];
//            arr[0] = tem;
//            adjust(arr, 0, i);
//        }
//        for (int n : arr) System.out.print(n + " ");
//    }
//
//    private static void adjust(int[] arr, int i, int length) {
//        int tem = arr[i];
//        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
//            if (k + 1 < length && arr[k] < arr[k + 1]) k++;
//            if (arr[k] > tem) {
//                arr[i] = arr[k];
//                i = k;
//            } else break;
//        }
//        arr[i] = tem;
//    }

//    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            adjust(arr, i, arr.length);
//        }
//        for (int i = arr.length - 1; i > 0; i--) {
//            int tem = arr[i];
//            arr[i] = arr[0];
//            arr[0] = tem;
//            adjust(arr, 0, i);
//        }
//        for (int n : arr) System.out.print(n + " ");
//    }
//
//    private static void adjust(int[] arr, int i, int length) {
//        int tem = arr[i];   // tem保存arr[i]，下面可能会修改掉
//        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
//            if (k + 1 < length && arr[k] < arr[k + 1]) k++;
//            if (arr[k] > tem) {
//                arr[i] = arr[k];
//                i = k;   // i时刻变化
//            }
//        }
//        arr[i] = tem;
//    }

//    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            adjust(arr, i, arr.length);
//        }
//        for (int i = arr.length - 1; i > 0; i--) {
//            int tem = arr[i];
//            arr[i] = arr[0];
//            arr[0] = tem;
//            adjust(arr, 0, i);
//        }
//        for (int n : arr) System.out.print(n + " ");
//    }
//
//    private static void adjust(int[] arr, int i, int length) {
//        int tem = arr[i];
//        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
//            if (k + 1 < length && arr[k] < arr[k + 1]) k++;
//            if (arr[k] > tem) {   // 因为是从后往前的，所以和tem比较，调整一次就好了。下坠的时候也是只和tem比较
//                arr[i] = arr[k];
//                i = k;
//            }
//        }
//        arr[i] = tem;
//    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int tem = arr[i];
            arr[i] = arr[0];
            arr[0] = tem;
            adjust(arr, 0, i);
        }
        for (int n : arr) System.out.print(n + " ");
    }

    private static void adjust(int[] arr, int i, int length) {
        int tem = arr[i];   // 存起来后一直下沉arr[i] = arr[k]，i = k
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) k++;
            if (arr[k] > tem) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = tem;
    }
}
