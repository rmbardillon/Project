package leetcode;

import java.util.*;

public class Strings {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public static void letterCombinations(String digits) {
        Map<Character, String> cellphoneKeypad = new HashMap<>();
        List<String> result = new ArrayList<>();

        cellphoneKeypad.put('2', "abc");
        cellphoneKeypad.put('3', "def");
        cellphoneKeypad.put('4', "ghi");
        cellphoneKeypad.put('5', "jkl");
        cellphoneKeypad.put('6', "mno");
        cellphoneKeypad.put('7', "pqrs");
        cellphoneKeypad.put('8', "tuv");
        cellphoneKeypad.put('9', "wxyz");

        int start = 0;
        int end = digits.length() - 1;

    }

    public static void main(String[] args) {
        letterCombinations("99");
    }
}
