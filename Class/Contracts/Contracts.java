
package Class.Contracts;

import Class.Formatter;
import Class.Taxes.HealthTaxes;
import Class.Taxes.SecurityTaxes;

public abstract class Contracts {

    SecurityTaxes securityTaxes = new SecurityTaxes();
    HealthTaxes healthTaxes = new HealthTaxes();
    Formatter formatter = new Formatter();

    double income;
    double taxedIncome;
    double netIncome;
    double advanceTax;
    double advanceTaxPaid;
    double taxPaid;
    double taxDeductibleExpenses;

    public abstract double calculateNetIncome();

    public double calculateTaxedIncome(double taxDeductibleExpenses) {
        return income - taxDeductibleExpenses;
    }

    public abstract void printIncomeDetails();

    public double calculateIncome() {
        return securityTaxes.calculateIncome(income);
    } 

    
} 