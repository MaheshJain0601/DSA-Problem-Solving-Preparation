class Solution {

    /**
        Approach-2: Better
        Maintaining state of the index; instead re-iterating again and again
        TC: O(N^2)
        SC: O(2*N)
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int N = A.length;

        int[] result = new int[N];

        boolean[] isPresentA = new boolean[N+1];
        boolean[] isPresentB = new boolean[N+1];

        int count;

        for (int index = 0; index < N; ++index) {
            
            isPresentA[A[index]] = true;
            isPresentB[B[index]] = true;

            count = 0;
            for (int i = 1; i <= N; ++i) {
                if (isPresentA[i] && isPresentB[i]) {
                    count++;
                }
            }
            result[index] = count;
        }
        
        return result;
    }

    /**
        Approach - 1: Brute force
        Compare each and every element of A and B and populate C
        TC: O(N^3)
        SC: O(1)
     */
    public int[] findThePrefixCommonArrayApproach1(int[] A, int[] B) {

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