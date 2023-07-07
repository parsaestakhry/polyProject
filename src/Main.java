public class Main {
    public static void main(String[] args) {
        PolyNomial p = new PolyNomial("3x^2 +6");
        PolyNomial p1 = new PolyNomial("4x^6 + 3x^1");
        p.splicing(p1);
        p.multiply(p1);
        p.divide(p1);



    }
}