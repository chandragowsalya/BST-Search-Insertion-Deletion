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

// https://leetcode.com/problems/delete-node-in-a-bst/submissions/
class Solution {
    // 1. need to find where the node is present pass ( root, data to be deleted)
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        else if( key < root.val){ // if target lesser than root
           root.left= deleteNode(root.left,key);
        }
        else if( key > root.val){ // if target greater than root
           root.right= deleteNode(root.right,key);

        }
        else if(root.left ==null || root.right == null){
            if(root.left == null && root.right == null){
                //delete(root.val);  // the deletion node not have any child
                root = null;
            }
            else if(root.left ==null){
                TreeNode temp = root;  // deletion node have 1 child
                root = root.right;
                temp = null;
            }
            else if(root.right == null){
                TreeNode temp = root;
                root = root.left;
                //delete(temp.val);
                temp = null;
                
            }
        }
        else{  // deletion node have two child
        
        
        
        TreeNode temp = findMin(root.right); // find min from right subtree
        root.val = temp.val; // replace with root
        root.right = deleteNode(root.right,temp.val); // delete the value from     where we find min
        }
       
    
        return root;
    }
    public TreeNode findMin(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}
