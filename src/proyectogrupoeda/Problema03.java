/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupoeda;

import java.util.Scanner;

public class Problema03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        System.out.println("Ingrese la cantidad de elementos:");
        int n = sc.nextInt();

        System.out.println("Ingrese los elementos (separados por un espacio):");
        for (int i = 0; i < n; i++) {
            lista.insertarFinal(sc.nextInt());
        }

        System.out.println("Lista original:");
        lista.mostrar();

        lista.reordenar();

        System.out.println("Lista reordenada:");
        lista.mostrar();
    }
}
