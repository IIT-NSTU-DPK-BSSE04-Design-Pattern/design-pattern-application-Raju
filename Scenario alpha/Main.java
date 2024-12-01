import java.util.Arrays;
import java.util.List;

public class BlacklistedMerchantCheck implements Fraud_Check {
    private Fraud_Check next_Check;
    private List<String> blacklistedMerchants = Arrays.asList("STORE", "MM");

    @Override
    public void setnext_Check(Fraud_Check next_Check) 
    {
        this.next_Check = next_Check;
    }

    @Override
    public void check(Transaction transaction) 
    {
        if (blacklistedMerchants.contains(transaction.getMerchant())) 
        {
            transaction.setFlagged(true);
            System.out.println("Check: " + transaction.getAccountId());
        } 
        else if (next_Check != null) 
        {
            next_Check.check(transaction);
        }
    }
}

public class HighRiskTransactionCheck implements Fraud_Check {
    private Fraud_Check next_Check;

    @Override
    public void setnext_Check(Fraud_Check next_Check) 
    {
        this.next_Check = next_Check;
    }

    @Override
    public void check(Transaction transaction) 
    {
        if (transaction.getAmount() > 5000 && transaction.getMerchant().equals("Online Betting")) {
            transaction.setFlagged(true);
            System.out.println("High-Risk Transaction Check Failed: High risk transaction for " + transaction.getAccountId());
        } 
        else if (next_Check != null) 
        {
            next_Check.check(transaction);
        }
    }
}

public class FraudDetectionSystem {
    private Fraud_Check start_Check;

    public FraudDetectionSystem() 
    {
        Fraud_Check baseCheck = new BaseFraudCheck();
        Fraud_Check geoCheck = new GeographicalAnomalyCheck();
        Fraud_Check blacklistCheck = new BlacklistedMerchantCheck();
        Fraud_Check highRiskCheck = new HighRiskTransactionCheck();

        baseCheck.setnext_Check(geoCheck);
        geoCheck.setnext_Check(blacklistCheck);
        blacklistCheck.setnext_Check(highRiskCheck);

        this.start_Check = baseCheck;
    }

    public void evaluateTransaction(Transaction transaction) 
    {
        start_Check.check(transaction);
        if (transaction.isFlagged()) 
        {
            System.out.println("Transaction flagged!");
        } 
        else {
            System.out.println("Yes. Approved!");
        }
    }
}

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