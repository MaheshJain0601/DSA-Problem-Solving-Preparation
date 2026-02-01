class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (n == 0) return true;
        for (int index = 0; index < len; ++index) {
            if (flowerbed[index] == 0) {
                boolean leftEmpty = index == 0 || flowerbed[index-1] == 0;
                boolean rightEmpty = index == len - 1 || flowerbed[index+1] == 0;
                if (leftEmpty && rightEmpty) {
                    flowerbed[index] = 1;
                    n--;
                }
            }
            if (n == 0) return true;
        }
        return false;
    }
}