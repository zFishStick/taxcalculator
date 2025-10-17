package Class.Contracts;

import TaxCalculator.TaxCalculator;

public class Civil extends Contracts {


    public Civil(double income) {
        this.income = income;
    }

    public double calculateTaxDeductibleExpenses() {
        return (income * 20) / 100;
    }

    public double calculateNetIncome(double advanceTaxPaid) {
        double roundedAdvanceTaxPaid = Double.parseDouble(formatter.format_to_df(advanceTaxPaid));
        return income - (securityTaxes.SecurityTaxesTotal() + healthTaxes.calculatedHealth_1 + roundedAdvanceTaxPaid);
    }

    public double calculateNetIncome() {
        income = calculateIncome();
        System.out.println("Income for calculating health security tax: " + income);
        healthTaxes.calculateHealthTaxes(income);

        taxDeductibleExpenses = calculateTaxDeductibleExpenses();
        taxedIncome = calculateTaxedIncome(taxDeductibleExpenses);
        advanceTax = TaxCalculator.calculateTax(Double.parseDouble(formatter.format_to_df(taxedIncome)));

        advanceTaxPaid = TaxCalculator.calculateAdvanceTax(healthTaxes.calculatedHealth_2);

        netIncome = calculateNetIncome(advanceTaxPaid);

        printIncomeDetails();

        return netIncome;
    }

    public void printIncomeDetails() {
        System.out.println("================================");
        System.out.println("CIVIL CONTRACT");
        System.out.println("Income: " + income);
        securityTaxes.printSecurityTaxes();
        healthTaxes.printHealthTaxes();
        System.out.println("Tax deductible expenses = " + taxDeductibleExpenses);
        System.out.println("Income to be taxed = " + taxedIncome + " Rounded = " + formatter.format_to_df(taxedIncome));
        System.out.println("Advance tax 18 % = " + advanceTax);
        System.out.println("Already paid tax = " + taxPaid);
        System.out.println("Advance tax = " + formatter.format_to_df00(advanceTax) + " Rounded = " + formatter.format_to_df(advanceTax));
        System.out.println("================================");
    }


}
