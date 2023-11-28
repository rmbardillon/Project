package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    public static int romanToInt(String s) {
        Map<String, Integer> romanNumerals = new HashMap<>();

        romanNumerals.put("I", 1);
        romanNumerals.put("V", 5);
        romanNumerals.put("X", 10);
        romanNumerals.put("L", 50);
        romanNumerals.put("C", 100);
        romanNumerals.put("D", 500);
        romanNumerals.put("M", 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            String currentSymbol = String.valueOf(s.charAt(i));
            String nextSymbol = i + 1 < s.length() ? String.valueOf(s.charAt(i + 1)) : null;

            if (nextSymbol != null && romanNumerals.get(currentSymbol) < romanNumerals.get(nextSymbol)) {
                result -= romanNumerals.get(currentSymbol);
            } else {
                result += romanNumerals.get(currentSymbol);
            }
        }

        if (result > 3999 || result < 1) throw new IllegalArgumentException("Invalid input: " + s + " is not a valid Roman Numeral");

        return result;
    }

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        HashMap<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");

        int[] romanKeys = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9 ,5, 4, 1};

        for (int romanKey : romanKeys) {
            while (num >= romanKey) {
                roman.append(romanMap.get(romanKey));
                num -= romanKey;
            }
        }

        return roman.toString();
    }
}
