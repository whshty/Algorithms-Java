```java
public class Solution extends Relation {
    public int findCelebrity(int n) {
        if ( n <= 0 ) return -1;
        if ( n == 1 ) return 0;
        // step 1 : find candidate
        int celebrity = 0;
        for ( int cur = 1 ; cur < n ; cur++ ){
            if(knows(celebrity,cur)) celebrity = cur;
        }
        // step 2 : check the candidate 
        // check 1 : knows(candidate,i) ; i for all others before candidate -> false
        // check 2 : knows(i,candidate) , i for all ohters -> true (double check)
        for(int i = 0 ; i < n ; i++){
            if( i < celebrity && knows(celebrity,i)) return -1;
            if( !knows(i,celebrity)) return -1;
        }
        return celebrity;
    }
}
```