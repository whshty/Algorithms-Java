public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> listItr;
    Iterator<Integer> valItr;

    public Vector2D(List<List<Integer>> vec2d) {
        listItr = vec2d.iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return valItr.next();
    }

    @Override
    public boolean hasNext() {
        while( (valItr == null || !valItr.hasNext()) && listItr.hasNext()){
            valItr = listItr.next().iterator();
        }
        return valItr != null && valItr.hasNext();
    }
}
