class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode node = root;
        while( node != null ){
            node = node.next;
            len++;
        }
        int count = len / k , remain = len % k;
        node = root;
        ListNode cur = null;

        for( int i = 0 ; node != null && i < k ; i++ , remain-- ){
            res[i] = node;
            for( int j = 0 ; j < count + ( remain > 0 ? 1 : 0 ) ; j++ ){
                cur = node;
                node = node.next;
            }
            cur.next = null;
        }
        return res;
    }
}
