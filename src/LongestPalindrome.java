public class LongestPalindrome {
        public String longestPalindrome(String s) {
            int counter = 0;
            int largest = 0;
            String current = "";
            String currentLargest = "";

            for(int i = 0; i < s.length(); i++) {
                for(int j = i + 1; j <= s.length(); j++) {
                    current = s.substring(i, j);
                    if(isPalindrome(current)) {
                        counter = current.length();
                        if(counter > largest) {
                            largest = counter;
                            currentLargest = current;
                        }
                    }
                }
            }

            return currentLargest;
        }

        public boolean isPalindrome(String s) {
            StringBuilder reversed = new StringBuilder(s).reverse();
            String reversedStr = reversed.toString();
            return s.equals(reversedStr);
        }

    public static void main(String[] args) {
            String s = "babad";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }
}
