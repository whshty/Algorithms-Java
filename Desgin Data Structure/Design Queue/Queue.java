public class Queue {

    private long[] nums;
    private int maxSize;
    private int count;
    private int head;
    private int tail;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        nums = new long[maxSize];
        count = 0;
        head = 0;
        tail = -1;
    }

    public void add(long value) {
        nums[++tail] = value;
        count++;
    }


    public long remove() {
        count--;
        return nums[head++];
    }


    public boolean isEmpty() {
        return (count == 0);
    }


    public boolean isFull() {
        return (count== maxSize - 1);
    }

    public int size() {
        return count;
    }
}
