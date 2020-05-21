package com.xuecheng.manage_course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: xcEduService01
 * @description: da
 * @author: Chai.duolai
 * @create: 2020-04-14 11:53
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class test {
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 11;
//        boolean b = checkTwoSum(nums, k);
//        boolean b = checkTwoSum3(nums, k);
//        System.out.println(b);
//        checkTwoSum2(a,k);
    }
    
    private boolean checkTwoSum(int[] nums, int k) {
        String num = Arrays.toString(nums);
        boolean result=false;
        for (int i = 0; i < nums.length; i++) {
            if (num.contains(String.valueOf(k-nums[i]))){
                if (k == 2*nums[i] && (num.split(String.valueOf(k-nums[i])).length-1) == 1){
                    continue;
                }
                System.out.println(nums[i]);
                result = true;
            }
        }
        return result;
    }
    
    private void checkTwoSum2(int[] nums, int k) {
//        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = k - nums[i];
           if (a+nums[i]==k){
               System.out.println(nums[i]);
           }
        }
    }
    
    /*private static boolean checkTwoSum(int[] nums, int k) {
        // Write your code here
        boolean result = false;
        int length = nums.length;
        int hash[] = new int[length];
        for (int i = 0; i < length; i++) {
            hash[nums[i] % length] = 1;
        }
        for (int i = 0; i < length; i++) {
            int tmp = k - nums[i];
            if ((tmp > nums[i]) && (hash[tmp % length] == 1)) {
               result =true;
               return result;
            }
        }
        return result;
    }*/
}