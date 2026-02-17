class Solution {
    private long findMinProduct(int[] A, int[] B) {
        long minA = A[0], maxA = A[A.length - 1];
        long minB = B[0], maxB = B[B.length - 1];

        long p1 = minA * minB;
        long p2 = minA * maxB;
        long p3 = maxA * minB;
        long p4 = maxA * maxB;

        return Math.min(Math.min(p1, p2), Math.min(p3, p4));
    }

    private long findMaxProduct(int[] A, int[] B) {
        long minA = A[0], maxA = A[A.length - 1];
        long minB = B[0], maxB = B[B.length - 1];

        long p1 = minA * minB;
        long p2 = minA * maxB;
        long p3 = maxA * minB;
        long p4 = maxA * maxB;

        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    private long countLessOrEqual(int[] nums1, int[] nums2, long targetProduct) {
        long count = 0;
        for (int num1 : nums1) {
            if (num1 == 0) {
                if (targetProduct >= 0) count += nums2.length;
                continue;
            }

            int low = 0, high = nums2.length;
            while (low < high) {
                int mid = low + (high - low) / 2;
                long product = (long) num1 * nums2[mid];
                if (product <= targetProduct) {
                    if (num1 > 0) low = mid + 1;
                    else high = mid;
                } else {
                    if (num1 > 0) high = mid;
                    else low = mid + 1;
                }
            }

            count += (num1 > 0) ? low : nums2.length - low;
        }
        return count;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = findMinProduct(nums1, nums2);
        long right = findMaxProduct(nums1, nums2);

        long result = 0;
        
        while (left <= right) {
            long midProduct = left + (right - left) / 2;

            long countSmallest = countLessOrEqual(nums1, nums2, midProduct);
            if (countSmallest >= k) {
                result = midProduct; 
                right = midProduct - 1;
            } else {
                left = midProduct + 1;
            }
        }
        
        return result;
    }
}