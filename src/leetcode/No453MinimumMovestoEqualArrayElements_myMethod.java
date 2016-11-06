package leetcode;

/*
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4] 
 */

public class No453MinimumMovestoEqualArrayElements_myMethod {
	
	public class Solution {
	    public int minMoves(int[] nums) {
	        int sum = 0;
	        int min = nums[0];
	        for(int i = 1; i < nums.length; i++){
	            if (min > nums[i]){
	                sum += (min - nums[i])*i;
	                min = nums[i];
	            }else{
	                sum += nums[i] - min;
	            }
	        }
	        return sum;
	        
	    }
	}

}
