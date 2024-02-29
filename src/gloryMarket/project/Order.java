package gloryMarket.project;

public class Order implements PurchaseAble {


    private User user; //주문을 하는 사용자
    private ShoppingCart shoppingCart; //주문자의 장바구니

    Order (User user, ShoppingCart shoppingCart) { //주문을 하는 사용자와 주문자의 장바구니를 매개변수로 받아 초기화
        this.user = user;
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void addCart(User user, Product product, int quantity) {
        //주문에서는 카트에 담기가 필요하지않음
    }

    @Override
    public int calculateCart(User user) {
        // 주문의 총결제금액은 shoppingCart에서 계산
        return shoppingCart.calculateAll();
    }

    @Override
    public int calculateCart() {
        return 0;
    }


    @Override
    public void payCart() {
//주문에서는 결제 처리가 이미 ShoppingCart에서 이루어짐
    }
}
