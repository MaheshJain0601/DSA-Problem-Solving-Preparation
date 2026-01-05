class Solution {
    private long getTripsCompleteAtTTime(int[] time, long T) {
        long totalTrips = 0;
        for (int i = 0; i < time.length; ++i) {
            totalTrips += (T / time[i]);
        }
        return totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int N = time.length;
        int minTime = Integer.MAX_VALUE;
        for (int index = 0; index < N; ++index) {
            minTime = Math.min(minTime, time[index]);
        }
        long low = 1, high = (long) minTime * totalTrips, mid;
        long completedTrips;
        long minTimeToCompleteTrips = Long.MAX_VALUE;
        while (low <= high) {
            mid = low + (high - low)/2;
            completedTrips = getTripsCompleteAtTTime(time, mid);
            if (completedTrips >= totalTrips) {
                minTimeToCompleteTrips = Math.min(minTimeToCompleteTrips, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minTimeToCompleteTrips;
    }
}