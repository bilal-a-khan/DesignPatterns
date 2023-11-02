package strategy;

public class NoUnionDuesStrategy implements UnionDuesStrategy {
    @Override
    public double calculateUnionDues(double periodPay) {
        return 0;
    }
}
