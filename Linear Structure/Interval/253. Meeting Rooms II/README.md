## 1.1.Scan Line
* O(nlogn)
*  When we need extra room, end event occurs and there is a starting event happened before that ( generate overlapping)
* Create a variable "current end time" to point to the current end event, and move the start event pointer

```
|_____|
      |______|
|________|
        |_______|

```
Then, the start time array and end time array after sorting appear link follows

```
||    | |
      |  |  |  | 
```
Initially, endsItr points to the first end event, and we move i which is the start event pointer. As we examine the start events, we’ll find the first two start events happen before the end event that endsItr points to, so we need two rooms (we magically created two rooms), as shown by the variable rooms. Then, as i points to the third start event, we’ll find that this event happens after the end event pointed by endsItr, then we increment endsItr so that it points to the next end event. What happens here can be thought of as one of the two previous meetings ended, and we moved the newly started meeting into that vacant room, thus we don’t need to increment rooms at this time and move both of the pointers forward.
Next, because endsItr moves to the next end event, we’ll find that the start event pointed by i happens before the end event pointed by endsItr. Thus, now we have 4 meetings started but only one ended, so we need one more room. And it goes on as this.



```java
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for( int i = 0 ; i < intervals.length ; i++ ){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int curEndIndex = 0;
        for( int i = 0 ; i < start.length ; i++ ){
            if( start[i] < end[curEndIndex]) count++;
            else curEndIndex++;
        } 
        return count;
        
    }
}
```

## 1.2.Heap
* O(nlogn)
* minHeap for saving the end times

```java
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if ( intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b)->(a.start - b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (Interval i : intervals) {
            // dont need the first interval anymore, poll it out
            if ( !minHeap.isEmpty() && minHeap.peek() <= i.start){
                minHeap.poll();    
            }
            // Use or Create New Room
            minHeap.offer(i.end);
        }
        return minHeap.size();
    }
}
```


## 1.3.TreeMap
* Sort using TreeMap by start and end 
* Key is time
* Value is frequency is this time, start is postive and end is negative

```java
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for(Interval i : intervals){
            map.put(i.start,map.getOrDefault(i.start,0)+1);
            map.put(i.end,map.getOrDefault(i.end,0)-1);
        }
        int count = 0 , curRoom = 0;
        for( int i : map.keySet()){
            count = Math.max(count,curRoom += map.get(i));
        }
        return count;
    }
}
```

## 2.Follow Up - Generate the Interval of Max Number of Room


```
public class Solution {
    public List<Interval> findMostOverlappedInterval(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;

        Map<Integer, Integer> map = new HashMap<>();
        Interval preOverlap = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            int startVal = -1, endVal = -1;

            if (cur.start < preOverlap.end) startVal = cur.start;
            else {
                preOverlap = cur;
                continue;
            }
            if (cur.end <= preOverlap.end) {
                endVal = cur.end;
            } else {
                endVal = preOverlap.end;
                preOverlap.end = cur.end;
            }
            for (int j = startVal; j < endVal; j++) {
                map.put(j, map.getOrDefault(j, 1) + 1);
            }
        }
        // if no over lap
        if (map.size() == 0) return intervals;

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res.clear();
                res.add(new Interval(entry.getKey(), -1));
            } else if (entry.getValue() == max) {
                Interval temp = res.get(res.size() - 1);
                if( temp.end == -1 ){
                    temp.end = entry.getKey();
                    res.set(res.size() - 1, temp);
                } else {
                    res.add(new Interval(entry.getKey(), -1));
                }
            }
        }
        return res;
    }
}

class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

```