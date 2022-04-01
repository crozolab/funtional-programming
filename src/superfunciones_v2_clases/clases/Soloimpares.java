package superfunciones_v2_clases.clases;

import superfunciones_v2_clases.interfaces.Predicado;

public class Soloimpares implements Predicado {
    @Override
    public Boolean test(Integer valor) {
        return valor %2 != 0;
    }
}
