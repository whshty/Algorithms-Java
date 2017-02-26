package NestedList;

import java.util.*;
import static java.util.Arrays.asList;


public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Object> input = nestedList(1,nestedList(2,nestedList(3,4)),nestedList(5,6,7),8,nestedList(nestedList(9,10)));
        //List<Integer> res1 = sol.flattenByRecursion(input);
        //System.out.println(res1);
        List<Integer> res2 = sol.flattenByStack(input);
        System.out.print(res2);
    }

    public List<Integer> flattenByRecursion(List<?> list){
        List<Integer> res = new LinkedList<Integer>();
        helper(list,res);
        return res;

    }

    public void helper(List<?> input , List<Integer> res){
        for ( Object item : input){
            if( item instanceof  List<?>) {
                helper((List<?>) item, res);
            } else {
                res.add((Integer) item);
            }
        }
    }

    public List<Integer> flattenByStack(List<?> list){
        Stack<Object> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for( int i = list.size() - 1 ; i >= 0 ; i-- ){
            stack.push(list.get(i));
        }
        while( !stack.isEmpty()){
            Object item = stack.pop();
            if ( !(item instanceof List<?>)) {
                res.add((Integer)  item);
            } else {
                for( int i = (((List<?>) item).size()) - 1 ; i>= 0 ; i--){
                    stack.push(((List<?>) item).get(i));
                }
            }

        }
        return  res;
    }


    private static List<Object> nestedList(Object... objs){
        return asList(objs);
    }
}
\