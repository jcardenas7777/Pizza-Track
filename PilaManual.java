/**
 * Clase PilaManual - Implementación de Pila (Stack) desde cero
 * usando una Lista Ligada de Nodos.
 *
 * RESTRICCIÓN: No usa java.util.Stack ni ninguna colección de Java.
 *
 * Métodos obligatorios:
 *   push()   - Inserta una Pizza en el tope.
 *   pop()    - Retira y devuelve la Pizza del tope.
 *   peek()   - Consulta el tope sin retirarlo.
 *   isEmpty()- Verifica si la pila está vacía.
 */
public class PilaManual {

    private Nodo tope; // Referencia al nodo en el tope de la pila
    private int tamanio;

    public PilaManual() {
        this.tope = null;
        this.tamanio = 0;
    }

    /**
     * Inserta una Pizza en el tope de la pila.
     *
     * @param pizza Objeto Pizza a insertar
     */
    public void push(Pizza pizza) {
        Nodo nuevo = new Nodo(pizza);//creamos el nodo nuevo con la pizza que se va a insertar
        nuevo.siguiente = tope;//el nuevo nodo apunta al nodo que actualmente es el tope
        tope = nuevo; //el nuevo nodo se convierte en el nuevo tope de la pila
        tamanio++;
    }

    /**
     * Retira y devuelve la Pizza del tope de la pila.
     *
     * @return Pizza retirada, o null si la pila está vacía
     */
    public Pizza pop() {
        if (isEmpty()) { //si la pila está vacía, no hay nada que retirar, por lo que se devuelve null
            return null;
        }
        Pizza pizzaRetirada = tope.pizza;//se guarda la pizza que se encuentra en el tope para devolverla después
        tope = tope.siguiente;//el tope se actualiza al siguiente nodo, retirando efectivamente el nodo que contenía la pizza retirada
        tamanio--;
        return pizzaRetirada;//se devuelve la pizza que se retiró del tope
    }

    /**
     * Devuelve la Pizza en el tope sin retirarla de la pila.
     *
     * @return Pizza en el tope, o null si la pila está vacía
     */
    public Pizza peek() {
        if (isEmpty()) {//si la pila está vacía, no hay un tope que consultar, por lo que se devuelve null
            return null;
        }
        return tope.pizza;//se devuelve la pizza que se encuentra en el tope sin modificar la pila
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si no hay elementos, false en caso contrario
     */
    public boolean isEmpty() {
        return tope == null;
    }

    /**
     * Devuelve la cantidad de elementos en la pila.
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * Muestra todos los pedidos en la pila (de tope a base).
     */
    public void mostrarTodos() {
        if (isEmpty()) {
            System.out.println("   (La pila está vacía)");
            return;
        }
        Nodo actual = tope;//se inicia la iteración desde el nodo que se encuentra en el tope de la pila
        int posicion = 1; //se utiliza una variable para llevar el conteo de la posición de cada nodo en la pila, comenzando desde 1 para el tope
        while (actual != null) {//mientras haya nodos en la pila, se muestra la pizza de cada nodo
            String etiqueta = (posicion == 1) ? " ← TOPE" : "";//se agrega una etiqueta para indicar cuál es el nodo que se encuentra en el tope de la pila
            System.out.println("   [" + posicion + "] " + actual.pizza + etiqueta);//se muestra la pizza del nodo actual junto con su posición en la pila y la etiqueta si es el tope
            actual = actual.siguiente;//se avanza al siguiente nodo en la pila
            posicion++;
        }
    }
}
