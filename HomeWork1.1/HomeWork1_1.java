
/**
 * HomeWork1.1
 */
public class HomeWork1_1 {

    
    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine = coffeeMachine.addProduct(new Coffee("Raf", 300, 300))
                .addProduct(new Coffee("Raf", 200, 250))
                .addProduct(new Coffee("Cappuccino", 300, 200))
                .addProduct(new Coffee("Cappuccino", 250 , 150))
                .addProduct(new Coffee("Espresso",200 , 150))
                .addProduct(new Coffee("Espresso", 100, 100))
                .addProduct(new Coffee("Americano with milk", 200, 150))
                .addProduct(new Coffee("Americano with cream", 200, 200))
                .addProduct(new Coffee("Latte", 300, 250))
                .addProduct(new Coffee("Latte", 200, 200));

        coffeeMachine.PrintAssortment();
        coffeeMachine.BuyerChoice();


    }
}