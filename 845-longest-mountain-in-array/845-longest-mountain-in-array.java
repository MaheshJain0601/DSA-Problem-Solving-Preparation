import java.lang.Math;
class Solution {
    public int longestMountain(int[] arr) {
        int longest = 0;
        if (arr.length < 3) {
            return longest;
        }
        for (int index = 1; index <= arr.length - 2; ) {
            // is peak
            if (arr[index] > arr[index-1] && arr[index] > arr[index+1]) {
                // logic
                int count = 1;
                int helper = index;
                // left slide
                while (helper > 0 && arr[helper] > arr[helper-1]) {
                    count++;
                    helper--;
                }
                // right slide
                
                while (index < arr.length-1 && arr[index] > arr[index+1]) {
                    count++;
                    index++;
                }
                longest = Math.max(longest, count);
                
            } else {
                index++;
            }
        }
        return longest;
    }
}