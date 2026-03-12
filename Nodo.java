/**
 * Clase Nodo - Representa cada eslabón de la lista ligada.
 * Almacena un objeto Pizza y la referencia al siguiente nodo.
 */
public class Nodo {

    Pizza pizza;
    Nodo siguiente;

    public Nodo(Pizza pizza) {
        this.pizza = pizza;
        this.siguiente = null;
    }
}
