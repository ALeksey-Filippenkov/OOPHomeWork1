/**
 * HomeWork1
 */
public class HomeWork1 {

    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(new Product("cheese", 300))
                .addProduct(new Product("water", 10))
                .addProduct(new Product("wine", 330))
                .addProduct(new Yogurt("Danone", 300, "sweet"))
                .addProduct(new Perfume("Si", 6500, "Dior"))
                .addProduct(new Milk("Пискаревское", 77, 3.5));

        for (int i = 0; i < vendingMachine.getList().size(); i++) {
            System.out.println(vendingMachine.getList().get(i));
        }
        Product found = vendingMachine.findProduct("water");
        System.out.println(found);
        System.out.println("Покупаем товар");
        Product sold = vendingMachine.sellProduct(found);
        System.out.println(sold);
        System.out.println("В автомате столько денег:");
        System.out.println(vendingMachine.getAmount());
        System.out.println("---------------------");
        for (int i = 0; i < vendingMachine.getList().size(); i++) {
            System.out.println(vendingMachine.getList().get(i));
        }
        System.out.println("Покупаем товар");
        Product perfume = vendingMachine.sellProduct(vendingMachine.findProduct("Si"));
        System.out.println(perfume);
        System.out.println("Осталось товаров: ");
        for (int i = 0; i < vendingMachine.getList().size(); i++) {
            System.out.println(vendingMachine.getList().get(i));
        }
        System.out.println("Денег в автомате: ");
        System.out.println(vendingMachine.getAmount());
        try {
            Product perf = vendingMachine.sellProduct(vendingMachine.findProduct("Si"));
            System.out.println(perf);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}