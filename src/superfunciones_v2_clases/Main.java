package superfunciones_v2_clases;

import superfunciones_v2_clases.clases.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // 1. Crear lista de enteros
        List<Integer> numeros = SuperFunciones.proveer(10, new Naturales());
        System.out.println(numeros);

        // 2. filtar pares
        List<Integer> pares = SuperFunciones.filtrar(numeros, new SoloPares() );

        System.out.println("filtrar pares " + pares);

        // 2.1 filtar impares
        List<Integer> impares = SuperFunciones.filtrar(numeros, new Soloimpares() );

        System.out.println("filtrar impares " + impares);

        // 3. pasar al cuadrado
        List<Integer> cuadrado = SuperFunciones.transformar(pares, new Doble());
        System.out.println(cuadrado);

        // 4. mostrar cada cuadrado por pantalla
        SuperFunciones.actuar(cuadrado, new Imprimir());

        // 5. Mostrar la suma de los cuadrados
        Integer suma = SuperFunciones.reducir(cuadrado,0,new Sumador());
        System.out.println("la suma es " + suma);
    }

    private List<Integer> mostrarListaCuadrados(List<Integer> cuadrado) {
        for (Integer numero : cuadrado) {
            System.out.println(numero);
        }
        return cuadrado;
    }
}
