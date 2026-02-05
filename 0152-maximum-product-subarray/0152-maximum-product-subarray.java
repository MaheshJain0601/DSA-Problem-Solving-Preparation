class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;
        int prefixProduct = 1;
        int suffixProduct = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; ++index) {
            if (prefixProduct == 0) prefixProduct = 1;
            if (suffixProduct == 0) suffixProduct = 1;
            prefixProduct *= nums[index];
            suffixProduct *= nums[N-index-1];
            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
        }

        return maxProduct;
    }
}