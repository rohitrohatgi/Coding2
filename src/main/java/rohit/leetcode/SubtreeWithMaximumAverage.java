package rohit.leetcode;

import sun.awt.geom.AreaOp;

/*
Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
A subtree of a tree is the node which have at least 1 child plus all its descendants. The average value of a subtree is the sum of its values, divided by the number of nodes.
 */
public class SubtreeWithMaximumAverage {
    class TreeNode {
        public TreeNode(){

        }
        int val;
        TreeNode[] children;
    }
    TreeNode maxNode = null;
    double max = Integer.MIN_VALUE;
    public TreeNode maximumAverageSubtree(TreeNode root) {
        if(root == null)
            return null;

        dfs(root);
        return maxNode;
    }

    private double[] dfs(TreeNode root) {
        if(root == null) return new double[]{0,0};
        double count = 1;
        double total = root.val;
        if(null != root.children) {
            for (TreeNode child : root.children) {
                double[] result = dfs(child);
                count += result[0];
                total += result[1];
            }
        }
        double avg = total/count;
        if(avg > max && count > 1){
            max = avg;
            maxNode = root;
        }
        return new double[]{count,total};
    }

    public static void main(String[] args) {
        /*
        		 20
               /   \
             12     18
          /  |  \   / \
        11   2   3 15  8

         */

        SubtreeWithMaximumAverage.TreeNode root = new SubtreeWithMaximumAverage().new TreeNode();
        root.val = 20;

        SubtreeWithMaximumAverage.TreeNode child1 = new SubtreeWithMaximumAverage().new TreeNode();
        child1.val = 12;
        SubtreeWithMaximumAverage.TreeNode child2 = new SubtreeWithMaximumAverage().new TreeNode();
        child2.val = 18;
        root.children = new TreeNode[]{child1,child2};

        SubtreeWithMaximumAverage.TreeNode child1_a = new SubtreeWithMaximumAverage().new TreeNode();
        child1_a.val = 11;
        SubtreeWithMaximumAverage.TreeNode child1_b = new SubtreeWithMaximumAverage().new TreeNode();
        child1_b.val = 2;
        SubtreeWithMaximumAverage.TreeNode child1_c = new SubtreeWithMaximumAverage().new TreeNode();
        child1_c.val = 3;
        child1.children = new TreeNode[]{child1_a,child1_b,child1_c};


        SubtreeWithMaximumAverage.TreeNode child2_a = new SubtreeWithMaximumAverage().new TreeNode();
        root.val = 15;
        SubtreeWithMaximumAverage.TreeNode child2_b = new SubtreeWithMaximumAverage().new TreeNode();
        root.val = 18;
        child2.children = new TreeNode[]{child2_a,child2_b};

        SubtreeWithMaximumAverage subtreeWithMaximumAverage = new SubtreeWithMaximumAverage();
        TreeNode result = subtreeWithMaximumAverage.maximumAverageSubtree(root);

        System.out.println(result.val);
    }
}
