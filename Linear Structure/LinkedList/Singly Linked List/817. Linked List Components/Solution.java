class Solution {
    public int numComponents(ListNode head, int[] value) {
        Set<Integer> set = new HashSet<>(Arrays.stream(value).boxed().collect(Collectors.toList()));
        
        int res = 0;
        while (head != null){
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) res++;
            head = head.next;
        }
        return res;
    }
}