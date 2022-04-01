package superfunciones_v2_clases.clases;

import superfunciones_v2_clases.interfaces.FuncionBinaria;

public class Sumador implements FuncionBinaria {
    @Override
    public Integer aplicar(Integer valor1, Integer valor2) {
        return valor1+valor2;
    }
}
