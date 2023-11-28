public class RestoreString {
    public String restoreString(String s, int[] indices) {
        StringBuilder output = new StringBuilder(); // Using StringBuilder for efficient string concatenation

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < indices.length; j++) {
                if (i == indices[j]) {
                    output.append(s.charAt(j));
                    break;
                }
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int indices[] = {4,5,6,7,0,2,1,3};

        System.out.println(new RestoreString().restoreString(s, indices));
    }
}
