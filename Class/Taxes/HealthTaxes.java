package Class.Taxes;

import Class.Formatter;

public class HealthTaxes {
    
    public static double healthTax_1 = 9;
    public static double healthTax_2 = 7.75;

    public double calculatedHealth_1;
    public double calculatedHealth_2;

    public HealthTaxes(){
        this.calculatedHealth_1 = 0;
        this.calculatedHealth_2 = 0;
    }

    public void calculateHealthTaxes(double income) {
        calculatedHealth_1 = (income * healthTax_1) / 100;
        calculatedHealth_2 = (income * healthTax_2) / 100;
    }

    public void printHealthTaxes() {
        Formatter formatter = new Formatter();
        System.out.println("--------------------------------");
        System.out.println("HEALTH TAXES");
        System.out.println("Health social security tax: 9% = " + formatter.format_to_df00(calculatedHealth_1) + " 7,75% = " + formatter.format_to_df00(calculatedHealth_2));
        System.out.println("--------------------------------");
    }

    public double getHealthTax_1() {
        return calculatedHealth_1;
    }

    public double getHealthTax_2() {
        System.out.println("Health tax 2: " + calculatedHealth_2);
        return calculatedHealth_2;
    }

}
