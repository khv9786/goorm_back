import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CSVReader {
    public Set<Product> readProductsFromFile(String filePath) {
        Set<Product> products = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // 상품명, 가격 line 스킵
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                try {
                    Product product = new Product(values[0], Integer.parseInt(values[1]));
                    products.add(product);
                } catch (NumberFormatException e) {
                    System.err.println("csv 파일을 확인하십시오 row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}