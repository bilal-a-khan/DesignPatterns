package strategy;

public class AlabamaTaxesStrategy implements StateTaxesStrategy {
    @Override
    public double calculateStateTaxes(double periodPay) {
        return .02 * periodPay;
    }
}
