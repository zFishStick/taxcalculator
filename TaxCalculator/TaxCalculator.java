
package TaxCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Class.Contract;
import Class.Contracts.Civil;
import Class.Contracts.Employment;
import Class.Formatter;

public class TaxCalculator {

	// health-related taxes
	public static final double TAX_DEDUCTIBLE_EXPENSES = 111.25; 
	public static double TAX_FREE_INCOME = 46.33; // tax-free income monthly 46,33 PLN

	public static double advanceTax = 0;
	public static double advanceTaxPaid = 0;
	public static double taxPaid = 0;

	public static void main(String[] args) {

		double income = readIncome();
		Contract contract = Contract.selectContract();
		Formatter formatter = new Formatter();

		double netIncome = calculateNetIncome(income, contract);
		System.out.println("Net income = " + formatter.format_to_df00(netIncome));

	}

	public static double calculateNetIncome(double income, Contract contract) {

		if (contract.getContractType() == null) {
			System.err.println("Unknown type of contract!");
			return 0;
		}

		double netIncome = 0;

		switch (contract.getContractType()) {
			case EMPLOYMENT:
				Employment employment = new Employment(income);
				netIncome = employment.calculateNetIncome();
				break;

			case CIVIL:
				TAX_FREE_INCOME = 0;
				Civil civil = new Civil(income);
				netIncome = civil.calculateCivilNetIncome();
				break;
			
			default:
				break;
		}
		return netIncome;
	}

	public static double calculateAdvanceTax(double healthTax) {
		advanceTaxPaid = advanceTax - healthTax - TAX_FREE_INCOME;
		return advanceTaxPaid;

	}

	public static double calculateTax(double income) {
		advanceTax = (income * 18) / 100;
		return advanceTax;
	}

	private static double readIncome() {
		double income = 0;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			System.out.print("Enter income: ");
			income = Double.parseDouble(br.readLine());

		} catch (Exception ex) {
			System.out.println("Incorrect");
			System.err.println(ex);
			return 0;
		}
		return income;
	}
}
