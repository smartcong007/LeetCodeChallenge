import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengcong on 2017/8/16.
 * description:给定两个非空链表，链表的元素是一个0-9的整数，一个链表就代表一个非负整数的每一位，注意链表的顺序跟整数的位的顺序刚好相反，求这两个链表对应的整数相加后得到的整数的链表表示
 */
public class AddTwoNumbers {

    public class ListNode{

        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }

    }

    //比较💩
    public ListNode addTwoNumbers_mime(ListNode l1, ListNode l2) {

        if(l1.val == 0 && l1.next == null){
            return l2;
        }
        if(l2.val == 0 && l2.next == null){
            return l1;
        }
        List<Integer> list = new ArrayList<>();

        ListNode h1 = l1;
        ListNode h2 = l2;
        while (h1 != null&&h2 != null){

            int tol = h1.val+h2.val;
            if(tol>9){
                list.add(tol%10);
                if(h1.next != null){
                    h1.next.val++;
                }else if(h2.next != null){
                    h2.next.val++;
                }else {
                    list.add(1);
                    h1 = h1.next;
                    h2 = h2.next;
                    break;
                }
            }else {
                list.add(tol);
            }
            h1 = h1.next;
            h2 = h2.next;
        }

        while (h1 != null){
            if(h1.val<10) {
                list.add(h1.val);
                h1 = h1.next;
            }else {
                list.add(h1.val%10);
                h1 = h1.next;
                if(h1 != null){
                    h1.val++;
                }else {
                    list.add(1);
                    break;
                }
            }
        }

        while (h2 != null){
            if(h2.val<10) {
                list.add(h2.val);
                h2 = h2.next;
            }else {
                list.add(h2.val%10);
                h2 = h2.next;
                if(h2 != null){
                    h2.val++;
                }else {
                    list.add(1);
                    break;
                }
            }
        }

        int length = list.size();

        ListNode nodes[] = new ListNode[length];
        for(int i=0;i<length;i++){
            nodes[i] = new ListNode(list.get(i));
        }

        for (int i=0;i<length-1;i++){
            nodes[i].next = nodes[i+1];
        }
        return nodes[0];
    }

    //非常💯的实现
    public ListNode addTwoNumbers_better(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

}
