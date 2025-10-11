package Class.Taxes;

import Class.Formatter;

public class SecurityTaxes {

    static double securityTax = 9.76;
    static double healthTax = 1.5;
    static double sickTax = 2.45;

    double calculatedSecurity;
    double calculatedHealth;
    double calculatedSick;

    public SecurityTaxes() {
        this.calculatedSecurity = 0;
        this.calculatedHealth = 0;
        this.calculatedSick = 0;
    }
    
    public void printSecurityTaxes() {
        Formatter formatter = new Formatter();
        System.out.println("--------------------------------");
        System.out.println("SECURITY TAXES");
        System.out.println("Social security tax " + formatter.format_to_df00(getSecurityTax()));
		System.out.println("Health social security tax    "+ formatter.format_to_df00(getHealthTax()));
		System.out.println("Sickness social security tax  "+ formatter.format_to_df00(getSickTax()));
        System.out.println("--------------------------------");
    }

    public double calculateIncome(double income) {
        calculatedSecurity = (income * securityTax) / 100;
        calculatedHealth = (income * healthTax) / 100;
        calculatedSick = (income * sickTax) / 100;
        double sum = calculatedHealth + calculatedSecurity + calculatedSick;
        return income - sum;
    }

    public double SecurityTaxesTotal() {
        return calculatedSecurity + calculatedHealth + calculatedSick;
    }

    public double getSecurityTax() {
        return calculatedSecurity;
    }

    public double getHealthTax() {
        return calculatedHealth;
    }

    public double getSickTax() {
        return calculatedSick;
    }
}
