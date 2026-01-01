class Solution {
    public boolean canBeValid(String s, String locked) {
        int N = s.length();

        if (N % 2 == 1) {
            return false;
        }

        int index = 0;
        char ch, lockedCh;

        int openCount = 0, openClosedCount = 0;
        while (index < N) {
            ch = s.charAt(index);
            lockedCh = locked.charAt(index);
            if (lockedCh == '0') {
                openClosedCount++;
            } else if (ch == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--;
                } else if (openClosedCount > 0) {
                    openClosedCount--;
                } else {
                    return false;
                }
            }
            index++;
        }

        int closedCount = 0;
        openClosedCount = 0;
        index = N - 1;
        while (index >= 0) {
            ch = s.charAt(index);
            lockedCh = locked.charAt(index);
            if (lockedCh == '0') {
                openClosedCount++;
            } else if (ch == ')') {
                closedCount++;
            } else {
                if (closedCount > 0) {
                    closedCount--;
                } else if (openClosedCount > 0) {
                    openClosedCount--;
                } else {
                    return false;
                }
            }
            index--;
        }

        return true;
    }
}