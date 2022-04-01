package funcional.com.imperativa_v1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // 1. Crear lista de enteros
        List<Integer> numeros = crearLista();
        System.out.println(numeros);

        // 2. filtar pares
        List<Integer> pares = filtrarPares(numeros);
        System.out.println(pares);

        // 3. pasar al cuadrado
        List<Integer> cuadrado = elevarCuadrado(pares);
        System.out.println(cuadrado);

        // 4. mostrar cada cuadrado por pantalla
        mostrarListaCuadrados(cuadrado);

        // 5. Mostrar la suma de los cuadrados
        Integer suma = sumarCuadrados(cuadrado);
        System.out.println("la suma es " + suma);
    }

    private Integer sumarCuadrados(List<Integer> cuadrado) {
        Integer suma = 0;
        for (Integer numero : cuadrado) {
            suma += numero;
        }
        return suma;
    }

    private List<Integer> mostrarListaCuadrados(List<Integer> cuadrado) {
        for (Integer numero : cuadrado) {
            System.out.println(numero);
        }
        return cuadrado;
    }

    private List<Integer> elevarCuadrado(List<Integer> pares) {
        List<Integer> resultado = new ArrayList<>();
        for (Integer numero : pares) {
            resultado.add(numero * numero);

        }
        return resultado;

    }

    private List<Integer> filtrarPares(List<Integer> numeros) {
        List<Integer> resultado = new ArrayList<>();
        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                resultado.add(numero);
            }
        }
        return resultado;
    }

    private List<Integer> crearLista() {
        return List.of(0, 1, 3, 5, 8, 13, 21, 34, 55, 89, 144);
    }
}
