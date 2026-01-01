class Solution {
    // Approach-1: With space
    // TC: O(N)
    // SC: O(N)
    public boolean canBeValidApproach1(String s, String locked) {
        int N = s.length();

        if (N % 2 == 1) {
            return false;
        }

        int index = 0;
        char ch, lockedCh;
        Stack<Integer> open = new Stack<>();
        Stack<Integer> openClosed = new Stack<>();

        while (index < N) {
            ch = s.charAt(index);
            lockedCh = locked.charAt(index);
            if (lockedCh == '0') {
                openClosed.push(index);
            } else if (ch == '(') {
                open.push(index);
            } else if (ch == ')') {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!openClosed.isEmpty()) {
                    openClosed.pop();
                } else {
                    return false;
                }
            }
            index++;
        }

        while (!open.isEmpty() && !openClosed.isEmpty() && open.peek() < openClosed.peek()) {
            open.pop();
            openClosed.pop();
        }

        return open.isEmpty();
    }

    // Approach-2: Without space
    // TC: O(2*N)
    // SC: O(1)
    public boolean canBeValid(String s, String locked) {
        int N = s.length();

        if (N % 2 == 1) {
            return false;
        }

        int index = 0;
        char ch, lockedCh;

        int openCount = 0;
        // Left to Right: to count open mismatch in opening brackets
        while (index < N) {
            ch = s.charAt(index);
            lockedCh = locked.charAt(index);
            if (lockedCh == '0' || ch == '(') {
                openCount++;
            } else {
                openCount--;
            }
            
            if (openCount < 0) return false;
            index++;
        }

        int closeCount = 0;
        index = N - 1;
        // Right to Left: to count open mismatch in closing brackets
        while (index >= 0) {
            ch = s.charAt(index);
            lockedCh = locked.charAt(index);
            if (lockedCh == '0' || ch == ')') {
                closeCount++;
            } else {
                closeCount--;
            }

            if (closeCount < 0) return false;
            index--;
        }

        return true;
    }
}