class Solution {
    int result = Integer.MAX_VALUE;
    private void distributeCookiesHelper(int[] cookies, int[] childrenCookies, int index, int k) {
        if (index >= cookies.length) {
            int maxCookiesSingleChild = Integer.MIN_VALUE;
            for (int j = 0; j < childrenCookies.length; ++j) {
                maxCookiesSingleChild = Math.max(maxCookiesSingleChild, childrenCookies[j]);
            }
            result = Math.min(result, maxCookiesSingleChild);
            return;
        }
        for (int i = 0; i < k; ++i) {
            childrenCookies[i] += cookies[index];
            distributeCookiesHelper(cookies, childrenCookies, index + 1, k);
            childrenCookies[i] -= cookies[index];
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        int[] childrenCookies = new int[k];
        distributeCookiesHelper(cookies, childrenCookies, 0, k);
        return result;
    }
}