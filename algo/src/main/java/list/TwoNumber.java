package list;

/**
 * @date 2020/11/24
 */

public class TwoNumber {
    public static void main(String[] args) {
        ListNode node = generateListNode(2);
        node.next = generateListNode(4);
        node.next.next = generateListNode(3);

        ListNode node1 = generateListNode(5);
        node1.next = generateListNode(6);
        node1.next.next = generateListNode(4);

        ListNode twoNumber = addTwoNumber(node, node1, 0);
        while (twoNumber != null) {
            System.out.println(twoNumber.val);
            twoNumber = twoNumber.next;
        }
    }

    static ListNode generateListNode(int val) {
        return new ListNode(val);
    }


    static ListNode addTwoNumber(ListNode node1, ListNode node2, int carry) {
        ListNode node = new ListNode();

        if (node1 == null && node2 == null) {
            return carry == 0 ? null : new ListNode(carry);
        } else if (node1 == null && node2 != null) {
            node.val = (node2.val + carry) % 10;
            carry = Math.floorDiv((node2.val + carry), 10);
            node.next = addTwoNumber(null, node2.next, carry);
        } else if (node1 != null && node2 == null) {
            node.val = (node1.val + carry) % 10;
            carry = Math.floorDiv((node1.val + carry), 10);
            node.next = addTwoNumber(node1.next, null, carry);
        } else {
            node.val = (node1.val + node2.val + carry) % 10;
            carry = Math.floorDiv((node1.val + node2.val + carry), 10);
            node.next = addTwoNumber(node1.next, node2.next, carry);

        }
        return node;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;

    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
