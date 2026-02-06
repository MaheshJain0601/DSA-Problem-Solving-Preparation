class Solution {
    public double myPow(double x, int n) {
        long N = n;
        double ans = 1.0;
        long m = 0;
        if(N<0){
            m = N;
            N = N * -1;
        }
        while(N > 0){
            if(N%2 == 1){
                ans = ans * x;
                N = N - 1;
            }else{
                N = N/2;
                x = x * x;
            }
        }
        if(m < 0){
            ans = 1/ans;
        }
        return ans;
    }
}