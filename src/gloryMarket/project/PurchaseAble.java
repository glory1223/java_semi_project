package gloryMarket.project;

public interface PurchaseAble {


    void addCart(User user, Product product, int quantity);


    int calculateCart(User user);
    int calculateCart();


    void payCart();
}
