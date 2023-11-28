import java.util.HashSet;

public class LongestSubstringLength {
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int maxLen = 0;
        HashSet<Character> uniqueChars = new HashSet<>();

        while (end < s.length()) {
            if (!uniqueChars.contains(s.charAt(end))) {
                uniqueChars.add(s.charAt(end));
                maxLen = Math.max(maxLen, end - start + 1);
                end++;
            } else {
                uniqueChars.remove(s.charAt(start));
                start++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1)); // Output: 3

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2)); // Output: 1

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3)); // Output: 3
    }
}
