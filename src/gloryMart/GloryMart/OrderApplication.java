package GloryMart;

import java.util.List;
import java.util.Scanner;

public class OrderApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자 로그인
        System.out.println("사용자 이름을 입력하세요:");
        String username = scanner.next();

        System.out.println("금액을 얼마 충전할까요?(최소충전금액: 5000000원");
        int initialBalance = scanner.nextInt();

        User user = User.getInstance(username, initialBalance);

        System.out.println(user.getUsername() + "님, 환영합니다! 현재 잔액: " + user.getBalance() + "원");

        // 사용자 멤버쉽 여부 확인
        boolean isMember = user.isMember();

        // 장바구니 생성
        ShoppingCart shoppingCart = new ShoppingCart(isMember);

        // 메뉴 생성
        Menu menu = new Menu();

        // 멤버쉽 혜택 안내
        if (!isMember) {
            System.out.println("멤버쉽 회원이 아니시므로 배송비가 2,000원 추가됩니다.");
        }

        // 메뉴 및 장바구니 출력
        while (true) {
            System.out.println("1. 스마트 기기 주문  2. 맥북 주문  3. 멤버십 가입  4. 장바구니 확인  5. 주문 종료");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    orderSmartDevice(scanner, menu, shoppingCart);
                    break;

                case 2:
                    orderMacBook(scanner, menu, shoppingCart);
                    break;

                case 3:
                    becomeMember(user);
                    break;

                case 4:
                    showCart(scanner, shoppingCart, user);
                    break;

                case 5:
                    System.out.println("주문을 종료합니다. 감사합니다!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    break;
            }
        }
    }

    private static void orderSmartDevice(Scanner scanner, Menu menu, ShoppingCart shoppingCart) {
        System.out.println("스마트 기기 메뉴를 선택하세요: ");
        System.out.println("1. IPhone 15 Pro  2. IPhone 15 Pro Max");
        int smartDeviceChoice = scanner.nextInt();
        List<Product> smartDeviceMenu = menu.getMenu("아이폰");

        if (smartDeviceChoice >= 1 && smartDeviceChoice <= smartDeviceMenu.size()) {
            Product selectedProduct = smartDeviceMenu.get(smartDeviceChoice - 1);
            shoppingCart.addToCart(selectedProduct);
            System.out.println(selectedProduct.getName() + "의 가격은 " + selectedProduct.getPrice() + "원 입니다.");
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }

    private static void orderMacBook(Scanner scanner, Menu menu, ShoppingCart shoppingCart) {
        System.out.println("맥북 메뉴를 선택하세요: ");
        System.out.println("1. M1 MacBook Air  2. MacBook Pro 14");
        int macBookChoice = scanner.nextInt();
        List<Product> macBookMenu = menu.getMenu("맥북");

        if (macBookChoice >= 1 && macBookChoice <= macBookMenu.size()) {
            Product selectedProduct = macBookMenu.get(macBookChoice - 1);
            shoppingCart.addToCart(selectedProduct);
            System.out.println(selectedProduct.getName() + "의 가격은 " + selectedProduct.getPrice() + "원 입니다.");
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }

    private static void becomeMember(User user) {
        user.becomeMember();
    }

    private static void showCart(Scanner scanner, ShoppingCart shoppingCart, User user) {
        shoppingCart.showCart();

        // 총 구매비용 계산
        int total = shoppingCart.calculateTotal(user);

        // 멤버쉽 할인 확인
        if (user.isMember()) {
            System.out.println("멤버쉽 할인 적용: 배송비 2,000원 할인");
            total -= 2000;
        } else {
            System.out.println("비멤버쉽 회원입니다. 배송비 2,000원 추가");
            total += 2000;
        }

        System.out.println("총 구매비용(배송비 포함): " + total + "원");

        // 구매 처리
        System.out.println("1. 구매  2. 뒤로가기");
        int cartChoice = scanner.nextInt();

        switch (cartChoice) {
            case 1:
                if (user.getBalance() >= total) {
                    user.setBalance(user.getBalance() - total);
                    System.out.println("구매가 완료되었습니다. 남은 잔액: " + user.getBalance() + "원");
                    shoppingCart.clearCart(); // 장바구니 비우기
                } else {
                    System.out.println("잔액이 부족하여 구매가 불가능합니다.");
                }
                break;

            case 2:
                break;

            default:
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                break;
        }
    }
}