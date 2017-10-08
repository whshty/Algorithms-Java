package Solution;

import java.util.*;
public class Solution {
    // public static void main(String[] args) {
    //     List<Integer> list1 = new ArrayList<>();
    //     list1.add(1);
    //     list1.add(3);
    //     list1.add(5);
    //     list1.add(7);


    //     List<Integer> list2 = new ArrayList<>();
    //     list2.add(2);
    //     list2.add(8);
    //     list2.add(11);
    //     list2.add(19);




    //     List<List<Integer>> input = new ArrayList<>();
    //     input.add(list1);
    //     input.add(list2);



    //     Solution itr = new Solution();
    //     itr.ListIterator(input);

    //     while(itr.hasNext()){
    //         System.out.print(itr.next() + ",");
    //     }
    // }
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

