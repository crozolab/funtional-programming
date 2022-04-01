package superfunciones_v2_clases.clases;

import superfunciones_v2_clases.interfaces.Consumidor;

public class Imprimir implements Consumidor {
    @Override
    public void aceptar(int valor) {
        System.out.println(valor);
    }
}
