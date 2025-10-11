package Class.Contracts;

import Class.Formatter;
import Class.Taxes.HealthTaxes;
import Class.Taxes.SecurityTaxes;
import TaxCalculator.TaxCalculator;

public class Civil {
    SecurityTaxes securityTaxes = new SecurityTaxes();
    HealthTaxes healthTaxes = new HealthTaxes();
    Formatter formatter = new Formatter();
    
    double income;
    double taxDeductibleExpenses;
    double incomeToBeTaxed;
    double alreadyPaidTax;
    double advanceTax;
    double advanceTaxPaid;
    double netIncome;

    public Civil(double income) {
        this.income = income;
        this.taxDeductibleExpenses = 0;
        this.incomeToBeTaxed = 0;
        this.alreadyPaidTax = 0;
        this.advanceTax = 0;
        this.advanceTaxPaid = 0;
        this.netIncome = 0;
    }

    public double calculateCivilNetIncome() {
        income = securityTaxes.calculateIncome(income);
        System.out.println("Income for calculating health security tax: " + income);
        healthTaxes.calculateHealthTaxes(income);

        taxDeductibleExpenses = (income * 20) / 100;
        incomeToBeTaxed = income - taxDeductibleExpenses;
        advanceTax = TaxCalculator.calculateTax(Double.parseDouble(formatter.format_to_df(incomeToBeTaxed)));

        advanceTaxPaid = TaxCalculator.calculateAdvanceTax(healthTaxes.calculatedHealth_2);

        netIncome = calculateNetIncome(advanceTaxPaid);

        printCivil();
        return netIncome;

    }

    public double calculateNetIncome(double advanceTaxPaid) {
        double roundedAdvanceTaxPaid = Double.parseDouble(formatter.format_to_df(advanceTaxPaid));
        return income - (securityTaxes.SecurityTaxesTotal() + healthTaxes.calculatedHealth_1 + roundedAdvanceTaxPaid);
    }

    public double getTaxDeductibleExpenses() {
        return taxDeductibleExpenses;
    }

    public double getTaxedIncome() {
        return incomeToBeTaxed;
    }

    public void printCivil() {
        System.out.println("================================");
        System.out.println("CIVIL CONTRACT");
        System.out.println("Income: " + income);
        securityTaxes.printSecurityTaxes();
        healthTaxes.printHealthTaxes();
        System.out.println("Tax deductible expenses = " + taxDeductibleExpenses);
        System.out.println("Income to be taxed = " + incomeToBeTaxed + " Rounded = " + formatter.format_to_df(incomeToBeTaxed));
        System.out.println("Advance tax 18 % = " + advanceTax);
        System.out.println("Already paid tax = " + alreadyPaidTax);
        System.out.println("Advance tax = " + formatter.format_to_df00(advanceTax) + " Rounded = " + formatter.format_to_df(advanceTax));
        System.out.println("================================");
    }


}
