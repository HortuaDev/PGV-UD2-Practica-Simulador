import java.util.Random;

import net.salesianos.sincronized.Store;
import net.salesianos.threads.Client;
import net.salesianos.threads.Manufacturer;

public class App {
    public static void main(String[] args) throws Exception {

        // experimetOne();
        experimentoDos();
        // experimentThree();

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

    public static void experimentoDos() throws Exception {
        Store store = new Store(5);

        Manufacturer productor = new Manufacturer("rapido", 5, store) {
            @Override
            public void run() {
                Random rand = new Random();
                for (int i = 0; i < getTotalManufacturingProducts(); i++) {
                    try {
                        Thread.sleep(rand.nextInt(150) + 50);
                        String finalProduct = "Producto rapido #" + i;
                        System.out.println("Productor (rapido) produjo: " + finalProduct);
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
                        String p = store.deleteProduct();
                        int t = rand.nextInt(1200) + 800;
                        System.out.println("Consumidor (lento) consumiendo: " + p + " (" + t + "ms)");
                        Thread.sleep(t);
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

    public static void experimentThree() throws Exception {
        Store store = new Store(5);

        Manufacturer productor = new Manufacturer("alta-prioridad", 5, store);
        Client consumidor = new Client("normal", 5, store);

        productor.setPriority(Thread.MAX_PRIORITY);
        consumidor.setPriority(Thread.NORM_PRIORITY);

        productor.start();
        consumidor.start();

        productor.join();
        consumidor.join();
    }

}
