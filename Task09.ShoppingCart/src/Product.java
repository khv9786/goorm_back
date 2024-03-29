import java.util.Objects;

public class Product {
    private long id;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.id = ++id;
        this.name = name;
        this.price = price;
    }
    public long getId() { return id; }
    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return product.price == price &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

}