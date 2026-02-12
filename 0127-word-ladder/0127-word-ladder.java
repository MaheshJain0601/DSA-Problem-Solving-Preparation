class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        if(!dict.contains(endWord))
          return 0;
        
        //Bi-directional BFS approach
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        return bidirectional_BFS(beginSet, endSet, dict, 1);
    }

    private int bidirectional_BFS(Set<String> beginSet, Set<String> endSet, Set<String> dict, int level){
        if(beginSet.isEmpty() || endSet.isEmpty())
           return 0;
        
        if(beginSet.size()> endSet.size())
          return bidirectional_BFS(endSet, beginSet, dict, level);
        
        Set<String> nextLevel = new HashSet<>();
        for(String word: beginSet){
            char[] wordArr = word.toCharArray();
            for(int i=0;i<wordArr.length;i++){
                char originalChar = wordArr[i];

                for(char c = 'a'; c <= 'z'; c++){
                    if(originalChar == c)
                      continue;
                    
                    wordArr[i] = c;

                    String newWord = String.valueOf(wordArr);

                    if(endSet.contains(newWord))
                      return level + 1;
                    
                    if(dict.contains(newWord)){
                        nextLevel.add(newWord);
                        dict.remove(newWord);
                    }
                }

                wordArr[i] = originalChar;
            }
        }
        return bidirectional_BFS(nextLevel, endSet, dict, level+1);
    }
}