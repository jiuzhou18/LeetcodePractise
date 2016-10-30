package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class No436FindRightInterval {
	
	public static int[] findRightInterval(Interval[] intervals){
		if(intervals == null) return null;
		int len = intervals.length;
		List<Pair> pairlist = new ArrayList<>();
		for (int i=0; i<len; i++){
			pairlist.add(new Pair(intervals[i].start, i));
		}
		Comparator comp = new Comparator<Pair>(){
			public int compare(Pair a, Pair b){
				return a.start - b.start;
			}
		};
		Collections.sort(pairlist, comp);
		
		int out[] = new int[len];
		for(int i=0; i<len; i++){
			int index = Collections.binarySearch(pairlist, new Pair(intervals[i].end, 0), comp);
			if (index<0){
				index = -index -1;
			}
			if (index < len){
				out[i] = pairlist.get(index).index;
			}else{
				out[i] = -1;
			}
			
		}
		
		return out;		
	}
	
	public static class Pair{
		int start;
		int index;
		public Pair(int s, int i){
			start = s;
			index = i;
		}
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
