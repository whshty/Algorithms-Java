public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = n + m - 1;
        while ( i >= 0 && j >= 0 ){
            if ( nums1[i] > nums2[j]){
                nums1[index] = nums1[i];
                i--;
                index--;
            } else {
                nums1[index] = nums2[j];
                j--;
                index--;
            }
        }
        while ( j >= 0 ){
            nums1[index] = nums2[j];
            index--;
            j--;
        }
    }
}

// Generate new res
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] input1 = new int[]{5};
        int[] input2 = new int[]{1,2,3,4};

        Solution sol = new Solution();
        int[] res = sol.merge(input1,input2);

        for( int i : res ) System.out.print(i);

    }
    public int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = m - 1;
        int j = n - 1;
        int index = n + m - 1;
        int[] res = new int[m+n];

        while ( i >= 0 && j >= 0 ){
            if ( nums1[i] > nums2[j]){
                res[index] = nums1[i];
                i--;
                index--;
            } else {
                res[index] = nums2[j];
                j--;
                index--;
            }
        }
        while ( i >= 0 ){
            res[index] = nums1[i];
            index--;
            i--;
        }
        while ( j >= 0 ){
            res[index] = nums2[j];
            index--;
            j--;
        }
        return res;
    }
}


// Merge Two Sorted Array Iterator
import java.util.*;
public class Solution {
     public static void main(String[] args) {
         List<Integer> list1 = new ArrayList<>();
         list1.add(1);
         list1.add(3);
         list1.add(5);
         list1.add(7);


         List<Integer> list2 = new ArrayList<>();
         list2.add(2);
         list2.add(8);
         list2.add(11);
         list2.add(19);




         List<List<Integer>> input = new ArrayList<>();
         input.add(list1);
         input.add(list2);



         Solution itr = new Solution();
         itr.ListIterator(input);

         while(itr.hasNext()){
             System.out.print(itr.next() + ",");
         }
     }
    List<Integer> listOne;
    List<Integer> listTwo;
    int i;
    int j;
    public void ListIterator(List<List<Integer>> list){
        listOne = list.get(0);
        listTwo = list.get(1);
        i = 0;
        j = 0;
    }

    public boolean hasNext(){
        return i < listOne.size() || j < listTwo.size();
    }

    public int next(){
        int res;
        if( i > listOne.size() - 1 ) {
            res = listTwo.get(j);
            j++;
            return res;
        }
        if( j > listTwo.size() - 1 ){
            res = listOne.get(i);
            i++;
            return res;
        }

        if( listOne.get(i) < listTwo.get(j)) {
            res = listOne.get(i);
            i++;
        } else {
            res = listTwo.get(j);
            j++;
        }
        return res;
    }
}



