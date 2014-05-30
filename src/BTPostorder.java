/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTPostorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node;
        TreeNode pre = root;
        stack.push(root);
        while(!stack.isEmpty()){
            node = stack.peek();
            if((null == node.left && null == node.right) ||  //leaf
                (pre == node.right || pre == node.left))     //previous one is node's right child
            {
                res.add(node.val);
                stack.pop();
                pre = node;
            } else {
                if (null != right) stack.push(node.right);
                if (null != left) stack.push(node.left);
            }
        }
        return res;
    }
}