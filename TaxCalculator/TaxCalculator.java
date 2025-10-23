
package TaxCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Class.Contract;
import Class.Contracts.Civil;
import Class.Contracts.Employment;

public class TaxCalculator {
	
	public static void main(String[] args) {

		double income = readIncome();
		Contract contract = Contract.selectContract();

		System.out.println("Income and contract: " + income + " " + contract);

		if (contract == null || contract.getContractType() == null) {
        	System.out.println("No valid contract selected. Exiting...");
        	return;
    	}

		calculateNetIncome(income, contract);

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
				Civil civil = new Civil(income);
				netIncome = civil.calculateNetIncome();
				break;
			
			default:
				break;
		}
		return netIncome;
	}

	public static double readIncome() {
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
