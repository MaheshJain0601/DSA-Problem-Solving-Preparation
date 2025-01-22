class Solution {
    /**
        Approach - 1: Brute force
        Compare each and every element of A and B and populate C
        TC: O(N^3)
        SC: O(1)
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int N = A.length;

        int[] result = new int[N];

        int count;

        for (int index = 0; index < N; ++index) {
            count = 0;

            for (int i = 0; i <= index; ++i) {
                for (int j = 0; j <= index; ++j) {
                    if (A[i] == B[j]) {
                        count++;
                        break;
                    }
                }
            }
            result[index] = count;
        }
        
        return result;
    }
}