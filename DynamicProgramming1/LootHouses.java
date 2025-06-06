package dp;

public class LootHouses {
	
	public static int maxMoneyLootedRec(int[] houses) {
		
		if(houses.length==0) {
			return 0;
		}
		
		return maxMoneyLootedRec(houses,0);
	}

	//Time complexity : O(2^N) where N = no of houses
	//Space complexity : O(N)
	private static int maxMoneyLootedRec(int[] houses, int i) {
		
		if(i>=houses.length) {
			return 0;
		}
		
		int op1 = houses[i] + maxMoneyLootedRec(houses, i+2);
		
		int op2 = maxMoneyLootedRec(houses, i+1);
		
		return Math.max(op1, op2);
		
	}
	
    public static int maxMoneyLootedMem(int[] houses) {
		
		if(houses.length==0) {
			return 0;
		}
		
		int[] storage = new int[houses.length];
		
		return maxMoneyLootedMem(houses, 0, storage);
	}

    //Time complexity : O(N)
    //Space complexity : O(N)
    private static int maxMoneyLootedMem(int[] houses, int i, int[] storage) {
    	
    	if(i>=houses.length) {
    		return 0;
    	}
    	
    	if(storage[i]!=0) {
    		return storage[i];
    	}
    	
        int op1 = houses[i] + maxMoneyLootedMem(houses, i+2, storage);
		
		int op2 = maxMoneyLootedMem(houses, i+1, storage);
		
		storage[i] = Math.max(op1, op2);
    	
    	return storage[i];
    }
    

    //Time complexity : O(N)
    //Space complexity : O(1)
    public static int maxMoneyLootedDP(int[] houses) {
    	
    	if(houses.length==0) {
			return 0;
		}
    	
    	int inc = houses[0];
    	
    	int exc = 0;
    	
    	for(int i=1; i<houses.length; i++) {
    		
    		int ninc = houses[i] + exc;
    		
    		int nexc = Math.max(exc,inc);
    		
    		inc = ninc;
    		
    		exc = nexc;
    	}
    	
    	return Math.max(inc, exc);
    	
    }
    
    
    //Time complexity : O(N)
    //Space complexity : O(N)
    public static int maxMoneyLootedDP2(int[] houses) {
    	
    	if(houses.length==0) {
			return 0;
		}
    	
    	int[] storage = new int[houses.length];
    	
    	storage[0] = houses[0];
    	
    	storage[1] = Math.max(houses[0], houses[1]);
    	
    	for(int i=2; i<houses.length; i++) {
    		
    		int op1 = storage[i-1];
    		
    		int op2 = houses[i] + storage[i-2];
    		
    		storage[i] = Math.max(op1, op2);
    		
    	}
    	
    	return storage[storage.length-1];
    	
    }
	

}
