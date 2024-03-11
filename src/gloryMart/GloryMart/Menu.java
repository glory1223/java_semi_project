package GloryMart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Menu {
    private Map<String, List<Product>> menu;

    public Menu() {
        menu = new HashMap<>();
        initializeMenu();
    }

    private void initializeMenu() {
        List<Product> phoneMenu = new ArrayList<>();
        phoneMenu.add(new Product("IPhone 15 Pro", 1550000));
        phoneMenu.add(new Product("IPhone 15 Pro Max", 1900000));

        List<Product> macMenu = new ArrayList<>();
        macMenu.add(new Product("M3 MacBook Air ", 1890000));
        macMenu.add(new Product("MacBook Pro 14", 2390000));

        menu.put("아이폰", phoneMenu);
        menu.put("맥북", macMenu);
    }

    public List<Product> getMenu(String category) {
        return menu.get(category);
    }
}
