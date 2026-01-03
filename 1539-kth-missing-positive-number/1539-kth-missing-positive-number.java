class Solution {
    // TC: O(N)
    // SC: O(1)
    public int findKthPositiveBrute(int[] arr, int k) {
        for (int index = 0; index < arr.length; ++index) {
            if (arr[index] <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }

    // TC: O(log n)
    // SC: O(1)
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int mid, missingNums;
        while (low <= high) {
            mid = low + (high - low)/2;
            missingNums = arr[mid] - (mid+1);
            if (missingNums < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Formaula for missing at index = arr[index] - (index + 1)
        // Simplify
        // = arr[high] + more where more is k - missing at high index
        // = arr[high] + (k - (arr[high] - (high+1))
        // = arr[high] + k - arr[high] + high + 1
        // = high + 1 + k (or low + k)
        return high + 1 + k;
    }
}