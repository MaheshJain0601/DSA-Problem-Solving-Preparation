class Solution {
    public int countEven(int num) {
        return (String.valueOf(num).chars().map(Character::getNumericValue).sum() % 2 == 0 ? num/2:(num-1)/2);
        
    }
}