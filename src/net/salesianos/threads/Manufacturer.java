package net.salesianos.threads;

import java.util.Random;

import net.salesianos.sincronized.Store;

public class Manufacturer extends Thread {

    private final int totalManufacturingProducts;
    private final String name;
    private final Store store;

    private final String[] typeProducts = {
            "Lacteos", "Carnes", "Frutas", "Verduras", "Bebidas",
            "Snacks", "Panaderia", "Limpieza", "Higiene", "Congelados"
    };

    public Manufacturer(String name, int totalManufacturingProducts, Store store) {
        this.name = name;
        this.totalManufacturingProducts = totalManufacturingProducts;
        this.store = store;
        setName("Productor-" + name);
    }

    public int getTotalManufacturingProducts() {
        return this.totalManufacturingProducts;
    }

    @Override
    public void run() {

        Random rand = new Random();

        for (int i = 0; i < totalManufacturingProducts; i++) {

            try {
                Thread.sleep(300);

                String productType = typeProducts[rand.nextInt(typeProducts.length)];

                String finalProduct = productType + " - #" + i + " producido por " + getName();

                System.out.println("Productor:  " + getName() +
                        " fabrico: " + finalProduct +
                        " (tiempo=" + 300 + "ms)");

                store.saveProduct(finalProduct);

            } catch (InterruptedException e) {
                System.out.println("Productor:  " + getName() + " interrumpido.");
            }
        }

        System.out.println("Productor:  " + getName() +
                " termino de fabricar " + totalManufacturingProducts + " productos.");
    }
}
