
package leetcode.easy;

import java.util.Arrays;

public class LeetCodeExam01 {
    public LeetCodeExam01(){
        runTask1();
    }
    void runTask1(){
        int [] arr = {2, 7, 11, 15};
        int target = 9;
        arr = twoSum(arr,target);
        System.out.println(Arrays.toString(arr));
    }

    int [] twoSum(int [] nums,int target){
        int index = 0;
        int sum = 0;
        for(int i=0;i<nums.length-1;i++){
            sum = nums[i] + nums[i+1];
            if(sum == target){
                index = i;
                break;
            }else{
                sum = 0;
            }
        }
        int [] arr = {index,index+1};
        return arr;
    }

    public static void main(String args[]){
        new LeetCodeExam01();
    }
}





