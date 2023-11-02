package payment;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("123456",23.50);
        Item item2 = new Item("234567",42.62);

        cart.addItem(item1);
        cart.addItem(item2);

        //pay by paypal
        cart.pay(new PaypalStrategy("notmypayapl@notmyemail.com", "mypwd"));

        //pay by credit card
        cart.pay(new CreditCardStrategy("Bryaaaaan", "4741111111111111", "786", "12/24"));
    }
}
