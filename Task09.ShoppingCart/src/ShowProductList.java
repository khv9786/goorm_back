import java.util.Map;

public class ShowProductList {
    public static void formatProductList(Map<String, Integer> items) {
        if (items.isEmpty()) {
            System.out.println("상품 목록이 비어있습니다.");
            return;
        }
        System.out.println("편의점 상품 목록:");

        int maxNameLength = items.keySet().stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        StringBuilder formattedList = new StringBuilder();
        String format = "%-" + (maxNameLength + 2) + "s: %d\n";

        items.forEach((name, quantity) -> formattedList.append(String.format(format, name, quantity)));
        System.out.println(formattedList);
    }
}
