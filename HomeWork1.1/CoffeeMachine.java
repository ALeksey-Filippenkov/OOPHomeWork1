import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CoffeeMachine {
    private int done = 100;
    private final int percentageOfReadiness = 20;
    private List<Coffee> assortment = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public int GetDone() {
        return done;
    }

    public CoffeeMachine addProduct(Coffee coffee) {
        assortment.add(coffee);
        return this;
    }

    private List<Coffee> GetAssortment() {
        return assortment;
    }

    public void PrintAssortment() {
        System.out.println("В кофейном автомате представлены следующие товары: ");
        for (Coffee string : GetAssortment())
            System.out.println(string);
    }

    public void BuyerChoice() {
        System.out.println("=======================================================");
        System.out.println("Что бы вы хотели купить?");
        System.out.println("Введите Наименование: ");
        String name = in.next();
        String nameToLower = name.toLowerCase();
        boolean flag = FindCoffee(nameToLower);
        if (flag) {
            System.out.println("Введите объем: ");
            int volume = in.nextInt();
            System.out.println("Какое количество сахара положить?");
            int sugar = in.nextInt();
            BuyCoffee(nameToLower, volume, sugar);
        } else
            RepeatInput();
    }

    private boolean FindCoffee(String nameToLower) {
        boolean flag = false;
        for (int i = 0; i < GetAssortment().size(); i++) {
            if (GetAssortment().get(i).GetName().toLowerCase().equals(nameToLower))
                return flag = true;
        }
        return flag;
    }

    private void BuyCoffee(String nameToLower, int volume, int sugar) {
        Coffee coffee = FindCoffee(nameToLower, volume);
        coffee.SetSugar(sugar);
        if (nameToLower == null || volume == 0) {
            System.out.println("Товар не найден!");
            RepeatInput();
        } else {
            System.out.printf("Кофе стоит: %d руб.\n", coffee.GetPrice());

            System.out.print("Введите сумму: ");
            int summ = in.nextInt();
            if (coffee.GetPrice() == summ) {
                PercentTime();
                if (sugar == 0)
                    System.out.printf("Ваш %s с без сахара готов!", coffee.GetName(), coffee.GetSugar());
                else {
                    System.out.printf("Ваш %s с %d кусочками сахара готов!", coffee.GetName(), coffee.GetSugar());
                    System.out.println("\nМожете забрать. \nВсего доброго!");
                }
            } else if (coffee.GetPrice() < summ) {
                int change = summ - coffee.GetPrice();
                PercentTime();
                System.out.printf("Ваша сдача: %d руб.", change);
            } else {
                System.out.println("Нехватает средств!");
                RepeatInput();
            }

        }
    }

    private Coffee FindCoffee(String nameToLower, int volume) {
        for (int i = 0; i < GetAssortment().size(); i++) {
            if (GetAssortment().get(i).GetName().toLowerCase().equals(nameToLower)
                    && GetAssortment().get(i).getVolume().equals(volume))
                return GetAssortment().get(i);
        }
        return null;
    }

    private void PercentTime() {
        try {
            System.out.println("Товар готовится...");
            for (int i = 0; i < GetDone();) {
                TimeUnit.SECONDS.sleep(1);
                System.out.printf("Кофе готово на %d", i += percentageOfReadiness);
                System.out.println("%");
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    private void RepeatInput() {
        System.out.println("Хотите повторить попытку ввода? \nЕcли да введите Y, если нет N");
        char exit = in.next().charAt(0);
        if (exit == 'y' || exit == 'Y')
            BuyerChoice();
        else
            System.out.println("Всего доброго.");
    }
}
