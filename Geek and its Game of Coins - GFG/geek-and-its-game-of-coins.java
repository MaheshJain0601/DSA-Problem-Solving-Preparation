//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String input[] = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int X = Integer.parseInt(input[1]);
            int Y = Integer.parseInt(input[2]);
            Solution ob = new Solution();
            int ans = ob.findWinner(N,X,Y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int findWinner(int N,int X,int Y)
    {
        boolean[] possibility = new boolean[N+1];
        possibility[1] = true;
        
        for (int index = 2; index <= N; ++index) {
            if (index - 1 >= 0 && !possibility[index-1]) {
                possibility[index] = true;
            }
            if (index - X >= 0 && !possibility[index - X]) {
                possibility[index] = true;
            }
            if (index - Y >= 0 && !possibility[index - Y]) {
                possibility[index] = true;
            }
        }
        
        return possibility[N] ? 1 : 0;
    }
}