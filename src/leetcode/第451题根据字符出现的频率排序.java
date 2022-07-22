package leetcode;

import java.util.*;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/10 9:56
 */
public class 第451题根据字符出现的频率排序 {
    public static void main(String[] args) {

    }
    public String List_frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = s.length();
        for (int i = 0; i < l; i++) {   // 使用map存出现次数
            char c = s.charAt(i);
            int fre = map.getOrDefault(c, 0) + 1;
            map.put(c, fre);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));   // 使用list存字符并自定义排序
        StringBuffer sb = new StringBuffer();   // 新建Stringbuffer提取字符和频率存放答案
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            int fre = map.get(c);
            for (int j = 0; j < fre; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String buckets_frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFre = 0;
        for (int i = 0; i < s.length(); i++) {   // 统计出最多频率
            char ch = s.charAt(i);
            int fre = map.getOrDefault(ch, 0) + 1;
            map.put(ch, fre);
            maxFre = Math.max(maxFre, fre);
        }
        StringBuffer[] buckets = new StringBuffer[maxFre + 1];   // 此处从0-maxFre省事，方便最后可以直接从maxFre-1遍历
        for (int i = 0; i <= maxFre; i++) {   // 初始化buckets
            buckets[i] = new StringBuffer();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {   // 将从1到maxFre的字符装入桶中（entrySet不含重复key）
            char ch = entry.getKey();
            int fre = entry.getValue();
            buckets[fre].append(ch);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = maxFre; i > 0; i--) {
            StringBuffer bucket = buckets[i];
            for (int j = 0; j < bucket.length(); j++) {   // 长度为i的bucket中可能不止一种字符
                for (int k = 0; k < i; k++) {   // 多次存放相同字符串的所有同一单个字符charAt(j)
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
