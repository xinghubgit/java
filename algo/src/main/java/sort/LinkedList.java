package sort;

/**
 * @date 2020/11/24
 */

public class LinkedList {
    public static void main(String[] args) {

        ListNode node = generateListNode(1);
        node.next = generateListNode(2);
        node.next.next = generateListNode(4);

        ListNode node1 = generateListNode(1);
        node1.next = generateListNode(3);
        node1.next.next = generateListNode(4);

        ListNode listNode = mergeTwoLists(node, node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    static ListNode generateListNode(int val) {
        return new ListNode(val);
    }

    static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode listNode = new ListNode();
        if (node1 == null && node2 == null) {
            return null;
        } else if (node1 == null && node2 != null) {
            listNode.val = node2.val;
            listNode.next = mergeTwoLists(null, node2.next);
        } else if (node2 == null && node1 != null) {
            listNode.val = node1.val;
            listNode.next = mergeTwoLists(node1.next, node2);
        } else {
            if (node1.val >= node2.val) {
                listNode.val = node2.val;
                listNode.next = mergeTwoLists(node1, node2.next);
            } else {
                listNode.val = node1.val;
                listNode.next = mergeTwoLists(node1.next, node2);
            }
        }
        return listNode;
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
