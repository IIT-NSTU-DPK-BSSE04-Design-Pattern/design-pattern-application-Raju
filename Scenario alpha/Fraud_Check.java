public class Transaction {
    private String accountId;
    private double amount;
    private String location;
    private String merchant;
    private boolean f;

    public Transaction(String accountId, double amount, String location, String merchant) 
    {
        this.accountId = accountId;
        this.amount = amount;
        this.location = location;
        this.merchant = merchant;
        this.f = false;
    }

    public String getAccountId() 
    { 
        return accountId; 
    }
    public double getAmount() 
    { 
        return amount; 
    }
    public String getLocation() 
    { 
        return location; 
    }
    public String getMerchant() 
    { 
        return merchant; 
    }
    public boolean isf() 
    { 
        return f; 
    }
    public void setf(boolean f) 
    { 
        this.f = f; 
    }
}

public interface Fraud_Check {
    void setnext_Check(Fraud_Check next_Check);
    void check(Transaction transaction);
}

public class BaseFraud_Check implements Fraud_Check {
    private Fraud_Check next_Check;

    @Override
    public void setnext_Check(Fraud_Check next_Check) 
    {
        this.next_Check = next_Check;
    }

    @Override
    public void check(Transaction transaction) 
    {
        if (transaction.getAmount() > 10000 || transaction.getAmount() < 0) 
        {
            transaction.setf(true);
            System.out.println("Check" + transaction.getAccountId());
        } 
        else if (next_Check != null) 
        {
            next_Check.check(transaction);
        }
    }
}