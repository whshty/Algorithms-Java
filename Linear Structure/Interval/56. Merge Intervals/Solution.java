class Solution {
    public List<Interval> merge(List<Interval> list) {
        List<Interval> res = new ArrayList<>();
        if( list == null || list.size() == 0 ) return res;
        if( list.size() == 1 ) return list;
        list.sort((a, b) -> Integer.compare(a.start, b.start));
        
        int start = list.get(0).start;
        int end = list.get(0).end;
        
        for( Interval i : list ){
            // [1,3],[2,6]
            if( i.start <= end ){
                end = Math.max(end,i.end);
            } else {
                res.add(new Interval(start,end));
                start = i.start;
                end = i.end;
            }
        }
        res.add(new Interval(start,end));

        return res; 
    }
}