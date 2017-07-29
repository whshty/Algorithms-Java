public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // corner case checked 
        if( intervals.size() <= 1) return intervals;
        List<Interval> res = new LinkedList<>();
        // sort by starting point using an anonymous comparator
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval : intervals){
            // overlapping
            if(interval.start <= end) end = Math.max(end, interval.end);
            else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}