package strategy;

public class CaliforniaTaxesStrategy implements StateTaxesStrategy {
    @Override
    public double calculateStateTaxes(double periodPay) {
        return .10 * periodPay;
    }
}
