public class Coffee {

    public static final int PercentageOfReadiness = 0;
    private String name;
    private int volume;
    private int price;
    private int sugar;

    public Coffee(String name, int volume, int price) {
        this.name = name;
        this.volume = volume;
        this.price = price;
    }

    public String GetName() {
        return name;
    }

    public Integer getVolume() {
        return volume;
    }

    public Integer GetPrice() {
        return price;
    }

    public Integer GetSugar() {
        return sugar;
    }


    public void SetSugar(int sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return String.format("Наименование: %s Объем: %d Цена: %d руб.", name, volume, price);
    }
}
