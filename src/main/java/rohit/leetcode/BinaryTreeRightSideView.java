package rohit.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode current = queue.poll();
                if(i == 0){
                    result.add(current.val);
                }
                result.addAll(rightSideView(root.right));

                result.addAll(rightSideView(root.left));

            }
        }

        return result;

    }
}
