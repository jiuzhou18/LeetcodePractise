package leetcode;

/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class No447NumberofBoomerangs_myMethod {
	
	public class Solution {
	    public int numberOfBoomerangs(int[][] points) {
	        if (points == null) return 0;
	        
	        int time = 0;
	        for(int i=0; i<points.length; i++){
	            for(int j=i+1; j<points.length; j++){
	                for(int k=j+1; k<points.length; k++){
	                    if(dis(points[i],points[j]) == dis(points[i],points[k]))
	                        time+=2;
	                    if(dis(points[i],points[j]) == dis(points[j],points[k]))
	                        time+=2;
	                    if(dis(points[k],points[j]) == dis(points[i],points[k]))
	                        time+=2;
	                }
	            }
	        }
	        
	        return time;
	        
	    }
	    
	    public int dis(int[] point1, int[] point2){
	        return (point1[0]-point2[0])*(point1[0]-point2[0])+(point1[1]-point2[1])*(point1[1]-point2[1]);
	    }
	}
	
	
}
