import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Integer> items;
    int total;

    public ShoppingCart() {
        // Hash로 관리
        items = new HashMap<>();
    }

    public void addProduct(String productName, int quantity) {
        items.put(productName, items.getOrDefault(productName, 0) + quantity);
    }

    public void removeProduct(String productName, int quantity) {
        if (items.containsKey(productName)) {
            int currentQuantity = items.get(productName);
            int newQuantity = currentQuantity - quantity;
            if (newQuantity > 0) {
                items.put(productName, newQuantity);
            } else {
                items.remove(productName);
            }
        }
    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }
        // 가독성을 위한 코드
        int maxNameLength = items.keySet().stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        String format = "%-" + (maxNameLength + 1) + "s: %d";

        System.out.println("장바구니:");
        items.forEach((name, quantity) -> System.out.printf(format + "\n", name, quantity));

    }
}