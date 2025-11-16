package net.salesianos.threads;

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
}
