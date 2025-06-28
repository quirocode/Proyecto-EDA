//GRUPO DE LISTAS ENLAZADAS INVERSAS
package proyectogrupoeda;
import java.util.Scanner;

public class Problema01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        System.out.println("Ingrese la cantidad de elementos:");
        int n = sc.nextInt();

        System.out.println("Ingrese los elementos (separados por un espacio cada uno):");
        for (int i = 0; i < n; i++) {
            lista.insertarFinal(sc.nextInt());
        }

        System.out.println("Ingrese k:");
        int k = sc.nextInt();

        System.out.println("Lista original:");
        lista.mostrar();

        lista.invertirEnGrupos(k);

        System.out.println("Lista luego de invertir en grupos de " + k + ":");
        lista.mostrar();
    }
}

