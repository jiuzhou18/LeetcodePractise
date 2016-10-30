package leetcode;

public class PathSum_No437 {
	
	public int pathSum(TreeNode root, int sum) {
        int count = 0;
        if (root == null)
            return count;
        if (root.val == sum){
            count += 1;
        }
        if(root.left == null){
            if(root.right == null)
                return count;
            else{
                count += pathSum(root.right, sum);
                count += pathSuminchild(root.right, sum-root.val);
            }
        }
        else if(root.right == null){
            count += pathSum(root.left, sum);
            count += pathSuminchild(root.left, sum-root.val);
            
        }else{
            count += pathSum(root.right, sum);
            count += pathSuminchild(root.right, sum-root.val);
            count += pathSum(root.left, sum);
            count += pathSuminchild(root.left, sum-root.val);
        }
        return count;
    }
    
    public int pathSuminchild(TreeNode root, int sum){
        int count = 0;
        if (root.val == sum){
            count += 1;
        }
        if(root.left == null){
            if(root.right == null)
                return count;
            else{
                count += pathSuminchild(root.right, sum-root.val);
            }
        }
        else if(root.right == null){
            count += pathSuminchild(root.left, sum-root.val);
        }else{
            count += pathSuminchild(root.right, sum-root.val);
            count += pathSuminchild(root.left, sum-root.val);
        }
        return count;
        
    }
    
    protected static class TreeNode {
    	     int val;
    	     TreeNode left;
    	     TreeNode right;
    	     TreeNode(int x) { val = x; }
    	 }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
