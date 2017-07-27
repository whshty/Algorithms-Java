
import java.io.*;

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
