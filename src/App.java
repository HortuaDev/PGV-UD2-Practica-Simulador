import net.salesianos.sincronized.Store;
import net.salesianos.threads.Client;
import net.salesianos.threads.Manufacturer;

public class App {
    public static void main(String[] args) throws Exception {

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

}
