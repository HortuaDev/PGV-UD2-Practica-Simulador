import java.util.Random;

import net.salesianos.sincronized.Store;
import net.salesianos.threads.Client;
import net.salesianos.threads.Manufacturer;

public class App {
    public static void main(String[] args) throws Exception {

        // experimetOne();
        // experimentTwo();
        experimentoTres();

    }

    public static void experimetOne() throws Exception {
        Store store = new Store(5);

        Manufacturer productor = new Manufacturer("uno", 5, store);
        Client consumidor = new Client("uno", 5, store);

        productor.start();
        consumidor.start();

        productor.join();
        consumidor.join();
    }

    public static void experimentTwo() throws Exception {
        Store store = new Store(5);

        Manufacturer productor = new Manufacturer("rapido", 5, store) {
            @Override
            public void run() {
                Random rand = new Random();
                for (int i = 0; i < getTotalManufacturingProducts(); i++) {
                    try {
                        Thread.sleep(rand.nextInt(200) + 50); // ⚡ 50–250 ms
                        String finalProduct = "Producto rápido #" + i;
                        store.saveProduct(finalProduct);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        Client consumidor = new Client("lento", 5, store) {
            @Override
            public void run() {
                Random rand = new Random();
                for (int i = 0; i < getTotalProductsToConsume(); i++) {
                    try {
                        store.deleteProduct();
                        Thread.sleep(rand.nextInt(1000) + 500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        productor.start();
        consumidor.start();

        productor.join();
        consumidor.join();
    }

    public static void experimentoTres() throws Exception {
        Store store = new Store(5);

        Manufacturer productor1 = new Manufacturer("alta-prioridad-1", 5, store);
        Manufacturer productor2 = new Manufacturer("alta-prioridad-2", 5, store);

        Client consumidor = new Client("normal", 5, store);

        productor1.setPriority(Thread.MAX_PRIORITY);
        productor2.setPriority(Thread.MAX_PRIORITY);
        consumidor.setPriority(Thread.NORM_PRIORITY);

        productor1.start();
        productor2.start();
        consumidor.start();

        productor1.join();
        productor2.join();
        consumidor.join();
    }

}
