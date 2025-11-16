package net.salesianos.sincronized;

import java.util.List;

public class Store extends Thread {

    private final int maxSize;
    private final List<String> products;
}
