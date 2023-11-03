package strategy;

import templatemethodpattern.Address;

public class StateTaxesStrategyFactory {
    public static StateTaxesStrategy getStateTaxesStrategy(Address address){

        StateTaxesStrategy stateTaxesStrategy;
        switch (address.getState()) {
            case "AL" -> {
                stateTaxesStrategy = new AlabamaTaxesStrategy();
            }
            case "CA" -> {
                stateTaxesStrategy = new CaliforniaTaxesStrategy();
            }
            case "FL" -> {
                stateTaxesStrategy = new FloridaTaxesStrategy();
            }
            default -> {
                stateTaxesStrategy = new DefaultStateTaxesStrategy();
            }
        }
        return stateTaxesStrategy;
    }
}
