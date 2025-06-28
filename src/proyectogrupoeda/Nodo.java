/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupoeda;
public class Nodo {
    int clave;
    Nodo siguiente;
    Nodo anterior;  // Nuevo puntero hacia el nodo anterior
    
    public Nodo(int valor) {
        this.clave = valor;
        this.siguiente = null;
        this.anterior = null;
    }
}
