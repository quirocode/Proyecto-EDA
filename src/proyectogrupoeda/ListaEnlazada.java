/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupoeda;

/**
 *
 * @author rquir
 */
public class ListaEnlazada {
    private Nodo head;  // Referencia al primer nodo de la lista
    private Nodo tail;  // Referencia al último nodo de la lista
    private int size;   // Tamaño de la lista, número de elementos

    // Constructor de la lista enlazada, inicializa la lista vacía
    public ListaEnlazada() {
        this.head = null;  // No hay nodo al principio
        this.tail = null;  // No hay último nodo al principio
        this.size = 0;     // El tamaño de la lista es 0
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return head == null;  // Si el primer nodo (head) es null, está vacía
    }

    // Método para obtener el tamaño de la lista
    public int obtenerTamanio() {
        return size;  // Devuelve el tamaño actual de la lista
    }

    // Método para mostrar los elementos de la lista
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        Nodo actual = head;  // Comenzamos en el primer nodo
        while (actual != null) {
            System.out.print(actual.clave);  // Mostramos el valor del nodo
            if (actual.siguiente != null) {
                System.out.print(" --> ");  // Imprimimos separadores entre nodos
            }
            actual = actual.siguiente;  // Pasamos al siguiente nodo
        }
        System.out.println();  // Salto de línea al final
    }

    // Método para insertar un nodo al principio de la lista
    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);  // Creamos un nuevo nodo con el valor dado
        if (estaVacia()) {
            head = nuevo;
            tail = nuevo;  // Si la lista está vacía, head y tail apuntan al mismo nodo
        } else {
            nuevo.siguiente = head;  // El nuevo nodo apunta al primer nodo actual
            head.anterior = nuevo;   // El primer nodo actual apunta al nuevo nodo como anterior
            head = nuevo;  // Ahora head apunta al nuevo nodo
        }
        size++;  // Incrementamos el tamaño de la lista
    }

    // Método para insertar un nodo al final de la lista
    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);  // Creamos un nuevo nodo con el valor dado
        if (estaVacia()) {
            head = nuevo;
            tail = nuevo;  // Si la lista está vacía, head y tail apuntan al mismo nodo
        } else {
            tail.siguiente = nuevo;  // El último nodo apunta al nuevo nodo
            nuevo.anterior = tail;   // El nuevo nodo apunta al último nodo como anterior
            tail = nuevo;  // Ahora tail apunta al nuevo nodo
        }
        size++;  // Incrementamos el tamaño de la lista
    }

    // Método para insertar un nodo en una posición específica
    public void insertarEnPosicion(int valor, int posicion) {
        if (posicion < 1 || posicion > size + 1) {
            System.out.println("Posición inválida para inserción");
            return;
        }
        if (posicion == 1) {
            insertarInicio(valor);  // Si es la primera posición, insertamos al principio
        } else if (posicion == size + 1) {
            insertarFinal(valor);  // Si es la última posición, insertamos al final
        } else {
            Nodo nuevo = new Nodo(valor);
            Nodo actual = head;
            for (int i = 1; i < posicion - 1; i++) {
                actual = actual.siguiente;  // Nos desplazamos hasta el nodo anterior al deseado
            }
            nuevo.siguiente = actual.siguiente;  // El nuevo nodo apunta al siguiente nodo
            nuevo.anterior = actual;  // El nuevo nodo apunta al nodo anterior
            actual.siguiente.anterior = nuevo;  // El siguiente nodo apunta al nuevo nodo como anterior
            actual.siguiente = nuevo;  // El nodo anterior apunta al nuevo nodo
            size++;  // Incrementamos el tamaño de la lista
        }
    }

    // Método para actualizar el valor de un nodo en una posición específica
    public void actualizarValor(int valor, int posicion) {
        if (posicion < 1 || posicion > size) {
            System.out.println("Posición inválida para actualización");
            return;
        }
        Nodo actual = head;
        for (int i = 1; i < posicion; i++) {
            actual = actual.siguiente;  // Nos desplazamos hasta el nodo en la posición
        }
        actual.clave = valor;  // Actualizamos el valor del nodo
    }

    // Método para eliminar el primer nodo de la lista
    public void eliminarInicio() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        if (head == tail) {  // Si solo hay un nodo
            head = null;
            tail = null;
        } else {
            head = head.siguiente;  // El siguiente nodo pasa a ser el nuevo head
            head.anterior = null;   // El nuevo head no tiene un nodo anterior
        }
        size--;  // Reducimos el tamaño de la lista
    }

    // Método para eliminar el último nodo de la lista
    public void eliminarFinal() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        if (head == tail) {  // Si solo hay un nodo
            head = null;
            tail = null;
        } else {
            tail = tail.anterior;  // El nodo anterior a tail pasa a ser el nuevo tail
            tail.siguiente = null;  // El nuevo tail no tiene un nodo siguiente
        }
        size--;  // Reducimos el tamaño de la lista
    }

    // Método para eliminar un nodo en una posición específica
    public void eliminarEnPosicion(int posicion) {
        if (posicion < 1 || posicion > size) {
            System.out.println("Posición inválida para eliminación");
            return;
        }
        if (posicion == 1) {
            eliminarInicio();  // Si es la primera posición, eliminamos el primer nodo
        } else if (posicion == size) {
            eliminarFinal();  // Si es la última posición, eliminamos el último nodo
        } else {
            Nodo actual = head;
            for (int i = 1; i < posicion; i++) {
                actual = actual.siguiente;  // Nos desplazamos hasta el nodo a eliminar
            }
            actual.anterior.siguiente = actual.siguiente;  // El nodo anterior apunta al siguiente
            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual.anterior;  // El siguiente nodo apunta al anterior
            }
            size--;  // Reducimos el tamaño de la lista
        }
    }

    // Método para revertir el orden de los nodos de la lista
    public void revertir() {
        Nodo actual = head;
        Nodo temp = null;
        while (actual != null) {
            temp = actual.anterior;
            actual.anterior = actual.siguiente;
            actual.siguiente = temp;
            actual = actual.anterior;
        }
        if (temp != null) {
            head = temp.anterior;  // Ahora el último nodo es el primero
        }
    }

    // MÉTODOS PROBLEMA 1 Y 4 (Invertir sublistas)

    // Método para invertir una sublista entre las posiciones a y b
    public void invertirSublista(int a, int b) {
        if (a >= b || a < 1 || b > size) return;

        // Extraer los valores de la sublista
        int[] valores = new int[b - a + 1];
        Nodo actual = head;
        for (int i = 1; i <= b; i++) {
            if (i >= a) {
                valores[i - a] = actual.clave;
            }
            actual = actual.siguiente;
        }

        // Colocar los valores en orden invertido
        actual = head;
        for (int i = 1; i <= b; i++) {
            if (i >= a) {
                actualizarValor(valores[b - i], i);
            }
            actual = actual.siguiente;
        }
    }

    // Método para invertir la lista en grupos de tamaño k
    public void invertirEnGrupos(int k) {
        if (k <= 1 || estaVacia()) return;

        int total = obtenerTamanio();
        for (int i = 1; i <= total; i += k) {
            int finGrupo = Math.min(i + k - 1, total);
            invertirSublista(i, finGrupo);
        }
    }

    // MÉTODOS PROBLEMA 2 (Restar dos listas)
    public int obtenerValor(int posicion) {
        if (posicion < 1 || posicion > size) {
            throw new IndexOutOfBoundsException("Posición inválida.");
        }
        Nodo actual = head;
        for (int i = 1; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.clave;
    }

    // Método para comparar dos listas
    public int comparar(ListaEnlazada otra) {
        if (this.size > otra.size) return 1;
        if (this.size < otra.size) return -1;

        Nodo actual1 = this.head;
        Nodo actual2 = otra.head;
        while (actual1 != null) {
            if (actual1.clave > actual2.clave) return 1;
            if (actual1.clave < actual2.clave) return -1;
            actual1 = actual1.siguiente;
            actual2 = actual2.siguiente;
        }
        return 0;  // Son iguales
    }

    // Método para restar dos listas representando números
    public ListaEnlazada restar(ListaEnlazada otra) {
        ListaEnlazada mayor, menor;
        if (this.comparar(otra) >= 0) {
            mayor = this;
            menor = otra;
        } else {
            mayor = otra;
            menor = this;
        }

        ListaEnlazada resultado = new ListaEnlazada();
        int prestamo = 0;

        for (int i = 1; i <= mayor.size; i++) {
            int posMayor = mayor.size - i + 1;
            int posMenor = menor.size - i + 1;

            int valorMayor = mayor.obtenerValor(posMayor);
            int valorMenor = (posMenor >= 1) ? menor.obtenerValor(posMenor) : 0;

            int resta = valorMayor - valorMenor - prestamo;

            if (resta < 0) {
                resta += 10;
                prestamo = 1;
            } else {
                prestamo = 0;
            }

            resultado.insertarInicio(resta);
        }

        // Eliminar ceros a la izquierda
        while (resultado.obtenerTamanio() > 1 && resultado.obtenerValor(1) == 0) {
            resultado.eliminarEnPosicion(1);
        }

        return resultado;
    }

    // MÉTODOS PROBLEMA 3 (Reordenar la lista)
    public void reordenar() {
        if (size <= 2) return;

        Nodo medio = head;
        Nodo fin = head;
        while (fin != null && fin.siguiente != null) {
            medio = medio.siguiente;
            fin = fin.siguiente.siguiente;  
        }

        Nodo segundaMitad = medio.siguiente;
        medio.siguiente = null;  
        segundaMitad = revertirLista(segundaMitad);

        Nodo primeraMitad = head;
        while (segundaMitad != null) {
            Nodo temp1 = primeraMitad.siguiente;
            Nodo temp2 = segundaMitad.siguiente;
            primeraMitad.siguiente = segundaMitad;
            segundaMitad.siguiente = temp1;
            primeraMitad = temp1;
            segundaMitad = temp2;
        }
    }

    // Método auxiliar para revertir una lista
    private Nodo revertirLista(Nodo nodo) {
        Nodo anterior = null;
        Nodo actual = nodo;
        while (actual != null) {
            Nodo siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        return anterior;
    }
}


