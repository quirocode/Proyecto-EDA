/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupoeda;
import java.util.Scanner;

public class Problema02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListaEnlazada lista1 = new ListaEnlazada();
        ListaEnlazada lista2 = new ListaEnlazada();

        System.out.println("Cantidad de digitos de la primera lista:");
        int n1 = sc.nextInt();
        System.out.println("Ingrese los digitos:");
        for (int i = 0; i < n1; i++) {
            lista1.insertarFinal(sc.nextInt());
        }

        System.out.println("Cantidad de digitos de la segunda lista:");
        int n2 = sc.nextInt();
        System.out.println("Ingrese los digitos (separados por un espacio):");
        for (int i = 0; i < n2; i++) {
            lista2.insertarFinal(sc.nextInt());
        }

        System.out.println("Lista 1:");
        lista1.mostrar();
        System.out.println("Lista 2:");
        lista2.mostrar();

        ListaEnlazada resultado = lista1.restar(lista2);

        System.out.println("Resultado de la resta:");
        resultado.mostrar();
    }
}
