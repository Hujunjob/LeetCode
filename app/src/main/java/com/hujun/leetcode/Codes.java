package com.hujun.leetcode;

import android.text.TextUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by junhu on 2020/3/10
 */
public class Codes {
    public int lengthOfLongestSubstring(String s) {
        int leftPtr = 0;
        int rightPtr = 1;
        if (s == null) {
            return 0;
        }
        if (s.length() == 0) {
            return 0;
        }
        List<Character> lists = new ArrayList<>();
        lists.add(s.charAt(leftPtr));
        int res = 1;
        while (rightPtr < s.length()) {
            //设定两个指针，左指针和右指针
            char cLeft = s.charAt(leftPtr);
            char cRight = s.charAt(rightPtr);
            if (lists.contains(cRight)) {
                lists.remove((Character) cLeft);
                leftPtr += 1;
                if (lists.isEmpty()) {
                    lists.add(s.charAt(leftPtr));
                }
                if (leftPtr == rightPtr) {
                    rightPtr += 1;
//                    lists.add(s.charAt(rightPtr));
                }
            } else {
                lists.add(cRight);
                if (res < lists.size()) {
                    res = lists.size();
                }
                rightPtr += 1;
            }
        }
        return res;
    }

    public String longestCommonPrefix(String[] strs) {
        //空字符
        int length = strs.length;
        if (length == 0) {
            return "";
        }

        //第一个字符串
        String str0 = strs[0];
        if (str0.length() == 0) {
            return "";
        }

        //开始遍历
        return "";
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length == 0) {
            return resultList;
        }
        if (nums.length == 1) {
            List<Integer> ll = new ArrayList<>();
            ll.add(nums[0]);
            resultList.add(ll);
            return resultList;
        }

        //分别将各个数字提出来放到第一个，剩下的数字进行全排列
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int[] nums2 = getExtra(nums, i);
            List<List<Integer>> extras = permute(nums2);
            int length = extras.size();
            for (int j = 0; j < length; j++) {
                List<Integer> array = new ArrayList<>();
                array.add(nums[i]);
                array.addAll(extras.get(j));
                resultList.add(array);
            }
        }

        return resultList;
    }

    //获得除去position位置处的数字串
    private int[] getExtra(int[] nums, int position) {
        if (nums.length <= position) {
            return nums;
        }
        if (nums.length == 1) {
            return nums;
        }
        int[] nums2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < position) {
                nums2[i] = nums[i];
            } else if (i > position) {
                nums2[i - 1] = nums[i];
            }
        }
        return nums2;
    }

    private void test() {
        Map<Character, Integer> map = new HashMap<>();
        Set set = map.keySet();
        set.iterator();
        while (set.iterator().hasNext()) {

        }

    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int l1 = s1.length();
        int l2 = s2.length();
        //在s2里找到s1长度的区间，对比这个区间和s1的字符
        //首先保存s1每个字符的出现次数
        Map<Character, Integer> mapS1 = calCharacterNums(s1);

        Map<Character, Integer> mapS2 = null;
        for (int i = 0; i <= l2 - l1; i++) {
            if (i == 0) {
                mapS2 = calCharacterNums(s2.substring(0, l1));
            } else {
                if (i == 4893 - l1) {
                    int a = 1;
                }
                //去掉前一个字符
                char c1 = s2.charAt(i - 1);
                if (mapS2.get(c1) == 1) {
                    mapS2.remove(s2.charAt(i - 1));
                } else {
                    mapS2.put(c1, mapS2.get(c1) - 1);
                }
                //增加后一个字符
                char c2 = s2.charAt(i + l1 - 1);
                putChar2Map(mapS2, c2);
            }
            //检查跟mapS1是否相等
            boolean isSame = isSame(mapS1, mapS2);
            if (isSame) {
                return true;
            }
        }
        return false;
    }

    private boolean isSame(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        Set<Character> set = map1.keySet();
        for (Character c : set) {
            if (map2.containsKey(c)) {
//                if (map2.get(c) != map1.get(c)) {
                if (!Objects.equals(map2.get(c), map1.get(c))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    //计算字符串里，每个字符的个数
    private Map<Character, Integer> calCharacterNums(String s) {
        Map<Character, Integer> mapS1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            putChar2Map(mapS1, c);
        }
        return mapS1;
    }

    //将字符放入map
    private void putChar2Map(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            int num = map.get(c) + 1;
            map.put(c, num);
        } else {
            map.put(c, 1);
        }
    }

    public String multiply(String num1, String num2) {
        //c =  num2 * num1
        int l1 = num1.length();
        int l2 = num2.length();
        if (l1==0||l2==0){
            return "0";
        }
        if ("0".equals(num1)||"0".equals(num2)){
            return "0";
        }
        int l3 = l1 + l2;
        char[] cc = new char[l3];
        cc[0] = '0';
        //保存进位的值
        int jinwei = 0;
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                //进位乘法
                char c2 = num1.charAt(i);
                char c1 = num2.charAt(j);
                if (cc[i+j+1]<'0'){
                    cc[i+j+1] = '0';
                }
                int c1c2 = (c1 - 48) * (c2 - 48) + jinwei + (cc[i+j+1] - '0');

                cc[i + j + 1] =  (char)(c1c2 % 10+'0');
                jinwei = c1c2 / 10;
            }
            cc[i] = (char) (jinwei + '0');
            jinwei = 0;
        }
        //去掉头部的0
        if (cc[0] == '0') {
            if (cc[1]=='0'){
                return new String(cc, 2, cc.length - 2);
            }
            return new String(cc, 1, cc.length - 1);
        }
        return new String(cc);
    }

    public String simplifyPath(String path) {
        if(path==null){
            return "/";
        }
        if("/".equals(path)){
            return "/";
        }
        if(!path.startsWith("/")){
            return "/";
        }
        String[] paths = path.trim().split("/");
        Deque<String> deque = new ArrayDeque<>();
        for(int i=0;i<paths.length;i++){
            String p = paths[i].trim();
            if(p.length()==0){
                continue;
            }
            if(".".equals(p)){
                continue;
            }
            if("..".equals(p)){
                deque.pollLast();
                continue;
            }
            deque.add(p);
        }
        StringBuilder builder = new StringBuilder();
        builder.append("/");
        while(deque.size()!=0){
            String s = deque.pollFirst();
            builder.append(s);
            if(deque.size()!=0) {
                builder.append("/");
            }
        }
        return builder.toString();
    }
}
