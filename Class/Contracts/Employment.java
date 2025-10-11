package Class.Contracts;

import Class.Formatter;
import Class.Taxes.HealthTaxes;
import Class.Taxes.SecurityTaxes;
import TaxCalculator.TaxCalculator;

public class Employment {

    SecurityTaxes securityTaxes = new SecurityTaxes();
    HealthTaxes healthTaxes = new HealthTaxes();
    Formatter formatter = new Formatter();

    double income;
    double taxedIncome;
    double advanceTax;
    double advanceTaxPaid;
    double taxPaid;
    double netIncome;

    
    public Employment(double income) {
        this.income = income;
        this.taxedIncome = 0;
        this.advanceTax = 0;
        this.advanceTaxPaid = 0;
        this.taxPaid = 0;
        this.netIncome = 0;
    }

    public double calculateNetIncome() {
        income = securityTaxes.calculateIncome(income);
        System.out.println("Income basis for health social security: " + income);

        healthTaxes.calculateHealthTaxes(income);
        taxedIncome = (income - TaxCalculator.TAX_DEDUCTIBLE_EXPENSES);
        advanceTax = TaxCalculator.calculateTax(Double.parseDouble(formatter.format_to_df(taxedIncome)));
        taxPaid = calculateTaxPaid(advanceTax, TaxCalculator.TAX_FREE_INCOME);
        advanceTaxPaid = TaxCalculator.calculateAdvanceTax(healthTaxes.calculatedHealth_2);
        netIncome = calculateEmploymentNetIncome(advanceTaxPaid);

        printEmployment();
        return netIncome;
    }

    private double calculateTaxPaid(double advanceTax, double taxFreeIncome) {
        return advanceTax - taxFreeIncome;
    }

    private double calculateEmploymentNetIncome(double advanceTaxPaid) {
        double roundedAdvanceTaxPaid = Double.parseDouble(formatter.format_to_df(advanceTaxPaid));
        return income - (securityTaxes.SecurityTaxesTotal() + healthTaxes.calculatedHealth_1 + roundedAdvanceTaxPaid);
    }

    private void printEmployment() {
        System.out.println("================================");
        System.out.println("EMPLOYMENT CONTRACT");
        System.out.println("Income: " + income);
        securityTaxes.printSecurityTaxes();
        healthTaxes.printHealthTaxes();
        System.out.println("Tax deductible expenses = " + TaxCalculator.TAX_DEDUCTIBLE_EXPENSES);
        System.out.println("Income " + taxedIncome + " Rounded " + formatter.format_to_df(taxedIncome));
        System.out.println("Advance tax 18 % = " + advanceTax);
        System.out.println("Tax free income = " + TaxCalculator.TAX_FREE_INCOME);
        System.out.println("Reduced tax = " + formatter.format_to_df00(taxPaid));
        System.out.println("Advance tax paid = " + formatter.format_to_df00(advanceTaxPaid) + " Rounded = " + formatter.format_to_df(advanceTaxPaid));
        System.out.println("================================");

    }
    

}
