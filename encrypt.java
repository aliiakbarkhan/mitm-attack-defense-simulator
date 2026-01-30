public class encrypt {
    public static void main(String[] args) {
        int key = 6;
        String text = "Nk2Gro2&Nu}&gxk&u{&Juotm";

        System.out.println(text);
        char[] chars = text.toCharArray();

        for(char c : chars){
            c-=key;
            System.out.print(c);
        }
    }
}
