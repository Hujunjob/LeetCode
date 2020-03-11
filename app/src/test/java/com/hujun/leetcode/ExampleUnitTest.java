package com.hujun.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Codes code;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

        Codes codes = new Codes();
//        int res = codes.lengthOfLongestSubstring("abcabcbb");
//        assertEquals(res,3);
        String[] ss = {};
//        String res = codes.longestCommonPrefix(ss);
//        assertEquals(res, "");

//        int[] nums = {1};
//        List<List<Integer>> lists = codes.permute(nums);
//        System.out.println(lists.size());

//        String s1 = "daaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String s2 = "faaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaax";
//        boolean res = codes.checkInclusion(s1,s2);
//        assertEquals(res,true);
//        int a = 894311;
//        int b = 40423;
//        String str = codes.multiply( "123",  "3243");
//        assertEquals(str, "398889");
        String str = codes.simplifyPath("");
        assertEquals(str,"/");
    }
}