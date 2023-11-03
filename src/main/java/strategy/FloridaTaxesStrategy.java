package strategy;

public class FloridaTaxesStrategy implements StateTaxesStrategy {
    @Override
    public double calculateStateTaxes(double periodPay) {
        return .03 * periodPay;
    }
}
