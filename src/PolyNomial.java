import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolyNomial extends Monomial{
    // array lists
    ArrayList<String> poly = new ArrayList<>();
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
//        polynomial = polynomial.replaceAll("\\s" , "");
        polynomial = polynomial.replace("^" , "~");

        String regexPattern = "[0-9xX\\^+-][^\\s]*";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(polynomial);
        while (matcher.find()){
            String match = matcher.group();
            poly.add(match);
        }


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
 //       System.out.println("Range of properties");
//        System.out.println(this.powerList);
//        System.out.println(p.powerList);
//        System.out.println(this.coeffList);
//        System.out.println(p.coeffList);

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
//
//        System.out.println(list_res_c);
//        System.out.println(list_res_p);
        return this;
    }

    public PolyNomial sum(PolyNomial p){
        list_res_c.clear();
        list_res_p.clear();

        ArrayList<Double> merged_coeff = new ArrayList<>();
        ArrayList<Integer> merged_power = new ArrayList<>();

        for (int i = 0; i < this.coeffList.size(); i++) {
            for (int j = 0; j < p.coeffList.size() ; j++) {
                if (Objects.equals(p.powerList.get(j), this.powerList.get(i))){
                    merged_power.add(p.powerList.get(j));
                    merged_coeff.add(this.coeffList.get(i) + p.coeffList.get(j));
                }
            }
        }

        for (int i = 0; i < this.coeffList.size(); i++) {
            if (!merged_power.contains(this.powerList.get(i))){
                list_res_c.add(this.coeffList.get(i));
                list_res_p.add(this.powerList.get(i));
            }
        }

        for (int i = 0; i < p.coeffList.size(); i++) {
            if (!merged_power.contains(p.powerList.get(i))){
                list_res_c.add(p.coeffList.get(i));
                list_res_p.add(p.powerList.get(i));
            }
        }

        list_res_c.addAll(merged_coeff);
        list_res_p.addAll(merged_power);

//        System.out.println("list of final coeffs after sum");
//        System.out.println(list_res_c);
//        System.out.println("list of final powers after sum ");
//        System.out.println(list_res_p);
//        System.out.println("list of the given powers after change");
//        System.out.println(p.powerList);
//        System.out.println(this.powerList);
//        System.out.println("list of the given coeffs after change");
//        System.out.println(p.coeffList);
//        System.out.println(this.coeffList);

        return this;
    }

    public PolyNomial subtract(PolyNomial p){
        list_res_c.clear();
        list_res_p.clear();

        ArrayList<Double> merged_coeff = new ArrayList<>();
        ArrayList<Integer> merged_power = new ArrayList<>();

        for (int i = 0; i < this.coeffList.size(); i++) {
            for (int j = 0; j < p.coeffList.size() ; j++) {
                if (Objects.equals(p.powerList.get(j), this.powerList.get(i))){
                    merged_power.add(p.powerList.get(j));
                    merged_coeff.add(this.coeffList.get(i) - p.coeffList.get(j));
                }
            }
        }

        for (int i = 0; i < this.coeffList.size(); i++) {
            if (!merged_power.contains(this.powerList.get(i))){
                list_res_c.add(this.coeffList.get(i));
                list_res_p.add(this.powerList.get(i));
            }
        }

        for (int i = 0; i < p.coeffList.size(); i++) {
            if (!merged_power.contains(p.powerList.get(i))){
                list_res_c.add(p.coeffList.get(i));
                list_res_p.add(p.powerList.get(i));
            }
        }

        list_res_c.addAll(merged_coeff);
        list_res_p.addAll(merged_power);

//        System.out.println("list of final coeffs after sum");
//        System.out.println(list_res_c);
//        System.out.println("list of final powers after sum ");
//        System.out.println(list_res_p);
        return this;
    }

    public PolyNomial derivative(){
        list_res_c.clear();
        list_res_p.clear();


        powerList.clear();
        coeffList.clear();
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


        ArrayList<Double> new_coeff = new ArrayList<>();
        ArrayList<Integer> new_power = new ArrayList<>();
        for (int i = 0; i < this.powerList.size(); i++) {
            double coeff = this.powerList.get(i) * this.coeffList.get(i);
            new_coeff.add(coeff);
            int power = this.powerList.get(i) - 1;
            if (power > 0){
                new_power.add(power);
            }

        }

        list_res_c.addAll(new_coeff);
        list_res_p.addAll(new_power);
        return this;
    }

    public double evaluate(double x){

        double sum = 0;
        for (int i = 0; i < this.powerList.size() ; i++) {
            sum = sum + (Math.pow(x , this.powerList.get(i))) * this.coeffList.get(i);
        }
        return sum;
    }

    public PolyNomial sortByDegree(){
        Collections.sort(this.powerList);
        return this;
    }

    public PolyNomial print(){
        String printed = "";
        for (int i = 0; i < list_res_p.size() ; i++) {
            if (list_res_c.get(i) >=0){
                printed = printed + "+"+ list_res_c.get(i).toString()+"x^"+list_res_p.get(i).toString()+ "";
            }
            else{
                printed = printed + list_res_c.get(i).toString()+"x^"+list_res_p.get(i).toString()+ "";
            }
        }

        System.out.println(printed);
        return this;
    }

}



