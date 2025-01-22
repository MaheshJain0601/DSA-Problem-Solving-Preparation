class Solution {
    /**
        Approach-3: Optimal
        Maintaining frequency of each element, adding count when frequency reaches 2
        TC: O(N)
        SC: O(N)
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int N = A.length;

        int[] result = new int[N];

        Map<Integer, Integer> freq = new HashMap<>();

        int count = 0;
        int currentFreqElement = 0;

        for (int index = 0; index < N; ++index) {
            currentFreqElement = freq.getOrDefault(A[index], 0) + 1;
            freq.put(A[index], currentFreqElement);
            if (currentFreqElement == 2) {
                count++;
            }

            currentFreqElement = freq.getOrDefault(B[index], 0) + 1;
            freq.put(B[index], currentFreqElement);
            if (currentFreqElement == 2) {
                count++;
            }
            result[index] = count;
        }
        
        return result;
    }

    /**
        Approach-2: Better
        Maintaining state of the index; instead re-iterating again and again
        TC: O(N^2)
        SC: O(2*N)
     */
    public int[] findThePrefixCommonArrayApproach2(int[] A, int[] B) {

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