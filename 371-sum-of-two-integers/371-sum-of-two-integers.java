class Solution {
    public int getSum(int a, int b) {
        if (a == 0){
            return b;
        } else if (b == 0) {
            return a;
        } else{
            while (b != 0) {
                int tmp = (a & b) << 1;
                a = (a ^ b);
                b = tmp;
            }
            return a;
        }     
    }
}