import java.util.Map;

public class FormatUtils {
    public static String formatProductList(Map<String, Integer> items) {
        if (items.isEmpty()) {
            return "상품 목록이 비어있습니다.";
        }

        int maxNameLength = items.keySet().stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        StringBuilder formattedList = new StringBuilder();
        String format = "%-" + (maxNameLength + 1) + "s: %d\n";

        items.forEach((name, quantity) -> formattedList.append(String.format(format, name, quantity)));

        return formattedList.toString();
    }
}
