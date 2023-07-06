import java.util.ArrayList;
import java.util.Arrays;

public class MonoNomial {
    private double coeff;
    private int power;
    ArrayList<String> mono = new ArrayList<>();
    ArrayList<Double> preList = new ArrayList<>();
    ArrayList<Integer> degList = new ArrayList<>();


    public void slicing(String s) {
        String[] line = s.split("x~");
        this.setCoeff(Double.parseDouble(line[0]));
        System.out.println(getCoeff());
        try {
            this.setPower(Integer.parseInt(line[1]));
            System.out.println(getPower());
        } catch (Exception ignored){
        }
    }



    public MonoNomial(double coeff, int power) {
        this.coeff = coeff;
        this.power = power;
    }

    public MonoNomial() {
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}