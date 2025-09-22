class Solution {
    private int getDaysToShipWithCapacity(int[] weights, int capacity) {
        int days = 0;
        int currSum = 0;
        for (int weight: weights) {
            if (currSum + weight <= capacity) {
                currSum += weight;
            } else {
                days++;
                currSum = weight;
            }
        }
        if (currSum > 0) {
            days++;
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        int mid, minDays = Integer.MAX_VALUE;
        while (low <= high) {
            mid = low + (high - low)/2;

            int daysWithCapacity = getDaysToShipWithCapacity(weights, mid);
            if (daysWithCapacity <= days) {
                minDays = Math.min(minDays, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minDays;
    }
}