import java.util.Date;

public class Referencias {
    public static void main(String[] args) {
    
        String a = "Hola";
        String b = "Adios";
        String c = a;
        String d = String.valueOf(new char[] {'H', 'o', 'l', 'a'});
        int x = 5;
        int y = 8;
        int z = x;
        int t = 5;
        Date f = new Date(1700000000000L);
        Date g = new Date(1800000000000L);
        Date h = f;
        Date k = new Date(1700000000000L);

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);
        System.out.println("t: " + t);
        System.out.println("f: " + f);
        System.out.println("g: " + g);
        System.out.println("h: " + h);
        System.out.println("k: " + k);

        System.out.println("a == b: " + (a == b));
        System.out.println("a == c: " + (a == c));
        System.out.println("a == d: " + (a == d));
        System.out.println("a contiene lo mismo que d: " + a.equals(d));

        System.out.println("f == h: " + (f == h));
        System.out.println("f == k: " + (f == k));
        System.out.println("f contiene lo mismo que k: " + f.equals(k));
    }
}
