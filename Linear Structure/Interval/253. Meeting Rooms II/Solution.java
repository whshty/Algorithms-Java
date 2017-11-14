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
            if( start[i] < end[curEndIndex]) {
                System.out.println(start[i]); // the overlapped value
                count++;
            }
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
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 7));
        input.add(new Interval(4, 8));
        input.add(new Interval(5, 9));

        input.add(new Interval(11, 13));
        input.add(new Interval(11, 13));
        input.add(new Interval(11, 13));


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

        int roomCount = Integer.MIN_VALUE;
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

            for (int j = startVal; j <= endVal; j++) {
                map.put(j, map.getOrDefault(j, 1) + 1);
                roomCount = Math.max(map.get(j), roomCount);
            }
        }


        // if no over lap
        if (map.size() == 0) return intervals;

        int start = -1;
        int end = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != roomCount) continue;
            int keyValue = entry.getKey();
            if( start == - 1) {
                start = keyValue;
                continue;
            }

            if (end + 1 != keyValue && end != -1) {
                res.add(new Interval(start,end));
                start = keyValue;
                end = keyValue;
            } else {
                end = keyValue;
            }
        }
        res.add(new Interval(start,end));
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


// Follow Up - Generate Interval by Frequency

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        //[1,3],[2,5],[4,5]
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 5));
        input.add(new Interval(4, 5));
        input.add(new Interval(4, 5));

        Solution sol = new Solution();

        List<int[]> res = sol.minMeetingRooms(input);

        for (int[] temp : res) {
            System.out.println(temp[0] + " " + temp[1] + " " + temp[2]);
        }
    }

    public List<int[]> minMeetingRooms(List<Interval> intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            for (int i = interval.start; i < interval.end; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        List<int[]> res = new ArrayList<>();
        int start = -1, end = -1, freq = -1;
        for (Integer key : map.keySet()) {
            int curFreq = map.get(key);

            if (start == -1) {
                start = key;
                end = key;
                freq = map.get(start);
                continue;
            }

            if (curFreq == freq) {
                end = key;
            } else {
                int[] temp = new int[3];
                temp[0] = start;
                temp[1] = end + 1;
                temp[2] = map.get(start);
                res.add(temp);
                start = key;
                end = key;
                freq = curFreq;
            }
        }
        res.add(new int[]{start,end+1,freq});
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
