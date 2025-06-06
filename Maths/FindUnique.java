package pack1;

public class FindUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] arr = {2,2,2,2,9};
		
		int ans = findUnique(arr);
		
		System.out.println(ans);

	}
	
	public static int findUnique(int[] arr) {
		//Your code goes here
        
        return findUnique(arr,0);
        
	}
    
    private static int findUnique(int[] arr, int sI) {
		//Your code goes here
        if(sI==arr.length-1){
            return arr[sI];
        }
        
        int ans = Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++){
            
            if(arr[sI]==arr[i] && i!=sI){
                
                return findUnique(arr,sI+1);
            }
        }
        
        System.out.println("yahooo");
        return arr[sI];
        
	}

}
