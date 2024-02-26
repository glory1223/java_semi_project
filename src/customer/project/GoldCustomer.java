package customer.project;

public class GoldCustomer extends Customer{
    double saleRatio; // 할인률 할인률은 Gold, VIP등급만 가지고 있음.

    public GoldCustomer (int customerID, String customerName) {
        super(customerID, customerName); //  super 부모한테 있는 생성자 호출

        super.customerGrade = "GOLD";
        super.bonusRatio = 0.02;
        this.saleRatio = 0.1;
    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += (price * bonusRatio); //포인트 적립
        return price - (int)(price * saleRatio); // 지불할 금액(할인률 차감)
    }
}