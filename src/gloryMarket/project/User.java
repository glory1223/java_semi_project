package gloryMarket.project;

public class User extends Person { // 추상클래스 Person을 상속받는 User클래스

    private ShoppingCart shoppingCart; // User 클래스의 인스턴스(객체)가 소유하는 장바구니

    public User(String name) {
        super(name); // 부모인 person클래스의 생성자 호출!
        this.shoppingCart = new ShoppingCart(); // 그다음에 ShoppingCart의 객체 생성하여 초기화시킴.
    }


   // 사용자의 장바구니를 반환하는 메소드
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }


    // 사용자의 장바구니를 설정하는 메소드
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
