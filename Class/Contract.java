package Class;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contract {
    public enum Type {
        EMPLOYMENT,
        CIVIL
    }

    Type contractType;

    public Contract() {
        this.contractType = null;
    }

    public Contract(char c) {
        switch (c) {
            case 'C':
            case 'c':
                contractType = Type.CIVIL;
                break;

            case 'E':
            case 'e':
                contractType = Type.EMPLOYMENT;
                break;

            default:
                System.out.println("Unknown type of contract!");
                contractType = null;
                break;
        }
    }

    public static Contract selectContract() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Select a contract type: ");
            for (Type type : Type.values()) {
                String firstLetter = type.name().substring(0, 1);
                System.out.println("(" + firstLetter + ") " + type.name());
            }
            
            return new Contract(br.readLine().charAt(0));
        
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Type getContractType() {
        return contractType;
    }
}
