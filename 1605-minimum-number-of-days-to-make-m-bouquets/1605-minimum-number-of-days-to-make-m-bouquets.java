class Solution {
    private boolean isPossibleBloomToDay(int[] bloomDay, int day, int m, int k) {
        int consecutiveDays = 0;
        int countBouquets = 0;

        for (int currDay: bloomDay) {
            if (currDay <= day) {
                consecutiveDays++;
            } else {
                countBouquets += Math.floor(consecutiveDays/k);
                consecutiveDays = 0;
            }
        }
        countBouquets += Math.floor(consecutiveDays/k);
        if (countBouquets >= m) return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        if (bloomDay.length < m * k) {
            return -1;
        }

        int midDay;
        int result = Integer.MAX_VALUE;;

        while (low <= high) {
            midDay = low + (high-low)/2;
            if (isPossibleBloomToDay(bloomDay, midDay, m, k)) {
                result = Math.min(result, midDay);
                high = midDay - 1;
            } else {
                low = midDay + 1;
            }
        }

        if (result == Integer.MAX_VALUE)
            return -1;
        return result;       
    }
}