public class Palindrome {

    /** we are realizing this method using ArrayDeque */
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> wordDeque = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        for (int i = 0; i < (wordDeque.size() + 1) / 2; i++) {
            if (wordDeque.get(i) != wordDeque.get(wordDeque.size() - 1 - i)) {
                return false;
            }

        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDequeOffByOne = wordToDeque(word);
        int size = wordDequeOffByOne.size();
        for (int i = 0; i < (size - 1) / 2; i++) {
            if (!cc.equalChars(wordDequeOffByOne.get(i), wordDequeOffByOne.get(size - 1 - i))) {
                return false;
            }

        }
        return true;
    }
}
