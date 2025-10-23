package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Class.Contract;

public class ContractTest {
    
    @Test
    public void testSelectContract() {
        Contract contract = new Contract();

        assertNull(contract.getContractType());

        contract = new Contract('e');
        assertEquals(Contract.Type.EMPLOYMENT, contract.getContractType());

        contract = new Contract('c');
        assertEquals(Contract.Type.CIVIL, contract.getContractType());        
    }

}
