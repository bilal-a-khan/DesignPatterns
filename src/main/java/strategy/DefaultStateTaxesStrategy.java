package strategy;

public class DefaultStateTaxesStrategy implements StateTaxesStrategy {
    @Override
    public double calculateStateTaxes(double periodPay) {
        return 0.05 * periodPay;
    }
}
