package gloryMarket.project;

public class GloryMarket implements PurchaseAble {


 private static GloryMarket instance; //싱글톤 객체를 저장하는 변수
    private  User[] users;
    private Product[] products;
    private Order[] orders;
    private int userCount;
    private int productCount;
    private int orderCount;

    //생성자
    private GloryMarket () {
        this.users = new User[100];
        this.products = new Product[100];
        this.orders = new Order[100];
        this.userCount = 0;
        this.productCount = 0;
        this.orderCount = 0;
    }

public static GloryMarket getInstance() {
        if(instance == null) {
            instance = new GloryMarket();
        }
        return  instance;
}


//새로운 사용자를 등록하는 메소드 (등록된 사용자배열에 사용자를 추가)
public void addUser(User user) {
        users[userCount++] = user;
}


//새로운 상품을 등록하는 메소드 (등록된 상품배열에 상품을 추가)
    public void addProduct(Product product) {
        products[productCount++] = product;
    }

    //해당 사용자의 장바구니에 상품을 추가하는 메소드
    @Override
    public void addCart(User user, Product product, int quantity) {

    }


    //해당 사용자의 장바구니에 있는 상품의 총가격을 계산하는 메소드

    @Override
    public int calculateCart(User user) {
       return user.getShoppingCart().calculateAll();
    }

    @Override
    public int calculateCart() {
        return 0;
    }


    //해당 사용자의 장바구니에있는 상품들을 결제하고 장바구니를 비우는 메소드

    @Override
    public void payCart() {

    }
}
