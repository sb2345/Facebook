class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { 
        val = x; 
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int size = lists.length;
        if (size == 1) {
            return lists[0];
        }
        int i = 2;
        while (i / 2 < size) {
            for (int j = 0; j < size; j += i) {
                ListNode p = lists[j];
                if ((j + i / 2) < size) {
                    p = mergeTwo(p, lists[j + i / 2]);
                    lists[j] = p;
                }
            }
            i *= 2;
        }
        return lists[0];
    }
    
    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode p = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }
        return preHead.next;
    }
    
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(2);
        ListNode n13 = new ListNode(4);
        ListNode n21 = new ListNode(3);
        ListNode n22 = new ListNode(5);
        ListNode n31 = new ListNode(6);
        
        n11.next = n12;
        n12.next = n13;
        n21.next = n22;
        ListNode[] lst = new ListNode[] {
            n11, n21, n31
        };
        ListNode ans = sol.mergeKLists(lst);
        
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    } 
}