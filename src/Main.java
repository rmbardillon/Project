public class Main {
    public static void main(String[] args) {
        String S = "";
        String T = "";
        int i = 4;
        for(i = 1; i <= 3; i++)
            S = S + "!";
        for(i = 0; i < 4; i++)
            T = T + "*";
        System.out.print(S);
        System.out.println(T);
    }
}