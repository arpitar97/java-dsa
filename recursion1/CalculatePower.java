package recursion1;

public class CalculatePower {
	
	//Time Complexity: O(logN)
	//Space Complexity: O(1)
	
	public static int power(int x, int n) {

        if(n==0){
            return 1;
        }
        
        int ans = power(x,n/2);
        
        if(n%2==0){
            return ans*ans;
        }
        
        else{
            return x*ans*ans;
        }
	}

	public static void main(String[] args) {
		

	}

}
