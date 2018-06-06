package hackerrank;

import java.util.*;

public class MBExam {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        /*Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int num [] = new int[n];*/
//        int n = 6;
/*        int num[] = {3,7,11,9,14,11};
//        int num[] = {1,2,3,4,5,6,7,8};
//        int num[] = {1,3,1,4,9,6,2,11};
//        int num[] = {8,7,6,5,4,3,2,1};
        int n = num.length;
        *//*for(int i=0;i<n;i++){
            num[i] = input.nextInt();
        }*//*
        num = runTask1(num);
        for(int i=0;i<n;i++){
            System.out.print(num[i] + " ");
        }*/

        runTask3();
    }
    public static int[] runTask1(int [] arr){
        boolean isRightTall;
        int tmp;
        int max;
        for(int i=0;i<arr.length;i++){
            isRightTall = false;
            max = arr[i];
            tmp = arr[i];
            for(int j=i;j<arr.length;j++){
                if(tmp < arr[j]){
                    isRightTall = true;
                    break;
                }
            }
            for(int j=i;j<arr.length;j++){
                if(max < arr[j]){
                    max = arr[j];
                }
            }
            if(isRightTall){
                max = max + 1;
                arr[i] = max - arr[i];
            }else{
                arr[i] = 0;
            }
        }
        return arr;
    }
    public static int[] runTask2(int [] arr){
        boolean isRightTall = false;
        int tmp;
        int max = 0;
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(index == i){
                isRightTall = false;
                max = arr[i];
                tmp = arr[i];
                for(int j=i;j<arr.length;j++){
                    if(tmp < arr[j]){
                        isRightTall = true;
                    }
                    if(max < arr[j]){
                        max = arr[j];
                    }
                }
            }
            if(isRightTall){
                max = max + 1;
                arr[i] = max - arr[i];
            }else{
                arr[i] = 0;
            }
            index ++;
        }
        return arr;
    }
    public static void runTask3(){
        String a[] = { "a","jk","abb","mn","abc"};
        String b[] = { "bb","kj","bbc","op","def"};
        int [] show = getMinimumDifference(a,b);
        System.out.println(Arrays.toString(show));
    }

    static int[] getMinimumDifference(String[] a, String[] b) {
        int len = a.length;
        int ans [] = new int[len];
        int num;
        Map<Integer,Integer> mapA = new LinkedHashMap<Integer, Integer>();
        Map<Integer,Integer> mapB = new LinkedHashMap<Integer, Integer>();
        for(int i=0;i<len;i++){
            num = -1;
            if(a[i].length() == b[i].length()){
                int aArr[] = new int[a[i].length()];
                int bArr[] = new int[b[i].length()];
                for(int j=0;j<aArr.length;j++){
                    aArr[j] = (int)a[i].charAt(j);
                    bArr[j] = (int)b[j].charAt(j);
                }
                aArr = sort(aArr);
                bArr = sort(bArr);
                int tmp = aArr[0];
                int count = 0;
                for(int x=0;x<aArr.length;x++){
                    if(aArr[x] != tmp) {
                        mapA.put(tmp,count);
                        count = 0;
                        tmp = aArr[x];
                    }
                    count++;
                    if(x== aArr.length-1){
                        mapA.put(tmp,count);
                    }
                }
                for(int x=0;x<bArr.length;x++){
                    if(bArr[x] != tmp) {
                        mapB.put(tmp,count);
                        count = 0;
                        tmp = aArr[x];
                    }
                    count++;
                    if(x== bArr.length-1){
                        mapB.put(tmp,count);
                    }
                }
                int sum = 0;
                List lstKey = new ArrayList();

                for (Integer key : mapA.keySet()){
                    lstKey.add(key);
                }
                for (Integer key : mapB.keySet()){
                    if(!mapA.containsKey(key)){
                        lstKey.add(key);
                    }
                }

                for (int j=0;j<lstKey.size();j++) {
                    int key = (int)lstKey.get(i);
                    if(mapA.containsKey(key)){
                        if(mapA.get(key) > mapB.get(key)){
                            sum = sum + (mapA.get(key) - mapB.get(key));
                        }else{
                            sum = sum + (mapB.get(key) - mapA.get(key));
                        }
                    }else {
                        sum = sum + mapB.get(key) ;
                    }
                }
                num = sum;
            }
            ans[i] = num;
        }
        return ans;
    }

    public static int[] sort(int arr[]){
        int len = arr.length;
        int tmp;
        for(int i=0;i<len;i++){
            for(int j=1;j<len;j++){
                if(arr[j-1] > arr[j]){
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
