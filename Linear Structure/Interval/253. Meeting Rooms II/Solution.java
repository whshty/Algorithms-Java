// Scan line
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

// PQ
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

// TreeMap 
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


// Generate the interval of max room
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 7));
        input.add(new Interval(4, 8));
        input.add(new Interval(5, 9));

        Solution sol = new Solution();

        List<Interval> res = sol.findMostOverlappedInterval(input);
        for (Interval i : res) {
            System.out.println(i.start + " " + i.end);
        }
    }

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
