public class Main {
    public static void main(String[] args) {
        PolyNomial p = new PolyNomial("3x^2 +6");
        PolyNomial p1 = new PolyNomial("4x^2 + 3x^1 + 5x^2 + 9x^2");
        p.splicing(p1);
//        p.multiply(p1);
//        p.divide(p1);
        p.sum(p1);


    }
}