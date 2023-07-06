import java.util.ArrayList;
import java.util.Arrays;

public class PolyNomial {

    ArrayList<String> poly = new ArrayList<>();

    public PolyNomial() {
    }
    public PolyNomial(String polynomial){
        polynomial = polynomial.replaceAll("\\s" , "");
        polynomial = polynomial.replace("^" , "~");

        String[] polyParts = polynomial.split("[+-]");
        MonoNomial monoNomial = new MonoNomial();
        for (String polyPart : polyParts){
            monoNomial.slicing(polyPart);

        }
    }


    public PolyNomial multiply(PolyNomial p){
        return this;
    }

    public PolyNomial divide(PolyNomial p){
        return this;
    }

    public PolyNomial sum(PolyNomial p){
        return this;
    }

    public PolyNomial subtract(PolyNomial p){
        return this;

    }

    public PolyNomial derivative(){
        return this;
    }

    public double evaluate(double x){
        return 0.0;
    }

    public PolyNomial sortByDegree(){
        return this;
    }

    public String toString(){
        return "";
    }


}
