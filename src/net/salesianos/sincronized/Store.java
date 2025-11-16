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

    public synchronized void saveProduct(String product) throws InterruptedException {

        while (products.size() == maxSize) {
            System.out.println("Almacen lleno. Productor a la espera");
            wait();
        }

        products.add(product);
        System.out.println("Producto agregado: " + product +
                " (ocupación " + products.size() + "/" + maxSize + ")");

        notifyAll();
    }
}
