// Qucik Sort
import java.io.*;
// Pick medium
class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        System.out.println("Hello Java");
        //int[] input = new int[]{5,3,6,8,1,2,10,7,8,2,1,11,19,12,2};
        int[] input = new int[]{5,3,6,8,1};
        for( int i  : input){
            System.out.print(i + " ");
        }
        System.out.println();
        quickSort(input,0,input.length-1);
        
        for( int i  : input){
            System.out.print(i + " ");
        }
    }
    
    private static void quickSort(int[] arr, int low , int high){
        int i = low , j = high;
        int pivot = arr[( low + high ) >>> 1];
        while( i < j ){
            while ( arr[i] < pivot ) i++;
            while ( arr[j] > pivot ) j--;
            if ( i <= j ){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        if( low < j ){
            quickSort(arr,low,j);
        }

        if( i < high ){
            quickSort(arr,i,high);
        }   
    }
    
    private static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Cycle Sort
class Solution {
    public static void main (String[] args) throws java.lang.Exception {
        int[] test = {20,14,17,21,3,6,2,1,4,20};
        Solution sol = new Solution();
        sol.cycleSort(test);
        for( int i = 0 ; i < test.length ; i++ ){
            System.out.print(test[i] + ", ");
        }
    }
    public void cycleSort(int[] array){
        int pos;
        int cur;
        for(int i = 0 ; i < array.length - 1 ; i++){
            cur = array[i];
            pos = i;
            for( int j = i + 1 ; j < array.length ; j++ ){
                if( array[j] < cur ) pos++;
            }
            if( pos == i ) continue;
            while( cur == array[pos]) pos++;
            if( cur != array[pos]){
                int temp = array[pos];
                array[pos] = cur;
                cur = temp;
            }

            while( pos != i ){
                pos = i;
                for( int k = i + 1 ; k < array.length ; k++){
                    if( array[k] < cur ) pos++;
                }
                while( cur == array[pos] ) pos++;
                if( cur != array[pos]){
                    int temp = array[pos];
                    array[pos] = cur;
                    cur = temp;
                }
            }
        }
    }
}



