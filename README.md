# TaxCalculator by Gabriel Pesce
Following project is a fork of the original project by Bartosz Walter (https://github.com/bartoszwalter/taxcalculator)

### The project has been modified in order to fix some bugs and apply the 'Clean Code' principles.

### In this document you can find a list of the most important edits and fixes.


## Minor Edits and Fixes

1. Removed a duplicate variable, in particular 'advanceTaxPaidadvanceTax'. The variable has been renamed to 'advanceTaxPaid' in order to avoid redundancy.

2. The variable 'advanceTaxPaid0' has been removed. The reason is that this variable was created only to show a different formattation of the same value. Now the formatting is done directly in the functions where it is needed.

3. Changed the print statements structure, now the print statements are more compact and easier to read.

## Major Edits and Fixes
1. Reduced the number of static variables in the TaxCalculator class. The removed variables have been converted to parameters of their relative classes and methods, in particular in HealthTaxes.java and SecurityTaxes.java.

2. Two new classes have been created in order to separate the operations of the security taxes and health taxes. The classes are called HealthTaxes.java and SecurityTaxes.java, they are stored in a new package 'Taxes'. In this way, length of the main class TaxCalculator.java has been reduced and easier to read.

3. Created the package 'Contracts' where the classes Employment.java and Civil.java are been created. In this way, every type of contract has his own specific operation in order to calculate the net income correctly.

4. Created the class 'Contract' where you can add new types of contracts easily. The contracts are stored in an enum called ContractType. Once you added a new contract type, you can create a new class in the package 'Contracts' and implement the specific operations for that contract.

5. Function 'main' has been reoganized, now it's only purpose is to get input from user and get the net income once it has been calculated.  

6. Created the function 'calculateNetIncome' in the TaxCalculator class. The function takes as parameters the income and the type of contract, then it calculates the net income using the specific operations of each contract class. In this way, is more easy for the user to understand what the program will going to do, instead of having all the operations in the main function.

7. Created a switch case to select the type of contract inside the TaxCalculator class. This structure is more compact and easier to read than the previous if-else structure.

8. Removed all the print statements from the TaxCalculator class. Now the print operations are done in the specific contract classes. In this way, the main class looks less confusing and withouth duplicated print statements.



