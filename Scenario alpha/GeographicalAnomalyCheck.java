package Scenario alpha;

import java.util.Arrays;
import java.util.List;

public class GeographicalAnomalyCheck implements Fraud_Check 
{
    private Fraud_Check next_Check;
    private List<String> validLocations = Arrays.asList("BAN", "INDIA", "Pakistan");

    @Override
    public void setnext_Check(Fraud_Check next_Check) 
    {
        this.next_Check = next_Check;
    }

    @Override
    public void check(Transaction transaction) 
    {
        if (!validLocations.contains(transaction.getLocation())) 
        {
            transaction.setf(true);
            System.out.println("Geographical Check:" + transaction.getAccountId());
        } 
        else if (next_Check != null) 
        {
            next_Check.check(transaction);
        }
    }
}