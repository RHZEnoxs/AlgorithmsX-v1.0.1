package hackerrank.hard;

import algoriithms.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardExam_s1 {

    public HardExam_s1(){
//        runTask1();
        runTask2();
    }

    public void runTask2(){

        /*int matrix[][] ={
                { 1 , 2 },
                { 3 , 4 }
        };*/
        /*int matrix[][] ={
                {1 ,2 ,3 ,4 ,5}, 14,6
                {6 ,7 ,8 ,9 ,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };*/
        /*int matrix[][] ={
                {1 ,2 ,3 ,4 ,5 ,6 },
                {7 ,8 ,9 ,10,11,12 },
                {13,14,15,16,17,18 },
                {19,20,21,22,23,24 },
                {25,26,27,28,29,30 },
                {31,32,33,34,35,36 },
        };*/
        int [][] matrix = {
                {9718805 , 60013003 , 5103628 , 85388216 , 21884498 , 38021292 , 73470430 , 31785927 },
                {69999937 , 71783860 , 10329789 , 96382322 , 71055337 , 30247265 , 96087879 , 93754371 },
                {79943507 , 75398396 , 38446081 , 34699742 , 1408833 , 51189 , 17741775 , 53195748 },
                {79354991 , 26629304 , 86523163 , 67042516 , 54688734 , 54630910 , 6967117 , 90198864 },
                {84146680 , 27762534 , 6331115 , 5932542 , 29446517 , 15654690 , 92837327 , 91644840 },
                {58623600 , 69622764 , 2218936 , 58592832 , 49558405 , 17112485 , 38615864 , 32720798 },
                {49469904 , 5270000 , 32589026 , 56425665 , 23544383 , 90502426 , 63729346 , 35319547 },
                {20888810 , 97945481 , 85669747 , 88915819 , 96642353 , 42430633 , 47265349 , 89653362 },
                {55349226 , 10844931 , 25289229 , 90786953 , 22590518 , 54702481 , 71197978 , 50410021 },
                {9392211 , 31297360 , 27353496 , 56239301 , 7071172 , 61983443 , 86544343 , 43779176 }
        };
        /*int [][] matrix = {
                {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 },
                {9 , 10 , 11 , 12 , 13 , 14 , 15 , 16 },
                {17 , 18 , 19 , 20 , 21 , 22 , 23 , 24 },
                {25 , 26 , 27 , 28 , 29 , 30 , 31 , 32 },
                {33 , 34 , 35 , 36 , 37 , 38 , 39 , 40 },
                {41 , 42 , 43 , 44 , 45 , 46 , 47 , 48 },
                {49 , 50 , 51 , 52 , 53 , 54 , 55 , 56 },
                {57 , 58 , 59 , 60 , 61 , 62 , 63 , 64 },
                {65 , 66 , 67 , 68 , 69 , 70 , 71 , 72 },
                {73 , 74 , 75 , 76 , 77 , 78 , 79 , 80  }
        };*/

        int r = 40;//40
        int m = matrix.length;
        int n = matrix[0].length;
//        int m = 142;
//        int n = 70;

        /*int circle = m/2;
        if(m>n){
            circle = n/2;
        }

        int [] row = new int[circle];// 邊長陣列
        for(int i=0;i<circle;i++){
            row[i] = (2*(m - 2*i)) + (2*(n - 2*i)) -4;
        }

        System.out.println(Arrays.toString(row));
        int max = 0;
        int count;


        for (int i = 2; i <= row[0]; i++) {
            count = 0;
            for(int j=0;j<row.length;j++){
                if(row[j] % i == 0){
                    count ++;
                    if(count == row.length){
                        max = i;
                        break;
                    }
                }
            }
        }
        long sum = row[0];
        for(int i=1;i<row.length;i++){
            sum = sum * row[i];
        }

        System.out.println(max + " | " + sum);

        long maxDuplicate = sum/max;//// 邊長最大公倍數*/
//        long round = r % maxDuplicate;

//        System.out.println(round);
        matrix = matrixRotation(r,matrix);

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    int [][] matrixRotation(int r,int[][] matrix) {
        List<Integer> lstLine = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int circle = m/2;
        if(m>n){
            circle = n/2;
        }
        int [] row = new int[circle];// 邊長陣列
        for(int i=0;i<circle;i++){
            row[i] = (2*(m - 2*i)) + (2*(n - 2*i)) -4;
        }
        int x,y,k;
        for(int c=0;c<circle;c++){
            lstLine.clear();
            x=c;
            y=c;
            k=2*c;
            // Step 1 get OutLine,InLine
            for(int i=0;i<m-k;i++){
                lstLine.add(matrix[x+i][y+0]);
            }
            for(int i=1;i<n-k;i++){
                lstLine.add(matrix[x+m-1-k][x+i]);
            }
            for(int i=1;i<m-k;i++){
                lstLine.add(matrix[x+m-1-i-k][x+n-1-k]);
            }
            for(int i=1;i<n-1-k;i++){
                lstLine.add(matrix[x+0][x+n-1-i-k]);
            }
            int tmp;
            for(int i=0;i<r%row[c];i++){
                tmp = lstLine.get(lstLine.size()-1);
                lstLine.remove(lstLine.size()-1);
                lstLine.add(0,tmp);
            }
            int index = 0;
            for(int i=0;i<m-k;i++){
                matrix[x+i][y+0] = lstLine.get(index);
                index++;
            }
            for(int i=1;i<n-k;i++){
                matrix[x+m-1-k][x+i] = lstLine.get(index);
                index++;
            }
            for(int i=1;i<m-k;i++){
                matrix[x+m-1-i-k][x+n-1-k] = lstLine.get(index);
                index++;
            }
            for(int i=1;i<n-1-k;i++){
                matrix[x+0][x+n-1-i-k] = lstLine.get(index);
                index++;
            }
        }
        return matrix;
    }

    public void runTask1(){
//        int k = 4;
        int k = 5;
//        int arr[] = {1,2,3,4,10,20,30,40,100,200};
//        int arr[] = {12,2,43,45,10,320,30,40,100,200};
        int arr[] = {
                4504, 1520, 5857, 4094, 4157, 3902, 822, 6643,
                2422, 7288, 8245, 9948, 2822, 1784, 7802, 3142,
                9739, 5629, 5413, 72 // 5958
        };
        long msg = angryChildren(k,arr);
        System.out.println(msg);
    }

    /**
     * 1,2,3,4
     * | 1-2 | + | 1-3 | + | 1-4 | + | 2-3 | + | 2-4 | + | 3-4 | = 10
     */
    long angryChildren(int k, int[] packets) {
        int len = packets.length;
        int temp;
        Sort sort = new Sort();
        packets = sort.bubbleSort(packets);
        show(Arrays.toString(packets));
        long num,sum;
        long min = -1;
        for(int x=0;x<len-k-1;x++){
            sum = 0;
            for(int i=x;i<k+x;i++){
                for(int j=i+1;j<k+x;j++){
                    num = packets[j] - packets[i];
                    sum = sum + num;
                }
            }
            if(min == -1){
                min = sum;
            }
            if(min > sum){
                min = sum;
            }
        }
        return min;
    }

    public void show(String msg){
        System.out.println(msg);
    }
    public static void main(String args[]){
        new HardExam_s1();
    }
}
