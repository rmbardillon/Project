public class WordCounter {
    public int count(String sentence) {
        return sentence.split(" ").length;
    }

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();
        System.out.println(wordCounter.count("Hello World"));
    }
}
