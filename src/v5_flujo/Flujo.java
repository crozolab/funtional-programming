package v5_flujo;

import v5_flujo.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Flujo<T> {

    private final List<T> valores;

    public Flujo(List<T> valores) {
        this.valores = valores;
    }


    public static <T> Flujo<T> proveer(int tamaño, Proveedor<T> proveedor) {
        List<T> lista = new ArrayList<>();
        for (int i = 0; i < tamaño; i++) {
            lista.add(proveedor.obtener());
        }
        return new Flujo<>(lista);
    }


    public Flujo<T> filtrar(Predicado<T> predicado) {
        List<T> resultado = new ArrayList<>() {
        };
        for (T numero : valores) {
            if (Boolean.TRUE.equals(predicado.test(numero))) {
                resultado.add(numero);
            }
        }
        return new Flujo<>(resultado);
    }


    public <R> Flujo<R> transformar(Funcion<T, R> funcion) {
        List<R> resultado = new ArrayList<>();
        for (T valor : valores) {
            resultado.add(funcion.aplicar(valor));

        }
        return new Flujo<>(resultado);
    }

    public Flujo<T> actuar(Consumidor<T> consumidor) {
        for (T valor :
                valores) {
            consumidor.aceptar(valor);
        }
        return new Flujo<>(valores);
    }


    public  T reducir(T identidad, OperadorBinario<T> funcionBinaria) {
        T total = identidad;
        for (T valor :
                valores) {
            total = funcionBinaria.aplicar(total, valor);
        }
        return total;
    }

    @Override
    public String toString() {
        return  valores.toString();
    }
}
