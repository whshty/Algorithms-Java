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

    //     List<Integer> list3 = new ArrayList<>();
    //     list3.add(0);
    //     list3.add(4);
    //     list3.add(6);


    //     List<List<Integer>> input = new ArrayList<>();
    //     input.add(list1);
    //     input.add(list2);
    //     input.add(list3);


    //     Solution itr = new Solution();
    //     itr.ListIterator(input);

    //     while(itr.hasNext()){
    //         System.out.print(itr.next() + ",");
    //     }
    // }
    PriorityQueue<Index> heap;
    List<List<Integer>> input;
    public void ListIterator(List<List<Integer>> list){
        heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        input = list;

        for( int i = 0 ; i < list.size() ; i++ ){
            int val = list.get(i).get(0);
            Index temp = new Index(val,0,i);
            heap.add(temp);
        }
    }

    public boolean hasNext(){
        return !heap.isEmpty();
    }

    public int next(){
        Index temp = heap.poll();
        int curVal = temp.val;

        int x = temp.x;
        int y = temp.y;

        List<Integer> curList = input.get(y);

        if( x  + 1 < curList.size() ){
            int nextVal = curList.get(x+1);
            int nextX = x + 1;
            Index next = new Index(nextVal,nextX,y);
            heap.add(next);
        }
        return curVal;
    }
}

class Index{
    int val;
    int x;
    int y;
    Index(int value , int xPos ,int yPos){
        this.val = value;
        this.x = xPos;
        this.y = yPos;
    }

}