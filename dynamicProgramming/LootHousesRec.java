package dynamicProgramming;

public class LootHousesRec {
	
	
    public static int maxMoneyLooted(int[] houses, int sI) {
		
        if(sI>=houses.length){
            return 0;
        }
        
        int opt1 = houses[sI]+maxMoneyLooted(houses,sI+2);
        
        int opt2 = maxMoneyLooted(houses,sI+1);
        
        return Math.max(opt1,opt2);
	}
    
    public static int maxMoneyLooted(int[] houses){
        return maxMoneyLooted(houses,0);
    }

	public static void main(String[] args) {
		

	}

}
