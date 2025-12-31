class Solution {
    // Approach-1 (One-pass better solution)
    // TC: O(N)
    // SC: O(N)
    public int minimumDeletionsApproach1(String s) {
        Stack<Character> st = new Stack<>();
        char ch;
        int count = 0;
        for (int index = 0; index < s.length(); ++index) {
            ch = s.charAt(index);
            if (!st.isEmpty() && ch == 'a' && st.peek() == 'b') {
                st.pop();
                count++;
            } else {
                st.push(ch);
            }
        }
        return count;
    }

    // Approach-2 (Three-pass solution)
    // TC: O(3N)
    // SC: O(2N)
    public int minimumDeletionsApproach2(String s) {
        int N = s.length();
        int[] leftCountB = new int[N];
        int[] rightCountA = new int[N];

        int countB = 0;
        for (int index = 0; index < N; ++index) {
            leftCountB[index] = countB;
            if (s.charAt(index) == 'b') {
                countB++;
            }
        }

        int countA = 0;
        for (int index = N - 1; index >= 0; --index) {
            rightCountA[index] = countA;
            if (s.charAt(index) == 'a') {
                countA++;
            }
        }

        int minDeletion = Integer.MAX_VALUE;
        for (int index = 0; index < N; ++index) {
            minDeletion = Math.min(minDeletion, leftCountB[index] + rightCountA[index]);
        }

        return minDeletion;
    }

    // Approach-3 (Two-pass solution)
    // TC: O(N)
    // SC: O(2N)
    public int minimumDeletions(String s) {
        int N = s.length();
        int[] rightCountA = new int[N];

        int countA = 0;
        for (int index = N - 1; index >= 0; --index) {
            rightCountA[index] = countA;
            if (s.charAt(index) == 'a') {
                countA++;
            }
        }

        int minDeletion = Integer.MAX_VALUE;
        int leftCountB = 0;
        for (int index = 0; index < N; ++index) {
            minDeletion = Math.min(minDeletion, leftCountB + rightCountA[index]);
            if (s.charAt(index) == 'b') {
                leftCountB++;
            }
        }

        return minDeletion;
    }
}