package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic
 * Description info[1] --> info[0]，学完第二个才能学第一个
 * 原网页堆入栈的结果就是拓扑排序完的顺序
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/26 16:50
 */
public class 第207课程表 {

    List<List<Integer>> list=new ArrayList<>();
    int[] visit;
    boolean isvalid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visit = new int[numCourses];
        for (int i=0;i<numCourses;i++){
            list.add(new ArrayList<Integer>());// 初始化，不初始化size()为0，可能是null这种
        }
        for (int[] info:prerequisites){   // 存每个节点的出度info[0]
            // 学info[0]之前要先学info[1],
            // 所以info[1]指向info[0],
            // 所以在info[1]的ArrayList中存储它指向哪个科目
            list.get(info[1]).add(info[0]);   // info[1] --> info[0]，学完第二个才能学第一个
        }
        for (int i=0;i<numCourses;i++){
            if (visit[i]==0){ // 如果是未搜索的科目，则深搜
                dfs(i);
            }
        }
        return isvalid;
    }
    public void dfs(int v){
        visit[v]=1; // 标记该科目为搜索中
        for (int w:list.get(v)){ // 遍历该科目指向的学科，两种情况都不满足就执行 visit[v]=2;了
            if (visit[w]==0){ // 如果指向的某一学科未搜索过，则深搜
                dfs(w);
                if (!isvalid){
                    return;
                }
            } else if (visit[w]==1){ // 如果指向的某一学科在搜索中，则有环，标记isVaild
                isvalid=false;
                return;
            }
        }
        visit[v]=2; // 因为该科目已经完成深搜，所以标记它的状态为搜索过
    }

    public static void main(String[] args) {
        第207课程表 main = new 第207课程表();
        boolean ans = main.canFinish(2, new int[][]{{1, 0}});
        System.out.println(ans);
    }
}
