class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int index = 0; index < reservedSeats.length; ++index){
            int row = reservedSeats[index][0];
            int seatIdx = reservedSeats[index][1];
            map.computeIfAbsent(row, k -> new HashSet<>()).add(seatIdx);
        }

        int availableGroups = (n-map.size())*2;
        for(int row : map.keySet()){
            Set<Integer> set = map.get(row);
            boolean leftPossibility = true, rightPossibility = true, middlePossibility = true;
            
            if(set.contains(4)||set.contains(5))
                leftPossibility = middlePossibility = false;
            if(set.contains(6)||set.contains(7))
                rightPossibility = middlePossibility = false;
            if(leftPossibility && (set.contains(2) || set.contains(3)))
                leftPossibility = false;
            if(rightPossibility && (set.contains(8) || set.contains(9)))
                rightPossibility = false;
            
            if(leftPossibility && rightPossibility) 
                availableGroups += 2;
            else if(leftPossibility||rightPossibility||middlePossibility) 
                availableGroups += 1;
        }
        return availableGroups;
    }
}