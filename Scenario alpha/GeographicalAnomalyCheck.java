package Scenario alpha;

import java.util.Arrays;
import java.util.List;

public class GeographicalAnomalyCheck implements FraudCheck {
    private FraudCheck nextCheck;
    private List<String> validLocations = Arrays.asList("USA", "Canada", "UK");

    @Override
    public void setNextCheck(FraudCheck nextCheck) {
        this.nextCheck = nextCheck;
    }

    @Override
    public void check(Transaction transaction) {
        if (!validLocations.contains(transaction.getLocation())) {
            transaction.setFlagged(true);
            System.out.println("Geographical Check Failed: Unusual location for " + transaction.getAccountId());
        } else if (nextCheck != null) {
            nextCheck.check(transaction);
        }
    }
}