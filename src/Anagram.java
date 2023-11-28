import java.util.Arrays;

public class Anagram {
    public boolean isAnagram(String firstWord, String secondWord) {
        if(firstWord.length() != secondWord.length())
            return false;
        char[] firstWordArray = firstWord.toLowerCase().toCharArray();
        char[] secondWordArray = secondWord.toLowerCase().toCharArray();
        Arrays.sort(firstWordArray);
        Arrays.sort(secondWordArray);
        return Arrays.equals(firstWordArray, secondWordArray);
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        // True Anagram Test Cases
        String[] trueAnagrams = {
                "listen", "silent",
                "triangle", "integral",
                "evil", "vile",
                "debit card", "bad credit",
                "Eleven plus two", "Twelve plus one"
        };

        // False Anagram Test Cases
        String[] falseAnagrams = {
                "hello", "world",
                "java", "javascript",
                "listen", "silence",
                "apple", "aple",
                "earth", "heartly"
        };

        for (int i = 0; i < trueAnagrams.length; i += 2) {
            String word1 = trueAnagrams[i];
            String word2 = trueAnagrams[i + 1];
            boolean result = anagram.isAnagram(word1, word2);
            System.out.println(word1 + " and " + word2 + ": " + result);
        }

        for (int i = 0; i < falseAnagrams.length; i += 2) {
            String word1 = falseAnagrams[i];
            String word2 = falseAnagrams[i + 1];
            boolean result = anagram.isAnagram(word1, word2);
            System.out.println(word1 + " and " + word2 + ": " + result);
        }
    }
}
