public class StringSearch {
    public Boolean isStringPresent(String word, String find) {
        return word.contains(find);
    }

    public static void main(String[] args) {
        StringSearch stringSearch = new StringSearch();
        String word = "oHHHiuHello";
        String find = "Hello";

        System.out.println(stringSearch.isStringPresent(word, find));
    }
}
