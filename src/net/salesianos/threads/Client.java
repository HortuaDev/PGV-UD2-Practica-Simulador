package net.salesianos.threads;

import java.util.Random;

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

    @Override
    public void run() {

        Random rand = new Random();

        for (int i = 0; i < totalProductsToConsume; i++) {
            try {
                System.out.println("Cliente:  " + getName() +
                        " intenta consumir producto (" + (i + 1) + "/" + totalProductsToConsume + ")");

                String product = store.deleteProduct();

                int t = 1500;
                System.out.println("Cliente:  " + getName() +
                        " consumiendo: " + product + " (tiempo=" + t + "ms)");

                Thread.sleep(t);

                System.out.println("Cliente:  " + getName() +
                        " consumio: " + product);

            } catch (InterruptedException e) {
                System.out.println("Cliente:  " + getName() + " interrumpido.");
            }
        }

        System.out.println("Cliente:  " + getName() +
                " termino de consumir " + totalProductsToConsume + " productos.");
    }
}
