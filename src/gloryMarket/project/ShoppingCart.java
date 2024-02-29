package gloryMarket.project;


public class ShoppingCart implements PurchaseAble {
    private Product[] items; //장바구니에 추가한 제품리스트
    private  int itemCount; //장바구니의 담긴 제품의 개수

    ShoppingCart () {
        this.items = new Product[100];  // 최대 100개를 담을수 있는 배열
        this.itemCount = 0;
    }


    //제품과 수량을 추가하는 메소드
    public void addItem(Product product, int quantity) {

        //배열에 해당제품을 지정된 수량만큼 추가
        for (int i = 0; i < quantity; i++) {
            items[itemCount++] = product; // 반복문을 돌때마다 itemCount가 증가하면서 제품이 저장됨.
        }
    }

    public int calculateAll() {
      int sumAll = 0; // 총 결제금액
        for(int i = 0; i < itemCount; i++) {

            sumAll += items[i].calculateCart(); // items[i].Product객체의가격
        }
        return sumAll;
     }


     //장바구니에 제품을 추가
    @Override
    public void addCart(User user, Product product, int quantity) {
        addItem(product, quantity); //현재클래스의 addItem 메소드 실행
    }




    @Override
    public int calculateCart(User user) {
        return 0;
    }

    @Override
    public int calculateCart() {
        return 0;
    }

    @Override
    public void payCart() {
    //쇼핑카트에 대한 결제 처리 동작이 필요하다면 여기에 추가하자
    }
}
