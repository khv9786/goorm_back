import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
    private Map<String, Integer> items;
    private Map<String, Integer> productPrices; // 상품명과 가격

    public ShoppingCart(Map<String, Integer> productPrices) {
        // Hash로 관리
        this.items = new HashMap<>();
        this.productPrices = productPrices; // CSV에서 읽은 상품 가격 정보
    }

    public void addProduct(String productName, int quantity) {
        if (!productPrices.containsKey(productName)) {
            System.out.println(productName + "는(은) 상품 목록에 없습니다.");
            return;
        }
        items.put(productName, items.getOrDefault(productName, 0) + quantity);
        System.out.println(productName + ": " + quantity + "개가 추가되었습니다.");
    }

    public void removeProduct(String productName, int quantity) {
        if (!items.containsKey(productName)) {
            System.out.println(productName + "는(은) 장바구니에 없습니다.");
            return;
        }
        int currentQuantity = items.get(productName);
        int removedQuantity = Math.min(quantity, currentQuantity); // 실제 삭제되는 수량
        items.put(productName, currentQuantity - removedQuantity);
        if (currentQuantity - removedQuantity <= 0) {
            items.remove(productName);
        }
        System.out.println(productName + ": " + removedQuantity + "개가 삭제되었습니다.");
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

        String format = "%-" + (maxNameLength + 1) + "s: %d개";

        System.out.println("장바구니:");
        items.forEach((name, quantity) -> System.out.printf(format + "\n", name, quantity));

        showTotalPrice();
    }

    private void showTotalPrice() {
        int totalPrice = items.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * productPrices.get(entry.getKey()))
                .sum();
        System.out.println("총 가격: " + totalPrice + "원");
    }
}