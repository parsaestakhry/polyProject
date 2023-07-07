import java.util.ArrayList;

public class Monomial {
    private double coeff;
    private int power;
    ArrayList<String> mono = new ArrayList<>();
    ArrayList<Double> preList = new ArrayList<>();
    ArrayList<Integer> degList = new ArrayList<>();




    public Monomial multiply(Monomial m){
        Monomial newM = new Monomial();
        newM.setPower(this.getPower() + m.getPower());
        newM.setCoeff(this.getCoeff() * m.getCoeff());
        return newM;
    }



    public Monomial(double coeff, int power) {
        this.coeff = coeff;
        this.power = power;
    }

    public Monomial() {
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