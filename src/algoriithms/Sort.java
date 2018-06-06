package algoriithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    public Sort(){
        int arr0[] = {1,1,1,1,1,1,1,1,1};
        int arr1[] = {1,2,3,4,5,6,7,8,9};
        int arr2[] = {8,9,7,6,5,4,1,2,3};
        int arr3[] = {29,5,9,17,2,3,1};
        int arr4[] = {125,25,19,7,2,3,1};
        int arr5[] = {99,5,9,7,2,3,31};

        arr0 = ctrlSort(arr0);
        arr1 = ctrlSort(arr1);
        arr2 = ctrlSort(arr2);
        /*arr3 = ctrlSort(arr3);
        arr4 = ctrlSort(arr4);
        arr5 = ctrlSort(arr5);*/

        System.out.println(Arrays.toString(arr0));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        /*System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));*/
    }
    public int[] ctrlSort(int arr[]){
//        arr = bubbleSort(arr);
        arr = quickSort(arr);
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
