package rohit.leetcode;

import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    public BinaryTree(){
        root = null;
    }
    private void printInOrderRecursion(TreeNode root){
        if(root == null)
            return;

        printInOrderRecursion(root.left);
        System.out.println("Recursion :" + root.key);
        printInOrderRecursion(root.right);

    }
    private void printPreOrderRecursion(TreeNode root){
        if(root == null)
            return;
        System.out.println("Recursion :" + root.key);
        printPreOrderRecursion(root.left);
        printPreOrderRecursion(root.right);

    }
    private void printPostOrderRecursion(TreeNode root){
        if(root == null)
            return;
        printPostOrderRecursion(root.left);
        printPostOrderRecursion(root.right);
        System.out.println("Recursion :" + root.key);
    }
    private void printInOrderStack(TreeNode root){
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
            while (current!=null){
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();

            System.out.println("Stack :"+current.key);
            current = current.right;
        }

    }
    private void printPreOrderStack(TreeNode root){
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode current = stack.pop();
            if (current!=null) {
                System.out.println("Stack :"+current.key);
                stack.add(current.right);
                stack.add(current.left);
            }
        }

    }
    private void printPostOrderStack(TreeNode root){
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
         //       442211

            // Check for empty stack
            if(stack.empty()) return;
            // stack      42211
            // root
            root = stack.pop();

            if(!stack.empty() && stack.peek() == root)
                root = root.right;
            else {
                System.out.println("Stack :"+root.key);
                //4 ->
                root = null;
            }
        }

    }
    private void printInOrder(){
        printInOrderRecursion(root);
        printInOrderStack(root);
    }

    private void printPreOrder(){
        printPreOrderRecursion(root);
        printPreOrderStack(root);
    }

    private void printPostOrder(){
        printPostOrderRecursion(root);
        printPostOrderStack(root);
    }


    public static void main(String[] args) {
        /*
        *         1
        *    2        3
        *  4   5
        * */
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        tree.printInOrder();
        tree.printPreOrder();
        tree.printPostOrder();
    }
}
