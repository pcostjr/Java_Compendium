public class pe_02_obfuscated {
        public static void main(String[] args) {
            int x = 0, y = 1, s = 0, t = 0;

            do {
                if(y % 2 == 0) {
                    s += y;
                }
                t = x + y;
                x = y;
                y = t;

            } while (y < 4000000);

            System.out.print(s);
    }
}
