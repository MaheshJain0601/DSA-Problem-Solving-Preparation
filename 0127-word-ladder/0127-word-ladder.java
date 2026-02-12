class Solution {
    class Pair{
        String first;
        int second;
        Pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> lookup = new HashSet<>(wordList);

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        lookup.remove(beginWord);

        while (!queue.isEmpty()) {
            String currWord = queue.peek().first;
            int moves = queue.peek().second;
            queue.poll();
            if (endWord.equals(currWord)) {
                return moves;
            }
            
            char[] replacementCharArray = currWord.toCharArray();
            char prevCh;
            for (int index = 0; index < currWord.length(); ++index) {
                prevCh = replacementCharArray[index];
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    replacementCharArray[index] = ch;
                    String newOption = new String(replacementCharArray);
                    if (lookup.contains(newOption)) {
                        queue.offer(new Pair(newOption, moves + 1));
                        lookup.remove(newOption);
                    }
                }
                replacementCharArray[index] = prevCh;
            }
        }
        return 0;
    }
}