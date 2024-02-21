# goorm_back
과제 제출 레포입니다.

### Task08. LinkedList 만들기
<details >
<summary> 요구사항 </summary>
  
<br>

* **간단한 MyLinkedList를 구현하기.**

* **add()**: MyLinkedList의 맨 마지막 노드에 data를 추가할 수 있습니다. <br>
* **get(index)**: MyLinkedList의 앞에서부터 노드의 data를 return 합니다. <br>
* **delete(index)**: MyLinkedList의 앞에서부터 노드의 데이터를 삭제합니다. <br>
* 위의 api를 제공하면서, data의 타입은 LinkedList를 사용할 때 정할 수 있는 **제네릭**으로 구현합니다. <br>

  <br>

* **추가 과제**
  * Iterator interface를 implements 한 클래스에 구현하여 **for-each** 문과 호환되는 반복자를 제공합니다.
  * MyLinkedList를 이용해서 **Queue와** **Stack을** 구현해봅니다.

  <br>

  * console 로 확인한 이미지
   
![image](https://github.com/khv9786/goorm_back/assets/96505736/58e30c76-2c82-49c6-933b-88ce649eafda)
=====================================================================================================
</details>

### Task09. 장바구니 기능 구현하기

<details >
<summary> 요구사항 </summary>
  
<br>

## 장바구니 구현하기

* 쇼핑몰에서 자주 사용하는 기능인 ‘장바구니’ 기능을 java로 구현합니다. <br>
* HashSet을 사용하여 상품 목록을 만들고, HashMap을 사용하여 장바구니에 상품을 담습니다. <br>
* 구현하기 위해서는 다음과 같은 클래스가 필요합니다. <br>
---

### 상품
* 상품의 key, 이름, 가격을 필드로 가지고 있습니다. <br>
* equals() 및 hashCode() 함수를 override 해야합니다. <br>
* HashSet을 사용할때 중복된 상품이 상품목록에 들어가지 않게 이 함수들이 사용되어야 합니다.<br>
* 장바구니: 두개 이상의 상품을 담을 수 있어야 합니다. (ex. 우유 2개, 화장지 3개)<br>
* items를 가지고 있습니다. <br>
---

### 함수
* showItems() <br>
* addProduct() <br>
* removeProduct() <br>
---


### 장바구니 어플리케이션은 다음과 같은 기능을 제공해야 합니다.

1. 상품을 입력하여 상품 목록을 구성합니다.
2. 장바구니에 상품을 담습니다. 이때, 상품을 몇 개 담을 것인지 또한 명시되어야 합니다. ex. 우유 2개 담기, 사과 1개 담기
3. 장바구니에서 상품을 제거합니다. 이때, 몇 개의 상품을 뺄 것인지 명시되어야 합니다. ex. 우유 1개 빼기
4. 장바구니에 담겨있는 상품들의 이름과 수량을 출력해야 합니다. <br>

---

### HashSet과 HashMap을 사용하여 위 기능을 탑재한 장바구니를 구현하고,
### 다음과 같은 코드에서 정상적으로 돌아가게끔 구성합니다.

---

```Java
public class CartApp {
    public static void main(String[] args) {
    // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();
    // TODO: 상품 클래스를 생성하여 상품목록에 넣는다.
    // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }
    // 장바구니 생성
        Cart myCart = new Cart();
    // TODO: 상품을 장바구니에 추가
    // TODO: 상품을 장바구니에서 제거
    // TODO: 장바구니에 현재 담긴 상품들을 출력 (상품이름, 각 상품의 갯수)
    }
}
```


(하위과제)

● I/O 스트림을 사용하여 csv 파일로부터 상품목록을 불러올 수 있도록 장바구니 앱을 수정합니다.
</details>

<details>
<summary> 파일 구조 </summary>

```Java
Task09.ShoppingCart/
├── src/
│   ├── Main.java
│   ├── Product.java
│   ├── ShoppingCart.java
│   ├── ShowProductList.java
│   └── CSVReader.java
└── data/
    └── products.csv
```
products.csv 파일

![image](https://github.com/khv9786/goorm_back/assets/96505736/47955ca0-787e-480e-afec-60dd1b75d427)


</details>

<details>
<summary> 구현 예시 </summary>

## 기능 명세

* **추가**   - csv 로 받아온 상품 리스트에 있는 물건만 장바구니에 추가가 가능하다.
* **장바구니** - 장바구니에 담긴 물건과 개수, 총 금액을 확인할 수 있다.
* **삭제**   - 장바구니에 있는 물건만 삭제가 가능하다. 삭제 시 수량이 변경된다.
* **상품목록** - csv 파일의 상품명과 가격을 확인 할 수 있다. (format을 이용해 가독성을 높혔다.)
* **종료**   - 어플리케이션을 종료한다.

### 초기 화면
![image](https://github.com/khv9786/goorm_back/assets/96505736/1a42801c-f5a6-4a18-b3e1-867cc0f8ce6d)

---

### 추가
![image](https://github.com/khv9786/goorm_back/assets/96505736/fc37f2f1-cba8-4113-9e11-cf5107c256ca)

---

### 장바구니 확인
![image](https://github.com/khv9786/goorm_back/assets/96505736/3ba89ae2-ae11-4a5e-bf09-7877103d93e7)

---

### 삭제 
![image](https://github.com/khv9786/goorm_back/assets/96505736/d0b73024-29e1-4272-85cb-2b581a9e2f91)

---
### 상품 목록
![image](https://github.com/khv9786/goorm_back/assets/96505736/e3120579-0766-400c-a19f-2f1f76262e44)

</details>
