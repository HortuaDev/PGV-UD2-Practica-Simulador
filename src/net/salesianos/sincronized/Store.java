package net.salesianos.sincronized;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {

    private final int maxSize;
    private final List<String> products;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.products = new ArrayList<>();
    }
}
