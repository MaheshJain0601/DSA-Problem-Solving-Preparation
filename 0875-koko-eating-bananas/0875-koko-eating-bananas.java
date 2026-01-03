class Solution {
    private int getHoursToCompletePiles(int[] piles, int ratePerHour) {
        int hours = 0;
        for (int pile: piles) {
            hours += Math.ceil(pile/(ratePerHour*1.0));
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int N = piles.length;

        int maxBananaPerPile = Arrays.stream(piles).max().getAsInt();

        // Optimization: If hours equals piles count, we must eat at the rate of the largest pile
        if (h == piles.length) return maxBananaPerPile;

        int low = 0, high = maxBananaPerPile;
        int ratePerHour;

        while (low <= high) {
            ratePerHour = low + (high - low)/2;

            int hoursToComplete = getHoursToCompletePiles(piles, ratePerHour);
            
            if (hoursToComplete <= h) {
                high = ratePerHour - 1;
            } else {
                low = ratePerHour + 1;
            }
        }
        return low;
    }
}