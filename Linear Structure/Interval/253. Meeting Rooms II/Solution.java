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


public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if ( intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b)->(a.start - b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->(a - b));
        
        for (Interval time : intervals) {
            if ( !minHeap.isEmpty() && minHeap.peek() <= time.start){
                minHeap.poll();    
            }
            minHeap.offer(time.end);
        }
        return minHeap.size();
    }
}