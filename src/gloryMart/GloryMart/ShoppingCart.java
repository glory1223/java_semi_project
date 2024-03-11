package GloryMart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Order> items;
    private boolean isMember; // 장바구니 소속 사용자의 멤버쉽 여부

    public ShoppingCart(boolean isMember) {
        this.items = new ArrayList<>();
        this.isMember = isMember;
    }

    public void addToCart(Order item) {
        items.add(item);
        item.addToCart();
    }

    public int calculateTotal(User user) {
        int total = 0;
        for (Order item : items) {
            item.calculateTotal();
            total += item.getPrice();
        }

        if (!isMember) {
            total += 2000; // 비멤버쉽 사용자에게 배송비 추가
        }

        System.out.println("총 가격(배송비 포함): " + total + "원");

        // 나머지 내용은 이전과 동일

        return total;
    }

    public void showCart() {
        System.out.println("===================== 장바구니 ======================");
        for (Order item : items) {
            item.getName();
        }
        System.out.println("====================================================");
    }

    public void clearCart() {
        items.clear();
        System.out.println("장바구니가 비워졌습니다.");
    }
}
