
import net.salesianos.sincronized.Store;
import net.salesianos.threads.Client;
import net.salesianos.threads.Manufacturer;

public class App {
    public static void main(String[] args) throws Exception {

        experimentoUno();

    }

    public static void experimentoUno() throws Exception {
        Store store = new Store(5);

        Manufacturer productor = new Manufacturer("P1", 5, store);

        Client consumidor = new Client("C1", 5, store);

        productor.start();
        consumidor.start();

        productor.join();
        consumidor.join();
    }

}
