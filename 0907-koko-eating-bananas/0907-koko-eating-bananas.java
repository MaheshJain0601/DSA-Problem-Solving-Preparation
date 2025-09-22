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

        int low = 0, high = maxBananaPerPile;
        int ratePerHour;

        int minHours = Integer.MAX_VALUE;

        while (low <= high) {
            ratePerHour = low + (high - low)/2;

            int hoursToComplete = getHoursToCompletePiles(piles, ratePerHour);
            
            if (hoursToComplete <= h) {
                minHours = Math.min(minHours, ratePerHour);
                high = ratePerHour - 1;
            } else {
                low = ratePerHour + 1;
            }
            //System.out.println("Rate per hour " + ratePerHour + " Hours " + hoursToComplete + " minHours " + minHours);
        }
        return minHours;
    }
}