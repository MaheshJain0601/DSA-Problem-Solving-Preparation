class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() < sentence2.length()) {
            // swap(sentence1, sentence2);
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