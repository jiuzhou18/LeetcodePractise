package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class No436FindRightInterval_ImprovebyTreeNode {
	
	public static int[] findRightInterval(Interval[] intervals){
		int len = intervals.length;
		TreeMap<Integer, Integer> intermap = new TreeMap<>();
		for(int i=0; i<len; i++){
			intermap.put(intervals[i].start, i);
		}
		int[] out = new int[len];
		for(int i=0; i<len; i++){
			Map.Entry<Integer, Integer> index = intermap.ceilingEntry(intervals[i].end);
			out[i] = index != null? index.getValue(): -1; 
		}
		return out;
	}
	public static class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	}
	
	public static void main (String[] args){
		Interval[] test = new Interval[]{
				new Interval(1,4),
				new Interval(2,3),
				new Interval(3,4),
				new Interval(4,6)
		};
		int[] out = findRightInterval(test);
		for(int e : out){
			System.out.printf(e+" ");
		}
	}

}
