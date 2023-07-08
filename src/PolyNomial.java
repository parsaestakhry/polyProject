import java.util.ArrayList;
import java.util.Arrays;

public class PolyNomial extends Monomial{
    // array lists
    ArrayList<String> poly = new ArrayList<>();
    ArrayList<String> operators = new ArrayList<>();
    ArrayList<Integer> powerList = new ArrayList<>();
    ArrayList<Double> coeffList = new ArrayList<>();
    ArrayList<Double> list_res_c = new ArrayList<>();
    ArrayList<Integer> list_res_p = new ArrayList<>();

    // default constructor
    public PolyNomial() {
    }

    // main constructor
    public PolyNomial(String polynomial){
        // replacing all the parts
        polynomial = polynomial.replaceAll("\\s" , "");
        polynomial = polynomial.replace("^" , "~");
        String[] polyParts = polynomial.split("[+-]");
        poly.addAll(Arrays.asList(polyParts));
    }

    // method to
    public void splicing(PolyNomial p){
        // clearing before appending
        powerList.clear();
        coeffList.clear();
        // creating a new object from monomial
        Monomial m = new Monomial();
        // looping through
        for (String s : this.poly){
            String[] parts = s.split("x~");
            try {
                this.setCoeff(Double.parseDouble(parts[0]));
            } catch (Exception e){
                this.setCoeff(1.0);
            }
            this.coeffList.add(this.getCoeff());
            try {
                this.setPower(Integer.parseInt(parts[1]));
            } catch (Exception e){
                this.setPower(0);
            }
            this.powerList.add(this.getPower());
        }
        for (String s : p.poly){
            String[] parts = s.split("x~");
            try {
                m.setCoeff(Double.parseDouble(parts[0]));
            } catch (Exception e){
                m.setCoeff(1.0);
            }
            p.coeffList.add(m.getCoeff());
            try {
                m.setPower(Integer.parseInt(parts[1]));
            } catch (Exception e){
                m.setPower(0);
            }
            p.powerList.add(m.getPower());

        }


    }



    public PolyNomial multiply(PolyNomial p){
        list_res_c.clear();
        list_res_p.clear();

        for (int i = 0; i < this.coeffList.size(); i++) {
            for (int j = 0; j < p.coeffList.size(); j++) {
                list_res_c.add(this.coeffList.get(i) * p.coeffList.get(j));
                list_res_p.add(this.powerList.get(i) + p.powerList.get(j));
            }
        }
//        System.out.println(this.powerList);
//        System.out.println(this.coeffList);
//        System.out.println(p.powerList);
//        System.out.println(p.coeffList);
//        System.out.println(list_res_c);
//        System.out.println(list_res_p);
        return this;
    }




    public PolyNomial divide(PolyNomial p){
        list_res_c.clear();
        list_res_p.clear();

        for (int i = 0; i < this.coeffList.size(); i++) {
            for (int j = 0; j < p.coeffList.size(); j++) {
                list_res_c.add(this.coeffList.get(i) / p.coeffList.get(j));
                list_res_p.add(this.powerList.get(i) - p.powerList.get(j));
            }
        }

        System.out.println(list_res_c);
        System.out.println(list_res_p);
        return this;
    }

    public PolyNomial sum(PolyNomial p){
        list_res_c.clear();
        list_res_p.clear();
        for (int i = 0; i < this.powerList.size(); i++) {
            for (int j = 0; j < p.powerList.size(); j++) {
                if (this.powerList.get(i) == p.powerList.get(j)){
                    list_res_c.add(this.coeffList.get(i) + p.coeffList.get(j));
                    list_res_p.add(this.powerList.get(i));

                } else {

                }
            }
        }

        System.out.println(list_res_c);
        System.out.println(list_res_p);
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
