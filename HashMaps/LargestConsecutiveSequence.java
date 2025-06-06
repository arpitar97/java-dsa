package hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestConsecutiveSequence {
	
	//Array of unique integers
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		HashMap<Integer,Integer> elementToIndexMap = new HashMap<>();
		
		HashMap<Integer,Boolean> visitedElements = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			
			elementToIndexMap.put(arr[i], i);
				
			visitedElements.put(arr[i], false);
				
		}
		
		
		int globalMinStartIndex = 0;
		
		int globaMaxSequencelLength = 1;
		
		for(int i=0; i<arr.length; i++) {
			
			int num = arr[i];
			
			int tempNum = num;
			
			int currMinIndex = i;
			
			int count=0;
			
			//Forward
			while(visitedElements.containsKey(tempNum) && !visitedElements.get(tempNum)) {
				visitedElements.put(tempNum, true); //Mark visited elements in the array as true
				count++;
				tempNum++;
			}
			
			tempNum = num-1;
			
			//Backward
			while(visitedElements.containsKey(tempNum) && !visitedElements.get(tempNum)) {
				visitedElements.put(tempNum, true); //Mark visited elements in the array as true
				count++;
				currMinIndex=elementToIndexMap.get(tempNum);
				tempNum--;
			}
			
			if(count>globaMaxSequencelLength) {
				globaMaxSequencelLength=count;
				globalMinStartIndex=currMinIndex;
			}
			
			else if(count==globaMaxSequencelLength) {
				if(currMinIndex<globalMinStartIndex) {
					globalMinStartIndex=currMinIndex;
				}
			}
			
		}
		
		int startElem = arr[globalMinStartIndex];
		
		ans.add(startElem);
		
		if(globaMaxSequencelLength>1) {
			
			ans.add(startElem + globaMaxSequencelLength -1);
			
		}
	
		return ans;
		
	}


}
