import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CSVReader reader = new CSVReader();
        String filePath = "data/products.csv"; // 파일명 확인 필요
        HashSet<Product> products = new HashSet<>(reader.readProductsFromFile(filePath));
        Map<String, Integer> productPrices = new HashMap<>();
        for (Product product : products) {
            productPrices.put(product.getName(), (int) product.getPrice());
        }
        ShoppingCart cart = new ShoppingCart(productPrices);


        Scanner scanner = new Scanner(System.in);
        String input;
        boolean running = true;

        System.out.println("================= 장바구니 어플리케이션 =================");
        System.out.println("가능한 기능 : 추가, 삭제, 장바구니, 상품목록, 종료");
        System.out.println("추가와 삭제는 상품명과 수량을 입력하세요. ex) 추가 우유 3");

        System.out.println("편의점 상품 목록:");
        for (Product product : products) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        while (running) {

            System.out.print("명령어 입력: ");
            input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+", 3); // 명령어 구분 위함
            String command = parts[0];

            switch (command) {
                case "추가":
                    if (parts.length == 3) {
                        String productName = parts[1];
                        try {
                            int quantity = Integer.parseInt(parts[2]);
                            cart.addProduct(productName, quantity);
                        } catch (NumberFormatException e) {
                            System.out.println("수량에는 정수만 입력 가능합니다.");
                        }
                    } else {
                        System.out.println("잘못 입력하셨습니다.. 사용법: 추가 <상품명> <수량>");
                    }
                    break;
                case "삭제":
                    if (parts.length == 3) {
                        String productName = parts[1];
                        try {
                            int quantity = Integer.parseInt(parts[2]);
                            cart.removeProduct(productName, quantity);
                        } catch (NumberFormatException e) {
                            System.out.println("수량에는 정수만 입력 가능합니다.");
                        }
                    } else {
                        System.out.println("잘못 입력하셨습니다.. 사용법: 추가 <상품명> <수량>");
                    }
                    break;
                case "상품목록":
                    System.out.println("편의점 상품 목록:");
                    for (Product product : products) {
                        System.out.println(product.getName() + " : " + product.getPrice());
                    }
                    break;
                case "장바구니":
                    cart.showItems();
                    break;
                case "종료":
                    running = false;
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다. 가능한 명령어 목록 : 추가, 삭제, 장바구니, 상품목록, 종료");
            }
        }

        System.out.println("================= 시스템 종료 =================");
        scanner.close();
    }
}