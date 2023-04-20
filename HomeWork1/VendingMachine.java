import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private int amount = 0;
    private List<Product> list = new ArrayList<>();

    public VendingMachine addProduct(Product product) {
        list.add(product);
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public List<Product> getList() {
        return list;
    }

    public Product findProduct(String string) {
        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).getName().equals(string))
                return getList().get(i);
        }
        return null;
    }

    public Product sellProduct(Product product) {
        try {
            Product prodFound = findProduct(product.getName());
            getList().remove(prodFound);
            amount += prodFound.getCost();
            return prodFound;
        } catch (Exception ex) {
            throw new RuntimeException("Product not found");
        }
    }
}
