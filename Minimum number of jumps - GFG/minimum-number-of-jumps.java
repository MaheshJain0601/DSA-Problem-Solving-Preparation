//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        
        if (arr[0] == 0) {
            return -1;
        }
        
        int steps = arr[0];
        int maxReach = arr[0];
        int jumps = 1;
        
        for (int index = 1; index < arr.length; ++index) {
            if (index == arr.length-1) {
                return jumps;
            }
            maxReach = Math.max(maxReach, index + arr[index]);
            
            steps--;
            
            if (steps == 0) {
                jumps++;
                if (index >= maxReach) {
                    return -1;
                }
                steps = maxReach - index;
            }
        }
        return -1;
    }
}