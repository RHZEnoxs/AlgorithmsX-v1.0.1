package algoriithms;


import java.util.Arrays;

public class Sort {
    int arrSrc [][] = {
            {1,1,1,1,1,1,1,1,1},
            {1,2,3,4,5,6,7,8,9},
            {8,9,7,6,5,4,1,2,3},
            {29,5,9,17,2,3,1},
            {125,25,19,7,2,3,1},
            {99,5,9,7,2,3,31}
    };
    public Sort(){
        for(int [] arr : arrSrc){
            System.out.println(Arrays.toString(ctrlSort(arr)));
        }
    }
    public int[] ctrlSort(int arr[]){
        arr = bubbleSort(arr);
//        arr = quickSort(arr);
        return arr;
    }

    public int[] bubbleSort(int arr[]){
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

    public int [] quickSort(int arr[]){
        arr = quickSort(arr,0,arr.length-1);
        return arr;
    }


    public int[] quickSort(int arr[],int head,int tail){
        int i = head;
        int j = tail;
        int index = arr[arr.length/2];
        int tmp;
        while(i<=j){
            while(arr[i]<index){
                i++;
            }
            while(arr[j]>index){
                j--;
            }
            if(i<j){
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }else{
                i++;
            }
        }
//        quickSort(arr,head,j);
//        quickSort(arr,i,tail);
        return arr;
    }
    public static void main(String args[]){
        new Sort();
    }
}
