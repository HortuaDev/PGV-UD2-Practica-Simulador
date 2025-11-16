package net.salesianos.threads;

import net.salesianos.sincronized.Store;

public class Client extends Thread {

    private final String name;
    private final int totalProductsToConsume;
    private final Store store;

    public Client(String name, int totalProductsToConsume, Store store) {
        this.name = name;
        this.totalProductsToConsume = totalProductsToConsume;
        this.store = store;
        setName("Cliente-" + name);
    }

    public int getTotalProductsToConsume() {
        return this.totalProductsToConsume;
    }
}
