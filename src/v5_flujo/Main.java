package v5_flujo;

import v5_flujo.interfaces.*;


public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // proveer().filtrar().transformar().actuar().reducir()


        // 1. Crear lista de enteros
        Flujo<Integer> numeros = Flujo.proveer(10, new Proveedor<Integer>() {
            private int next = 0;

            @Override
            public Integer obtener() {
                return next++;
            }
        });
        System.out.println(numeros);

        // 2. filtar pares
        Flujo<Integer> pares = numeros.filtrar(new Predicado<>() {
            @Override
            public Boolean test(Integer valor) {
                return valor % 2 == 0;
            }
        });

        System.out.println("filtrar pares " + pares);

        // 2.1 filtar impares
        Flujo<Integer> impares = numeros.filtrar(new Predicado<>() {
            @Override
            public Boolean test(Integer valor) {
                return valor % 2 != 0;
            }
        });

        System.out.println("filtrar impares " + impares);

        // 3. pasar al cuadrado
        Flujo<Integer> cuadrado = pares.transformar(new OperadorUnario<>() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor * valor;
            }
        });

        System.out.println(cuadrado);

        // 4. mostrar cada cuadrado por pantalla
        cuadrado.actuar(new Consumidor<Integer>() {

            @Override
            public Integer aceptar(Integer valor) {
                System.out.println(valor);
                return null;
            }
        });
        // 5. Mostrar la suma de los cuadrados
        Integer suma = cuadrado.reducir( 0, new OperadorBinario<>() {
            @Override
            public Integer aplicar(Integer valor1, Integer valor2) {
                return valor1 + valor2;
            }
        });
        System.out.println("la suma es " + suma);
    }

}
