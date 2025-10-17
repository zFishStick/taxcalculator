package Class.Contracts;

import TaxCalculator.TaxCalculator;

public class Employment extends Contracts {

    public Employment(double income) {
        this.income = income;
    }

    public double calculateNetIncome() {
        income = calculateIncome();
        System.out.println("Income basis for health social security: " + income);

        healthTaxes.calculateHealthTaxes(income);
        taxedIncome = calculateTaxedIncome(TaxCalculator.TAX_DEDUCTIBLE_EXPENSES);
        advanceTax = TaxCalculator.calculateTax(Double.parseDouble(formatter.format_to_df(taxedIncome)));
        taxPaid = calculateTaxPaid(advanceTax, TaxCalculator.TAX_FREE_INCOME);
        advanceTaxPaid = TaxCalculator.calculateAdvanceTax(healthTaxes.calculatedHealth_2);
        netIncome = calculateEmploymentNetIncome(advanceTaxPaid);

        printIncomeDetails();
        return netIncome;
    }

    private double calculateTaxPaid(double advanceTax, double taxFreeIncome) {
        return advanceTax - taxFreeIncome;
    }

    private double calculateEmploymentNetIncome(double advanceTaxPaid) {
        double roundedAdvanceTaxPaid = Double.parseDouble(formatter.format_to_df(advanceTaxPaid));
        return income - (securityTaxes.SecurityTaxesTotal() + healthTaxes.calculatedHealth_1 + roundedAdvanceTaxPaid);
    }


    public void printIncomeDetails() {
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
