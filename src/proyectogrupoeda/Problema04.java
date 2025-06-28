//INVERTIR UNA SUBLISTA DE UNA LISTA ENLAZADA
package proyectogrupoeda;

import java.util.Scanner;

public class Problema04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        System.out.println("Ingrese la cantidad de elementos:");
        int n = sc.nextInt();

        System.out.println("Ingrese los elementos (separados por un espacio cada uno):");
        for (int i = 0; i < n; i++) {
            lista.insertarFinal(sc.nextInt());
        }

        System.out.println("Ingrese la posicion inicial (a):");
        int a = sc.nextInt();

        System.out.println("Ingrese la posicion final (b):");
        int b = sc.nextInt();

        System.out.println("Lista original:");
        lista.mostrar();

        lista.invertirSublista(a, b);

        System.out.println("Lista luego de invertir de " + a + " a " + b + ":");
        lista.mostrar();
    }
}

