package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/11/24
 */

public class GreaterSumTree {

    public static Integer pre = 0;


    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(1);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(2);
        node.left.right.right = new TreeNode(3);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(7);
        node.right.right.right = new TreeNode(8);

        bstToGst(node);

        ArrayList<TreeNode> integers = new ArrayList<>();
//        iterater(node, integers);
//        System.out.println("____________");
//        Integer sum = integers.stream().map(x -> x.val).reduce(0, Integer::sum);
//        for (TreeNode node1 : integers) {
//            int oldValue = node1.val;
//            node1.val = sum;
//            sum = sum - oldValue;
//        }



//        System.out.println(testInteger.sum);
//        System.out.println("____________");
//        TreeNode iterator = iterater(node, testInteger);
//        System.out.println("____________");
//        integers.clear();
        iterater(node, integers);
        System.out.println("____________");
    }

    static TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }

    static TreeNode iterater(TreeNode node, TestInteger testInteger) {
        if (node == null) {
            return node;
        }
        if (node.left != null) {
            iterater(node.left, testInteger);
        }
        int oldValue =  node.val;
        node.val = testInteger.sum ;
        testInteger.sum = testInteger.sum - oldValue;
        System.out.println(node.val);
        if (node.right != null) {
            iterater(node.right, testInteger);
        }

        return node;
    }

    static void iterater(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            iterater(node.left, list);
        }
        list.add(node);
        System.out.println(node.val);
        if (node.right != null) {
            iterater(node.right, list);
        }

    }
}

class TestInteger {
    Integer sum;
}
