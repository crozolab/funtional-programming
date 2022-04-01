package superfunciones_v2_clases.clases;

import superfunciones_v2_clases.interfaces.Funcion;

public class Doble implements Funcion {
    @Override
    public int aplicar(int valor) {
        return valor * valor;
    }
}
