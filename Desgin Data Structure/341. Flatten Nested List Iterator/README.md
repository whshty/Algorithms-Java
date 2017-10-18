```java
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    // Create stack
    Deque<NestedInteger> deque = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for( int i = nestedList.size() - 1 ; i >= 0 ;i--){
            deque.addLast(nestedList.get(i));
        }
    }
    @Override
    public Integer next() {
        return deque.removeLast().getInteger();
    }
    @Override
    public boolean hasNext() {
        while( !deque.isEmpty()){
            NestedInteger cur = deque.peekLast();
            if(cur.isInteger()){
                return true;
            }
            deque.removeLast();
            for( int i = cur.getList().size() - 1 ; i >= 0 ; i--){
                deque.addLast(cur.getList().get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
```