## 1.Merge Intervals
* Sort the intervals by the start time first
* Use two integer values to save the start and end time of previous intervals
* If the start end of current intervals is smaller than preivous end time, we need to update the end value


```java
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
```

## 2.Follow - Up - Generate Overlapped Interval

```java
public class Solution {
    public List<Interval> Intersection(List<Interval> listA, List<Interval> listB) {
        List<Interval> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < listA.size() && j < listB.size()) {
            int aStart = listA.get(i).start;
            int aEnd = listA.get(i).end;
            int bStart = listB.get(j).start;
            int bEnd = listB.get(j).end;

            if (aEnd <= bStart) {
                i++;
            } else if (bEnd <= aStart) {
                j++;
            } else {
                Interval temp = new Interval(Math.max(aStart, bStart), Math.min(aEnd, bEnd));
                res.add(temp);
                if (aEnd <= bEnd) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}
```