package gloryMarket.project;

public class Product implements PurchaseAble {

    private String productName; //상품이름
    private int price; //가격

    public Product(String productName, int price) {
        this.productName = productName;
        this.price =price;
    }

    @Override
    public void addCart(User user, Product product, int quantity) {
//구매시 특별한 동작이 필요하다면 여기에 추가
    }

    @Override
    public int calculateCart(User user) {
        //가격을 반환하거나 특별한 할인/정산 로직을 적용
        return price;
    }

    @Override
    public int calculateCart() {
        return 0;
    }


    @Override
    public void payCart() {
//특별한 결제 처리 동작이 필요하다면 여기에 추가
        System.out.println("구매가 완료되었습니다. 평균배송일은 1~3일입니다.");
    }
}
