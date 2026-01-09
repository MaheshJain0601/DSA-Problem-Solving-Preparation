class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int currStartDay;
        int previousEndingDayMax = 0;
        int result = 0;

        for (int[] meeting: meetings) {
            if (meeting[0] > previousEndingDayMax) {
                result += (meeting[0] - previousEndingDayMax - 1);
            }
            previousEndingDayMax = Math.max(previousEndingDayMax, meeting[1]);
        }

        if (previousEndingDayMax < days) {
            result += (days - previousEndingDayMax);
        }
        return result;
    }
}