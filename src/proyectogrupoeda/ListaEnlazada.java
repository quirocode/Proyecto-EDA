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
    private Nodo head;
    private int size;

    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int obtenerTamanio() {
        return size;
    }

    public void mostrar() {
    if (estaVacia()) {
        System.out.println("Lista vacía");
        return;
    }
    Nodo actual = head;
    while (actual != null) {
        System.out.print(actual.clave);
        if (actual.siguiente != null) {
            System.out.print(" --> "); // Imprimir " --> " solo si hay un siguiente nodo
        }
        actual = actual.siguiente;
    }
    System.out.println(); // Para nueva línea después de mostrar la lista
}

    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = head;
        head = nuevo;
        size++;
    }

    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            head = nuevo;
        } else {
            Nodo actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        size++;
    }

    public void insertarEnPosicion(int valor, int posicion) {
        if (posicion < 1 || posicion > size + 1) {
            System.out.println("Posición inválida para inserción");
            return;
        }
        if (posicion == 1) {
            insertarInicio(valor);
        } else if (posicion == size + 1) {
            insertarFinal(valor);
        } else {
            Nodo nuevo = new Nodo(valor);
            Nodo actual = head;
            for (int i = 1; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            size++;
        }
    }

    public void actualizarValor(int valor, int posicion) {
        if (posicion < 1 || posicion > size) {
            System.out.println("Posición inválida para actualización");
            return;
        }
        Nodo actual = head;
        for (int i = 1; i < posicion; i++) {
            actual = actual.siguiente;
        }
        actual.clave = valor;
    }

    public void eliminarInicio() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        head = head.siguiente;
        size--;
    }

    public void eliminarFinal() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        if (head.siguiente == null) {
            head = null;
        } else {
            Nodo actual = head;
            while (actual.siguiente.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
        }
        size--;
    }

    public void eliminarEnPosicion(int posicion) {
        if (posicion < 1 || posicion > size) {
            System.out.println("Posición inválida para eliminación");
            return;
        }
        if (posicion == 1) {
            eliminarInicio();
        } else {
            Nodo actual = head;
            for (int i = 1; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
            size--;
        }
    }

    public void revertir() {
        Nodo anterior = null;
        Nodo actual = head;
        Nodo siguiente;
        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }
    
    //MÉTODOS PROBLEMA 1
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
    
    public void invertirEnGrupos(int k) {
    if (k <= 1 || estaVacia()) return;

    int total = obtenerTamanio();
    for (int i = 1; i <= total; i += k) {
        int finGrupo = Math.min(i + k - 1, total);
        invertirSublista(i, finGrupo);
    }
}
    //MÉTODOS PROBLEMA 2
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
    return 0; // Son iguales
}

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

    //MÉTODOS PROBLEMA 3
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

