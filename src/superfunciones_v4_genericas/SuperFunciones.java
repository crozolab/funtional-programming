package superfunciones_v4_genericas;

import superfunciones_v4_genericas.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class SuperFunciones {

    public static <T> List<T> filtrar(List<T> valores, Predicado<T> predicado) {
        List<T> resultado = new ArrayList<>() {
        };
        for (T numero : valores) {
            if (Boolean.TRUE.equals(predicado.test(numero))) {
                resultado.add(numero);
            }
        }
        return resultado;
    }

    public static<T> List<T> proveer(int tamaño, Proveedor <T> proveedor) {
        List<T> lista = new ArrayList<>();
        for (int i = 0; i < tamaño; i++) {
            lista.add(proveedor.obtener());
        }
        return lista;
    }

    public static<T, R> List<R> transformar(List<T> lista, Funcion <T,R> funcion) {
        List<R> valores = new ArrayList<>();
        for (T valor :
                lista) {
            valores.add(funcion.aplicar(valor));

        }
        return valores;
    }

    public static<T,R> List<T> actuar(List<T> lista, Consumidor <T,R> consumidor) {
        for (T valor :
                lista) {
            consumidor.aceptar(valor);
        }
        return lista;
    }

    public static <T,R> void consumir(List<T> valores, Consumidor <T,R> consumidor){
        for (T valor: valores){
            consumidor.aceptar(valor);
        }
    }

    public static <T> T reducir(List<T> valores, T identidad, OperadorBinario <T> funcionBinaria) {
        T total = identidad;
        for (T valor :
                valores) {
            total = funcionBinaria.aplicar(total, valor);
        }
        return total;
    }

}
