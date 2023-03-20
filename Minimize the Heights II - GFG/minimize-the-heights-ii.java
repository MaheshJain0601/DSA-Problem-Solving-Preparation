//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        
        
        Arrays.sort(arr);
        int diff = arr[n-1] - arr[0];
        
        int smallest = arr[0] + k;
        int largest = arr[n-1] -k;
        
        int currMin, currMax;
        for (int index = 1; index < n; index++) {
            if (arr[index] - k < 0) {
                continue;
            }
            currMin = Math.min(smallest, arr[index] - k);
            currMax = Math.max(largest, arr[index-1] + k);
            
            diff = Math.min(diff, currMax - currMin);
        }
        
        return diff;
    }
}
