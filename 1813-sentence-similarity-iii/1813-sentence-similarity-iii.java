class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() < sentence2.length()) {
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }
        
        Deque<String> sentenceWords1 = new LinkedList<>(Arrays.asList(sentence1.split(" ")));
        Deque<String> sentenceWords2 = new LinkedList<>(Arrays.asList(sentence2.split(" ")));
        
        // Remove matching words from the front
        while (!sentenceWords1.isEmpty() && !sentenceWords2.isEmpty() && sentenceWords1.peekFirst().equals(sentenceWords2.peekFirst())) {
            sentenceWords1.pollFirst();
            sentenceWords2.pollFirst();
        }
        
        while (!sentenceWords1.isEmpty() && !sentenceWords2.isEmpty()  && sentenceWords1.peekLast().equals(sentenceWords2.peekLast())) {
            sentenceWords1.pollLast();
            sentenceWords2.pollLast();
        }
        
        // If deq2 is empty, then s2 is a sub-sequence of s1
        return sentenceWords2.isEmpty();
    }
    
    public boolean areSentencesSimilarUsingIndexes(String sentence1, String sentence2) {
        if (sentence1.length() < sentence2.length()) {
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }
        
        String[] sentenceWords1 = sentence1.split(" ");
        String[] sentenceWords2 = sentence2.split(" ");
        
        int sentence1Begin = 0, sentence1Last = sentenceWords1.length - 1;
        int sentence2Begin = 0, sentence2Last = sentenceWords2.length - 1;
        
        while (sentence1Begin < sentenceWords1.length && sentence2Begin < sentenceWords2.length && sentenceWords1[sentence1Begin].equals(sentenceWords2[sentence2Begin])) {
            sentence1Begin++;
            sentence2Begin++;
        }
        
        while (sentence1Last >= 0 && sentence2Last >= 0 && sentence2Last >= sentence2Begin && sentenceWords1[sentence1Last].equals(sentenceWords2[sentence2Last])) {
            sentence1Last--;
            sentence2Last--;
        }
        
        return sentence2Last < sentence2Begin;
    }
}