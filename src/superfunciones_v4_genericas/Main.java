package superfunciones_v4_genericas;
import superfunciones_v4_genericas.interfaces.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // 1. Crear lista de enteros
        List<Integer> numeros = SuperFunciones.proveer(10, new Proveedor<>() {
            private int next = 0;

            @Override
            public Integer obtener() {
                return next++;
            }
        });
        System.out.println(numeros);

        // 2. filtar pares
        List<Integer> pares = SuperFunciones.filtrar(numeros, new Predicado<>() {
            @Override
            public Boolean test(Integer valor) {
                return valor % 2 == 0;
            }
        });

        System.out.println("filtrar pares " + pares);

        // 2.1 filtar impares
        List<Integer> impares = SuperFunciones.filtrar(numeros, new Predicado<>() {
            @Override
            public Boolean test(Integer valor) {
                return valor % 2 != 0;
            }
        });

        System.out.println("filtrar impares " + impares);

        // 3. pasar al cuadrado
        List<Integer> cuadrado = SuperFunciones.transformar(pares, new OperadorUnario<>() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor * valor;
            }
        });

        System.out.println(cuadrado);

        // 4. mostrar cada cuadrado por pantalla
        SuperFunciones.actuar(cuadrado, new Consumidor<Integer, Void>() {

            @Override
            public Void aceptar(Integer valor) {
                System.out.println(valor);
                return null;
            }
        });
        Consumidor consumidor = (Consumidor<String, String>) valor -> {
            System.out.println(valor);
            return valor;
        };

        SuperFunciones.consumir(List.of("hola","como estas?") , consumidor);

        // 5. Mostrar la suma de los cuadrados
        Integer suma = SuperFunciones.reducir(cuadrado, 0, new OperadorBinario<>() {
            @Override
            public Integer aplicar(Integer valor1, Integer valor2) {
                return valor1+valor2;
            }
        });
        System.out.println("la suma es " + suma);
    }

}
