
package Class.Contracts;

import Class.Formatter;
import Class.Taxes.HealthTaxes;
import Class.Taxes.SecurityTaxes;

public abstract class Contracts {

    SecurityTaxes securityTaxes = new SecurityTaxes();
    HealthTaxes healthTaxes = new HealthTaxes();
    Formatter formatter = new Formatter();

    public static double TAX_FREE_INCOME = 46.33; // Tax-free income monthly 46,33 PLN
    public static double TAX_DEDUCTIBLE_EXPENSES = 111.25; 

    double income;
    double taxedIncome;
    double netIncome;
    double advanceTax;
    double advanceTaxPaid;
    double taxPaid;
    double taxDeductibleExpenses;
    double healthTax;

    public abstract double calculateNetIncome();

    public double calculateTaxedIncome(double taxDeductibleExpenses) {
        return income - taxDeductibleExpenses;
    }

    public abstract void printIncomeDetails();

    public double calculateIncome() {
        return securityTaxes.calculateIncome(income);
    } 

    public double calculateAdvanceTax(double healthTax) {
        advanceTaxPaid = advanceTax - healthTax - TAX_FREE_INCOME;
        return advanceTaxPaid;
    }

    public double calculateTax(double income) {
		advanceTax = (income * 18) / 100;
		return advanceTax;
	}

    
} 