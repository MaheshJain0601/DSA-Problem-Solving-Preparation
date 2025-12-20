class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];

        int[] nextGreaterElement = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        for (int index = nums2.length - 1; index >= 0; --index) {
            while (!st.isEmpty() && st.peek() <= nums2[index]) {
                st.pop();
            }
            nextGreaterElement[index] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[index]);
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for (int index = nums2.length - 1; index >= 0; --index) {
            mp.put(nums2[index], nextGreaterElement[index]);
        }

        System.out.println(mp);

        for (int index = 0; index < nums1.length; ++index) {
            result[index] = mp.getOrDefault(nums1[index], -1);
        }
        return result;
    }
}