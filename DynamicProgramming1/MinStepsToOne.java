package dp;

public class MinStepsToOne {
	
	//Time complexity : O(3^N)
	//Space complexity : O(N)
	public static int countMinStepsToOne(int n) {
		
		if(n==1) {
			return 0;
		}
		
		int subtractOne = Integer.MAX_VALUE;
		
		int divideByTwo = Integer.MAX_VALUE;
		
		int divideByThree = Integer.MAX_VALUE;
		
		subtractOne = countMinStepsToOne(n-1);
		
		if(n%2==0) {
			divideByTwo = countMinStepsToOne(n/2);
		}
		
		if(n%3==0) {
			divideByThree = countMinStepsToOne(n/3);
		}
		
		return 1 + Math.min(subtractOne, Math.min(divideByTwo, divideByThree));
		
	}
	
	public static int countMinStepsToOneM(int n) {
		
		if(n==1) {
			return 0;
		}
		
		int[] storage = new int[n+1];
		
		return countMinStepsToOneM(n, storage);
	}
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	private static int countMinStepsToOneM(int n, int[] storage) {
		
		if(n==1) {
			return storage[1];
		}
		
		if(storage[n]!=0) {
			return storage[n];
		}
		
	    int subtractOne = Integer.MAX_VALUE;
		
		int divideByTwo = Integer.MAX_VALUE;
		
		int divideByThree = Integer.MAX_VALUE;
		
		subtractOne = countMinStepsToOneM(n-1, storage);
		
		if(n%2==0) {
			divideByTwo = countMinStepsToOneM(n/2, storage);
		}
		
		if(n%3==0) {
			divideByThree = countMinStepsToOneM(n/3, storage);
		}
		
		storage[n] = 1 + Math.min(subtractOne, Math.min(divideByTwo, divideByThree));
		
		return storage[n];
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static int countMinStepsToOneDP(int n) {
		
		int[] minSteps = new int[n+1];
		
		if(n==1) {
			return 0;
		}
		
		for(int currSteps=2; currSteps<=n; currSteps++) {
			
		    int subtractOne = Integer.MAX_VALUE;
			
			int divideByTwo = Integer.MAX_VALUE;
			
			int divideByThree = Integer.MAX_VALUE;
			
			subtractOne = minSteps[currSteps-1];
			
			if(currSteps%2==0) {
				divideByTwo = minSteps[currSteps/2];
			}
			
			if(currSteps%3==0) {
				divideByThree = minSteps[currSteps/3];
			}
			
			minSteps[currSteps] = 1 + Math.min(subtractOne, Math.min(divideByTwo, divideByThree));
			
		}
		
		return minSteps[n];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countMinStepsToOneDP(6000));
		
		System.out.println(countMinStepsToOneM(6000));
		
		System.out.println(countMinStepsToOne(1000));
		

	}

}
