### Pointers
*  When we need extra room, end event occurs and there is a starting event happened before that ( generate overlapping)
* Create a variable "current end time" to point to the current end event, and move the start event pointer

```
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length;i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int curEnd = 0; 
        for( int i = 0 ; i < start.length ; i++){
            if( start[i] < end[curEnd]) count++;
            else curEnd++;
        }
        return count;
    }
}
```

### Heap
* minHeap for saving the end times

```
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if ( intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b)->(a.start - b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (Interval i : intervals) {
            if ( !minHeap.isEmpty() && minHeap.peek() <= i.start){
                minHeap.poll();    
            }
            minHeap.offer(i.end);
        }
        return minHeap.size();
    }
}
```