package leetcode;

import java.util.*;

/*
There are a number of spherical balloons spread in two-dimensional space. For each balloon, 
provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, 
y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. 
Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. 
A balloon with xstart and xend bursts by an arrow shot at x if xstart ¡Ü x ¡Ü xend. 
There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. 
The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 */
public class No452MinimumNumberofArrowstoBurstBalloons_myMethod {
	
	public class Solution {
	    public int findMinArrowShots(int[][] points) {
	        if(points == null) return 0;
	        if(points.length == 0) return 0;
	        int len = points.length;
	        List<Ball> balls = new ArrayList<>();
	        for(int i=0; i<len; i++){
	            balls.add(new Ball(points[i][0], points[i][1]));
	        }
	        Comparator comp = new Comparator<Ball>(){
	            public int compare(Ball a, Ball b){
	                return a.end - b.end;
	            }
	        };
	        Collections.sort(balls, comp);
	        
	        int end1 = balls.get(0).end;
	        int shot = 0;
	        for(int i=1; i<len; i++){
	            if(end1 < balls.get(i).start){
	                shot++;
	                end1 = balls.get(i).end;
	            }
	        }
	        shot++;
	        return shot;
	    }
	    
	    public class Ball{
	        int start;
	        int end;
	        public Ball(int s, int i){
	            start = s;
	            end = i;
	        }
	    }
	    
	    
	}
	
	
	
}
