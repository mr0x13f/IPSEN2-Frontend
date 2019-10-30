package models;

public class Rate {

    private String name;
    //Could be an double
    private float amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void yourRate(float rate) {
        amount = rate;
        System.out.println("AMOUNT: "+amount);
    }
}
