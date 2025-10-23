package Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import Class.Contract;
import TaxCalculator.TaxCalculator;

public class TaxCalculatorTest {

    @Test
    public void testMainInvalidInput() {
        String simulatedInput = "300\nnull\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        TaxCalculator.main(new String[]{});
    }

    @Test
    public void testReadIncome_ValidInput() throws Exception {
        String simulatedInput = "300\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        double result = TaxCalculator.readIncome();

        assertEquals(300.0, result, 0.001);
    }

    @Test
    public void testReadIncome_InvalidInput() throws Exception {
        String simulatedInput = "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        double result = TaxCalculator.readIncome();

        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testCalculateNetIncomeForEmploymentContract() {

        double income = 300;
        double desiredNetIncome = 234.44;
        Contract contractType = new Contract('e');

        double netIncome = TaxCalculator.calculateNetIncome(income, contractType);

        assertEquals(desiredNetIncome, netIncome, 0.01);

        contractType = new Contract('c');

        assertNotEquals(desiredNetIncome, netIncome);

        contractType = new Contract('x'); // unknown contract type

        netIncome = TaxCalculator.calculateNetIncome(income, contractType);

        assertEquals(0.0, netIncome, 0.0);
    }

    @Test
    public void testCalculateNetIncomeForCivilContract() {

        double income = 300;
        Contract contractType = new Contract('c');

        double netIncome = TaxCalculator.calculateNetIncome(income, contractType);

        assertEquals(177.44, netIncome, 0.01);

        assertNotEquals(0.0, netIncome);
    }

}

