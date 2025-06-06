package dynamicProgramming;

public class LootHousesDP {
	
  public static int maxMoneyLooted(int[] houses, int sI, int[] storage) {
        
        
        storage[0]=houses[houses.length-1];
        
        storage[1]=Math.max(houses[houses.length-1],houses[houses.length-2]);
        
        
        for(int i=2; i<=storage.length-1; i++){
            
            storage[i]=Math.max(houses[houses.length-1-i]+storage[i-2],storage[i-1]);
        }
        
        		
        return storage[storage.length-1];
	}
    
    public static int maxMoneyLooted(int[] houses){
        
        if(houses.length==0){
            return 0;
        }
    
    	int[] storage = new int[houses.length];
    	
        return maxMoneyLooted(houses,0,storage);
    }

	public static void main(String[] args) {
		
		

	}

}
