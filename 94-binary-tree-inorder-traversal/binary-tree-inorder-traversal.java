/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> In = new ArrayList<>();
       
        if(root == null)
        {
            return In;
        }
        
        inorder(root, In);
        
        return In;
    }
    
    private void inorder(TreeNode root, List<Integer> In)
    {
        if(root == null)
        {
            return;
        }
    
        inorder(root.left, In);
        
        In.add(root.val);
    
        inorder(root.right, In);
    }
}