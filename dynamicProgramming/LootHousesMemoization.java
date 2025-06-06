package dynamicProgramming;

public class LootHousesMemoization {
	
public static int maxMoneyLooted(int[] houses, int sI, int[] storage) {
		
        if(sI>=houses.length){
            return 0;
        }
        
        if(storage[sI]!=-1) {
        	return storage[sI];
        }
        
        int opt1 = houses[sI]+maxMoneyLooted(houses,sI+2,storage);
        
        int opt2 = maxMoneyLooted(houses,sI+1,storage);
        
        
        storage[sI]=Math.max(opt1,opt2);
        		
        return storage[sI];
	}
    
    public static int maxMoneyLooted(int[] houses){
    	
    	int[] storage = new int[houses.length];
    	
    	for(int i=0; i<storage.length; i++) {
    		storage[i]=-1;
    	}
    	
        return maxMoneyLooted(houses,0,storage);
    }

	public static void main(String[] args) {
		

	}

}
