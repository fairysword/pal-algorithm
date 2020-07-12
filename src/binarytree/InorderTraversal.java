package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            } else { // 左子树为空
                list.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }

}
