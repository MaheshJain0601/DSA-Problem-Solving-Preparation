class Solution {
    int[] romanNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romanSymbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        
        for (int index = 0; index < 13; ++index) { 
            int times = num / romanNumbers[index];
            // System.out.println("num " + num + " times " + times);
            while (times != 0) {
                sb.append(romanSymbol[index]);  
                times--;
            }
            num = num % romanNumbers[index];
        } 
        
        return sb.toString();
    }
}