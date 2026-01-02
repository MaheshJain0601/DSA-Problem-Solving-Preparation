class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x, mid;

        while (low <= high) {
            mid = low + (high - low)/2;
            long sqaure = (long) mid * mid;
            if (sqaure <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}