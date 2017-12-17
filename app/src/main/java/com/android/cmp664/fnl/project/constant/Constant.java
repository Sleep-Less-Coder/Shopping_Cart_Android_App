package com.android.cmp664.fnl.project.constant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.android.cmp664.fnl.project.model.Product;

public final class Constant {
    public static final List<Integer> QUANTITY_LIST = new ArrayList<Integer>();

    static {
        for (int i = 1; i < 11; i++) QUANTITY_LIST.add(i);
    }

    public static final Product PRODUCT1 = new Product(1, "Macbook Pro 2016", BigDecimal.valueOf(1999.99), "Macbook pro is faster and more powerful than before, yet remarkably thinner and lighter. It has the brightest, most colorful Mac notebook display ever. And it introduces the Touch Bar", "macbook_pro_2016", "macbook_pro_2016_large");
    public static final Product PRODUCT2 = new Product(2, "Dell XPS 13", BigDecimal.valueOf(1499.99), "The smallest 13-inch laptop on the planet has the world’s first virtually borderless InfinityEdge display and the latest Intel® processors.", "dell_xps_13", "dell_xps_13_large");
    public static final Product PRODUCT3 = new Product(3, "HP Spectre X360", BigDecimal.valueOf(1299.99), "The HP Spectre x360 13 Signature Edition 2 in 1 PC features a 360-degree hinge that allows for a multitude of uses, and comes with Windows 10 and an Intel 7th gen processors.", "spectre", "spectre_large");
    public static final Product PRODUCT4 = new Product(4, "Microsoft Surface Book", BigDecimal.valueOf(2999.99), "Incredibly powerful and meticulously crafted, Surface Book is a revolution in laptop design. Detach the display to transform Surface Book into a thin and light Intel Core i5/i7 PC, that runs professional grade software.", "surface_book", "surface_book_large");
    public static final Product PRODUCT5 = new Product(5, "Dell XPS 15", BigDecimal.valueOf(1899.99), "The world's smallest 15-inch XPS 9560 laptop packs powerhouse performance and a stunning InfinityEdge display with an optional touch screen.", "dell_xps_15", "dell_xps_15_large");
    public static final Product PRODUCT6 = new Product(1, "Samsung Galaxy S6 Edge", BigDecimal.valueOf(199.996), "Worldly looks and top-notch specs make the impressive, metal Samsung Galaxy S6 Edge the Android phone to beat for 2015", "samsung_galaxy_s6_edge", "galaxy_s6_edge_large");
    public static final Product PRODUCT7 = new Product(2, "HTC One M8", BigDecimal.valueOf(449.9947), "Excellent overall phone. Beautifull, battery life more than 20 hours daily and great customization in any way. 100% configuration on any aspect", "htc_one_m8", "htc_one_m8_large");
    public static final Product PRODUCT8 = new Product(3, "Xiaomi Mi3", BigDecimal.valueOf(319.998140), "Xiaomi's Mi 3 is a showcase of how Chinese phonemakers can create quality hardware without breaking the bank. This is one of the best smartphones you can buy in its price range.", "xiaomi_mi3", "xiaomi_mi3_large");

    public static final List<Product> PRODUCT_LIST = new ArrayList<Product>();

    static {
        PRODUCT_LIST.add(PRODUCT1);
        PRODUCT_LIST.add(PRODUCT2);
        PRODUCT_LIST.add(PRODUCT3);
        PRODUCT_LIST.add(PRODUCT4);
        PRODUCT_LIST.add(PRODUCT5);
        PRODUCT_LIST.add(PRODUCT6);
        PRODUCT_LIST.add(PRODUCT7);
        PRODUCT_LIST.add(PRODUCT8);
    }

    public static final String CURRENCY = "$";
}
