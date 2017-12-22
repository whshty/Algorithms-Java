public class ZigzagIterator {
    List<Iterator<Integer>> itrs;
    int index;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        itrs = new ArrayList<>();
        itrs.add(v1.iterator());
        itrs.add(v2.iterator());
    }

    public int next() {
        hasNext();
        int val = itrs.get(index).next();
        index = (index+1) % itrs.size();
        return val;
    }

    public boolean hasNext() {
        if( itrs.size() == 0 ) return false;
        else if( itrs.get(index).hasNext()) return true;
        else {
            while(!itrs.get(index).hasNext()) {
                itrs.remove(index);
                if(itrs.size() == 0 ) return false;
                index %= itrs.size();
            }
            return true;
        }
    }
}