class Solution {
    private long countProducts(int[] nums1, int[] nums2, long targetProduct) {
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
        long left = (long) -1e10; // Minimum product possible
        long right = (long) 1e10; // Maximum product possible

        long result = 0;
        
        while (left <= right) {
            long midProduct = left + (right - left) / 2;

            long countSmallest = countProducts(nums1, nums2, midProduct);
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