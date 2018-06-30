package leetcode;

import leetcode.easy.LeetCodeExam01;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCodeMain {

    public LeetCodeMain(){
        runTask1TwoOneTwo();
//        runTask2SumOf9527();
    }

    void runTask1TwoOneTwo(){
        int [] arr = { 1,1,5,5,3,3,7,7,9,12,12};

        Map<Integer,Integer> map = new LinkedHashMap<>();
        int tmp;
        for(int num : arr){
            if(map.containsKey(num)){
                tmp = map.get(num);
                tmp ++;
                map.put(num,tmp);
            }else{
                map.put(num,1);
            }
        }
//        System.out.println(map);
        // Map Operator
        for(Integer num:map.keySet()){
            if(map.get(num) == 1){
                System.out.print(num + " is the one.");
            }
        }
    }
    void runTask2SumOf9527(){
        int num = 99678911;
        String msg = calNumberSum(num) + "";
        System.out.println(msg);
        System.out.println(num % 9);
    }

    int calNumberSum(int num){
        int sum = 0;
        while(num > 10){
            sum = sum + num % 10;
            num = num /10 ;
        }
        sum = sum + num;
//        System.out.println("Sum: " + sum);
        if(sum > 10){
            sum = calNumberSum(sum);
        }
        return sum;
    }


    public static void main(String args[]){
        new LeetCodeMain();
    }
}
