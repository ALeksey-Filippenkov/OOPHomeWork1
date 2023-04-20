public class Milk extends Product {

    private double fatСontent;

    public Milk(String name, int price, double fatСontent) {
        super(name, price);
        this.fatСontent = fatСontent;
    }

    @Override
    public String toString() {
        return String.format("%s Жирность: %.2f", super.toString(), fatСontent);
    }
}
