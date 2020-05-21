package com.test;

/**
 * @program: xcEduService01
 * @description: 测试
 * @author: Chai.duolai
 * @create: 2020-04-14 11:23
 **/
public class CheckTwoSum {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6};
        int k=7;
        checkTwoSum(a,k);
    }
    private static boolean checkTwoSum(int[] nums, int k) {
        // Write your code here
        Boolean result=null;
        int length = nums.length;
        int hash[]=new int[length];
        for (int i = 0; i < length; i++) {
            hash[nums[i]%length]=1;
        }
        for (int i = 0; i < length; i++) {
            int tmp = k - nums[i];
            if((tmp > nums[i]) && (hash[tmp%length] == 1)){
                System.out.println(nums[i] + " " + tmp);
            }
        }
        
        return result;
    }
}