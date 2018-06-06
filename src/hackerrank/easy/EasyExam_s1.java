package hackerrank.easy;


import java.util.LinkedHashMap;
import java.util.Map;

public class EasyExam_s1 {

    public EasyExam_s1(){
        init();
    }

    public void init(){
//        runTask1();
//        runTask2();
//        runTask3();
//        runTask4();
//        runTask5();
        runTask6();
    }
    void runTask6(){
//        String msg = timeConversion("07:05:45PM");
//        String msg = timeConversion("12:40:22AM");
        String msg = timeConversion("12:45:54PM");
        System.out.println(msg);
    }
    String  timeConversion(String s){
        boolean isPM = false;
        if(s.endsWith("PM")){
            isPM = true;
        }
        String[] mm = s.split(":",-1);
        if(isPM){
            int num = Integer.parseInt(mm[0]);
            if(!mm[0].equals("12")){
                num = num + 12;
            }
            mm[0] = num+"";
            mm[2] = mm[2].replace("PM","");

        }else{
            if(mm[0].equals("12")){
                mm[0] = "00";
            }
            mm[2] = mm[2].replace("AM","");

        }
        s = mm[0] + ":" + mm[1] + ":" + mm[2].replace("PM","");
        return s;
    }

    void runTask5(){
        int ar [] = {3,2,1,3};
        int ans = birthdayCakeCandles(ar);
        System.out.println(ans);
    }

    int birthdayCakeCandles(int[] ar) {
        int length = ar.length;
        Map<Integer,Integer> map = new LinkedHashMap<>();
        int max = ar[0];
        for(int i=0;i<length;i++){
            if(!map.containsKey(ar[i])){
                map.put(ar[i],1);
            }else {
                map.put(ar[i],map.get(ar[i])+1);
            }
            if(max < ar[i]){
                max = ar[i];
            }
        }
        System.out.println("Max : " + max + " | " + map);
        return map.get(max);
    }


    /**
     * input 1 2 3 4 5
     * output 10 14
     */
    void runTask4(){
        int arr [] = {1 ,2 ,3 ,4 ,5 };
        int arr2 [] = {256741038,623958417,467905213,714532089,938071625};
        miniMaxSum(arr2);
    }

    void miniMaxSum(int[] arr) {
        int length = arr.length;
        int max = arr[0];
        int min = arr[0];
        long sum = 0;
        for(int i=0;i<length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
            if(min > arr[i]){
                min = arr[i];
            }
            sum = sum +arr[i];
        }
        long showMax = sum - min;
        long showMin = sum - max;
        System.out.println(showMin + " " + showMax);
    }
    void runTask3(){
        staircase(4);
    }
    void staircase(int n) {
        StringBuffer sb = new StringBuffer(512);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j < n-1-i){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
    void runTask2(){
        int a[] = {-4,3,-9,0,4,1};
        plusMinus(a);
    }

    void plusMinus(int[] arr) {
        double positive = 0;
        double negative = 0;
        double zero = 0;
        int length = arr.length;
        for(int i=0;i<arr.length;i++) {
            if (arr[i] == 0) {
                zero++;
            } else if (arr[i] > 0) {
                positive++;
            } else if (arr[i] < 0) {
                negative++;
            }
        }
        double pos,neg,zer;
        pos = positive / length;
        neg = negative / length;
        zer = zero /length;
        System.out.printf("%3.6f\n",pos);
        System.out.printf("%3.6f\n",neg);
        System.out.printf("%3.6f\n",zer);

    }

    void runTask1(){
        int a[][] = {
                {11, 2 , 4},
                {4 , 5 , 6},
                {10, 8 , -12}
        };
        int ans = diagonalDifference(a);
        System.out.println(ans);
    }

    int diagonalDifference(int[][] a) {
        int length = a.length;
        int sum1=0;
        int sum2=0;
        for(int i=0;i<length;i++){
            sum1 = sum1 + a[i][i];
        }
        for(int i=0;i<length;i++){
            sum2 = sum2 + a[length-i-1][i];// 2,0 1,1 0,2
        }
        int sum = sum1 - sum2;
        if(sum < 0){
            sum = 0 - sum;
        }
        return sum;
    }






    public static void main(String args[]){
        new EasyExam_s1();
    }
}
