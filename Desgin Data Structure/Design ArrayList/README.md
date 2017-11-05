```java
public class Solution {
    private static final int SIZE_FACTOR = 5;
    private Object data[];
    private int index;
    private int size;

    public Solution() {
        this.data = new Object[SIZE_FACTOR];
        this.size = SIZE_FACTOR;
    }

    public void add(Object obj) {

        if (this.index == this.size - 1) {
            increaseSize();
        }
        data[this.index] = obj;
        this.index++;
    }

    private void increaseSize() {
        this.size = this.size + SIZE_FACTOR;
        Object newData[] = new Object[this.size];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    public Object get(int index) throws Exception {
        if (index > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        }
        if (index < 0) {
            throw new Exception("Negative Value");
        }
        return this.data[index];
    }

    public void remove(int index) throws Exception {
        if (index > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        }
        if (index < 0) {
            throw new Exception("Negative Value");
        }

        for (int i = index; i < this.data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        this.index--;
    }

    public static void main(String[] args) throws Exception {
        Solution list = new Solution();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");

        list.remove(5);
        System.out.println(list.get(7));
    }

}
```