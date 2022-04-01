package superfunciones_v2_clases.clases;

import superfunciones_v2_clases.interfaces.Proveedor;

import java.util.Random;

public class Aleatorio implements Proveedor {
    Random random = new Random();
    @Override
    public int obtener() {
        return random.nextInt(1000);

    }
}
