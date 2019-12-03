package easy;



class addTwoNumbers02
{
    
    static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l1Current = l1; 
        l1Current.next = new ListNode(0);
        l1Current = l1Current.next;
        l1Current.next  = new ListNode(8);
        l1Current = l1Current.next;
        ListNode l2 = new ListNode(5);
        ListNode l2Current = l2;
        l2Current.next = new ListNode(6);
        l2Current = l2Current.next;
        l2Current.next = new ListNode(4);
        l2Current = l2Current.next;

        ListNode ans = addTwoNumbers(l1, l2);

        System.out.print("[");
        while(ans!=null)
        {
            System.out.print(ans.val + ",");
            ans = ans.next;
        }
        System.out.print("]");
    }


    static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode result  = new ListNode(0);
        ListNode resCurrent = result;
        int carry = 0;
        while(l1 != null || l2 != null)
        {
            int currentSum = 0; 
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;
            currentSum = l1Val + l2Val + carry;
            carry  = currentSum /10;
            resCurrent.next = new ListNode(currentSum % 10);
            resCurrent  = resCurrent.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
            
        }
        if(carry>0)
        {
            resCurrent.next = new ListNode(carry);
        }
        return result.next;
    }
}