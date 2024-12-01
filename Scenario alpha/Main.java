import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) 
    {
        FraudDetectionSystem fraudDetectionSystem = new FraudDetectionSystem();
        Transaction transaction1 = new Transaction("44484", 1500, "BAN", "COM1");
        Transaction transaction2 = new Transaction("54454", 300, "INDIA", "COM2");
        Transaction transaction3 = new Transaction("45545", 4000, "Pakistan", "COM3");

        System.out.println("Transaction1:");
        fraudDetectionSystem.evaluateTransaction(transaction1);

        System.out.println("\nTransaction2:");
        fraudDetectionSystem.evaluateTransaction(transaction2);

        System.out.println("\nTransaction3:");
        fraudDetectionSystem.evaluateTransaction(transaction3);
    }
}