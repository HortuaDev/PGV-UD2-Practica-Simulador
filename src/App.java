import java.util.Random;

import net.salesianos.sincronized.Store;
import net.salesianos.threads.Client;
import net.salesianos.threads.Manufacturer;

public class App {
    public static void main(String[] args) throws Exception {

        experimentoTres();

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
