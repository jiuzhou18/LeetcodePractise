package leetcode;

import java.util.*;

public class No444SequenceReconstruction {
	public static boolean sequenceReconstruction(int[] org, int[][] seqs) {
		Map<Integer, Set<Integer>> relations = new HashMap<>();
		
		for(int[] seq : seqs){
			relations.putIfAbsent(seq[seq.length-1], new HashSet<>());
			for(int i=1; i<seq.length; i++){
				relations.putIfAbsent(seq[i-1], new HashSet<>());
				relations.get(seq[i-1]).add(seq[i]);
			}
		}
		if(org.length != relations.size()) return false;
		
		List<Integer> tail = new ArrayList<>();
		for(int key: relations.keySet()){
			if(relations.get(key).isEmpty()){
				tail.add(key);
			}
		}
		if(tail.size() != 1) return false;
		
		List<Integer> backorg = new ArrayList<>();
		while(tail.size() == 1){
			int t = tail.remove(0);
			backorg.add(t);
			for(int key: relations.keySet()){
				if(relations.get(key).contains(t)){
					relations.get(key).remove(t);
					if(relations.get(key).isEmpty()){
						tail.add(key);
					}
				}
				
			}
			if(tail.size()>1) return false;
		}
		if(backorg.size() != org.length) return false;
		for(int i=0; i<org.length; i++){
			if(backorg.get(org.length-1-i) != org[i]) return false;
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		int[] org = {4,1,5,2,6,3};
		int[][] seqs = {{4,1,5,2}, {5,2,6,3}};
		System.out.println(sequenceReconstruction(org, seqs));

	}

}
