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
 // This solution creates the arraylist for every path and adds the present number to it. With recursion we go deeper and keep adding elements to the list. At the leaf we add it to the global list.
class Solution {
    List<List<Integer>> lists = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        sumItUp(root, 0, targetSum, new ArrayList());
        return lists;
    }

    private void sumItUp(TreeNode root, int runningNumber, int targetSum, List<Integer> runningList) {
        if(root==null) return;
        int sum = runningNumber+root.val;
        runningList.add(root.val);
        if(root.left==null && root.right==null && sum==targetSum) {
            lists.add(runningList);
            return;
        }
        sumItUp(root.left, sum, targetSum, new ArrayList(runningList));
        sumItUp(root.right, sum, targetSum, new ArrayList(runningList));
    }
}
