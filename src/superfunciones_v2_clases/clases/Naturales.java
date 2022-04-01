package superfunciones_v2_clases.clases;

import superfunciones_v2_clases.interfaces.Proveedor;

public class Naturales implements Proveedor {
    private static int next = 0;
    @Override
    public int obtener() {
        return next++;
    }
}
