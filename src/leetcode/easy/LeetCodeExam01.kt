package leetcode.easy

import java.util.*

fun main(args:Array<String>){
    runTask1()
}

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
fun runTask1(){
    var arr = intArrayOf(2, 7, 11, 15)
    var target = 9
    arr = twoSum(arr,target)
    print(Arrays.toString(arr))
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    var index = 0
    var sum = 0
    for(i:Int in 0..(nums.size-1)){
        sum = nums[i] + nums[i+1]
        if(sum == target){
            index = i
            break
        }else{
            sum = 0
        }
    }
    var arr = intArrayOf(index,index+1)
    return arr
}