package superfunciones_v3_inline;

import superfunciones_v3_inline.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class SuperFunciones {

    public static List<Integer> filtrar(List<Integer> valores, Predicado predicado) {
        List<Integer> resultado = new ArrayList<>() {
        };
        for (Integer numero : valores) {
            if (Boolean.TRUE.equals(predicado.test(numero))) {
                resultado.add(numero);
            }
        }
        return resultado;
    }

    public static List<Integer> proveer(int tamaño, Proveedor proveedor) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < tamaño; i++) {
            lista.add(proveedor.obtener());
        }
        return lista;
    }

    public static List<Integer> transformar(List<Integer> lista, Funcion funcion) {
        List<Integer> valores = new ArrayList<>();
        for (Integer valor :
                lista) {
            valores.add(funcion.aplicar(valor));

        }
        return valores;
    }

    public static List<Integer> actuar(List<Integer> lista , Consumidor consumidor){
        for (Integer valor:
             lista) {
            consumidor.aceptar(valor);
        }
        return lista;
    }
    public static Integer reducir (List<Integer> valores, Integer identidad, FuncionBinaria funcionBinaria ) {
        int total = identidad;
        for (Integer valor:
            valores ) {
            total = funcionBinaria.aplicar(total, valor);
        }
        return total;
    }

}
