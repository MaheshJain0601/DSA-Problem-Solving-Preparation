class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0, len = nums.length;
        for (int element: nums) {
            if (num1 == element) {
                count1++;
            } else if (num2 == element) {
                count2++;
            } else if (count1 == 0) {
                num1 = element;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = element;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> answer = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int element: nums) {
            if (num1 == element) {
                count1++;
            } else if (num2 == element) {
                count2++;
            }
        }
        if (count1 > len/3) {
            answer.add(num1);
        } 
        if (count2 > len/3) {
            answer.add(num2);
        }
        return answer;
    }
}