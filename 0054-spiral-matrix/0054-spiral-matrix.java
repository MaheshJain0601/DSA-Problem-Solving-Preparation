class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;

        /*
            direction=0; move from left to right; keeping top as constant; once done move top
            direction=1; move from top to bottom; keeping right as constant; once done move right
            direction=2; move from right to left; keeping bottom as constant; once done move bottom
            direction=3; move from bottom to top; keeping left as constant; once done move left
            Repeat until all spirals are done
        */
        int direction = 0;

        while (top <= bottom && left <= right) {

            //direction=0; move from left to right; keeping top as constant; once done move top
            if (direction == 0) {
                for (int index = left; index <= right; ++index) {
                    result.add(matrix[top][index]);
                }
                top++;
            }

            //direction=1; move from top to bottom; keeping right as constant; once done move right
            if (direction == 1) {
                for (int index = top; index <= bottom; ++index) {
                    result.add(matrix[index][right]);
                }
                right--;
            }

            //direction=2; move from right to left; keeping bottom as constant; once done move bottom
            if (direction == 2) {
                for (int index = right; index >= left; --index) {
                    result.add(matrix[bottom][index]);
                }
                bottom--;
            }

            //direction=3; move from bottom to top; keeping left as constant; once done move left
            if (direction == 3) {
                for (int index = bottom; index >= top; --index) {
                    result.add(matrix[index][left]);
                }
                left++;
            }

            direction++;

            if (direction == 4) 
                direction = 0;
        }
        return result;
    }
}