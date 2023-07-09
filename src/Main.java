public class Main {
    public static void main(String[] args) {
        PolyNomial p = new PolyNomial("4x^3 +2x^2 +2x^5 +6");
        PolyNomial p1 = new PolyNomial("4x^2 +7x^1 -6");
        p.splicing(p1);
        p.sum(p1);

        System.out.println(p1.evaluate(1.0));
//        System.out.println(p.evaluate(1));;
//        System.out.println(p.toString());
        //p.multiply(p1);
        //p.divide(p1);
        //p.sum(p1);
        //p.subtract(p1);
        //System.out.println(p.evaluate(0));
        //p.subtract(p1);


    }
}